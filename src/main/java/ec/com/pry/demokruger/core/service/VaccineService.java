package ec.com.pry.demokruger.core.service;

import ec.com.pry.demokruger.client.entity.VaccineEntity;
import ec.com.pry.demokruger.client.repository.IVaccineRepository;
import ec.com.pry.demokruger.client.service.IVaccineService;
import ec.com.pry.demokruger.vo.VaccineVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

/**
 * Vaccine Service.
 * @author Yuli.
 */
@Transactional("jpaTransactionManager")
@Validated
@Lazy
@Service
public class VaccineService implements IVaccineService {

    @Autowired
    private IVaccineRepository repository;

    /**
     *{@inheritDoc}
     */
    @Override
    public void saveVaccine(VaccineVO vaccineVO) {
        if(vaccineVO !=null ) {
            VaccineEntity entity = new VaccineEntity();

            entity.setIdEmployes(vaccineVO.getIdEmployes());
            entity.setVaccine(vaccineVO.getVaccine());
            entity.setDateVaccine(vaccineVO.getDateVaccine());
            entity.setDoseVaccine(vaccineVO.getDoseVaccine());
            repository.saveVaccine(entity);
        }else{
            System.out.println("no se puede realizar porque vacuna es nulo");
        }
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public List<VaccineVO> findEmployeesByVaccine(String vaccineType) {
        return repository.findEmployeesByVaccine(vaccineType);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public List<VaccineVO> findEmployeesByDateVaccine(Date dateVaccineStart, Date dateVaccineEnd) {
        return repository.findEmployeesByDateVaccine(dateVaccineStart, dateVaccineEnd);
    }


}
