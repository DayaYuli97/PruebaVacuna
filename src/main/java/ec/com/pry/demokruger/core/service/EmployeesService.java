package ec.com.pry.demokruger.core.service;

import ec.com.pry.demokruger.client.entity.EmployeesEntity;
import ec.com.pry.demokruger.client.repository.IEmployeesRepository;
import ec.com.pry.demokruger.client.service.IEmployeesService;
import ec.com.pry.demokruger.client.service.IVaccineService;
import ec.com.pry.demokruger.vo.EmployeesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Employees Service.
 * @author Yuli.
 */
@Transactional("jpaTransactionManager")
@Validated
@Lazy
@Service
public class EmployeesService implements IEmployeesService {
    private final String VACUNADO= "SI";
    private final String NO_VACUNADO= "NO";

    @Autowired
    private IEmployeesRepository repository;
    @Autowired
    private IVaccineService iVaccineService;

    /**
     *{@inheritDoc}
     */
    @Override
    public void saveEmployees(EmployeesVO employeesVO) {
        EmployeesEntity entity = new EmployeesEntity();
        entity.setName(employeesVO.getName());
        entity.setLastname(employeesVO.getLastname());
        entity.setIdCard(employeesVO.getIdCard());
        entity.setMail(employeesVO.getMail());
        entity.setStatus(true);
        entity.setPass(employeesVO.getIdCard());
        String username = employeesVO.getMail().split("@")[0];
        entity.setUsser(username);
        repository.saveEmployees(entity);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void updateEmployees(EmployeesVO employeesVO) {
        if(employeesVO.getIdEmployes()!=null){
            EmployeesEntity entity = new EmployeesEntity();
            entity.setIdEmployes(employeesVO.getIdEmployes());
            entity.setIdCard(employeesVO.getIdCard());
            entity.setName(employeesVO.getName());
            entity.setLastname(employeesVO.getLastname());
            entity.setMail(employeesVO.getMail());
            repository.updateEmployees(entity);
        }else {
            System.out.println("No existe el empleado");
        }
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public List<EmployeesVO> findAllEmployees() {
        return repository.findAllEmployees();
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public EmployeesVO findAllEmployeesById(String idEmployes) {
        return repository.findAllEmployeesById(idEmployes);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public List<EmployeesVO>  findByStatusVaccine(String statusVaccine) {
        return repository.findByStatusVaccine(statusVaccine);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void changeStatusEmployees(EmployeesVO employeesVO) {
        if (employeesVO != null) {
            EmployeesEntity employeesEntity = new EmployeesEntity();
            employeesEntity.setIdEmployes(employeesVO.getIdEmployes());
            employeesEntity.setStatus(employeesVO.getStatus());
            repository.changeStatusEmployees(employeesEntity);
        } else {
            System.out.println("no existe");
        }
    }

    /**
     * ----------------Servicio Empleados--------------
     * **/

    /**
     *{@inheritDoc}
     */
    @Override
    public void updateDatosEmployees(EmployeesVO employeesVO) {

        if (employeesVO.getIdEmployes() != null) {

            EmployeesEntity entity = new EmployeesEntity();
            entity.setIdEmployes(employeesVO.getIdEmployes());
            entity.setDateBirth(employeesVO.getDateBirth());
            entity.setAddress(employeesVO.getAddress());
            entity.setCellphone(employeesVO.getCellphone());
            entity.setVaccineStatus(employeesVO.getVaccineStatus());
            repository.updateDatosEmployees(entity);
            if(entity.getVaccineStatus().equals(VACUNADO) && employeesVO.getVaccineVO() !=null ){
                employeesVO.getVaccineVO().setIdEmployes(entity.getIdEmployes());
                iVaccineService.saveVaccine(employeesVO.getVaccineVO());
            }
        } else {
            System.out.println("No existe el empleado");
        }
    }


}
