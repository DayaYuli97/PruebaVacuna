package ec.com.pry.demokruger.services.controller;

import ec.com.pry.demokruger.client.service.IEmployeesService;
import ec.com.pry.demokruger.vo.EmployeesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller Employees.
 * @author Yuli.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
    @Autowired
    private IEmployeesService service;

    /**
     * WS Crear Empleados.
     * @param employeesVO employesVO
     * @return boolean
     */
    @PostMapping("/create")
    public Boolean createEmployees(@RequestBody EmployeesVO employeesVO){
        service.saveEmployees(employeesVO);
        return true;

    }

    /**
     * WS actualizar empleados.
     * @param employeesVO employeesVO
     * @return boolean
     */
    @PostMapping("/update")
    public boolean updateEmployees(@RequestBody EmployeesVO employeesVO){
        service.updateEmployees(employeesVO);
        return true;
    }

    /**
     * WS listar empleados.
     * @return list EmployeesVO.
     */
    @GetMapping("/findAllEmployees")
    public List<EmployeesVO> findAllEmployees(){
        return service.findAllEmployees();
    }

    /**
     * WS listar empleados por id.
     * @param idEmployes String
     * @return EmployeesVO.
     */
    @PostMapping("/findEmployeesById")
    public EmployeesVO findEmployeesById(@RequestBody String idEmployes){
        return service.findAllEmployeesById(idEmployes);
    }

    /**
     * WS listar empleados por estado de vacuna.
     * @param statusVaccine String
     * @return list EmployeesVO.
     */
    @PostMapping("/findByStatusVaccine")
    public List<EmployeesVO>  findByStatusVaccine(@RequestBody String statusVaccine){
        return service.findByStatusVaccine(statusVaccine);
    }

    /**
     * WS active/inactive empleados.
     * @param employeesVO employeesVO
     * @return boolean
     */
    @PostMapping("/inactiveEmployees")
    public boolean changeStatusEmpresa(@RequestBody EmployeesVO employeesVO) {
        service.changeStatusEmployees(employeesVO);
        return true;
    }

    /**
     * WS actualizar datos empleados.
     * @param employeesVO employeesVO
     * @return boolean
     */
    @PostMapping("/updateDateEmployees")
    public boolean updateDatosEmployees(@RequestBody EmployeesVO employeesVO){
        service.updateDatosEmployees(employeesVO);
        return true;
    }

}
