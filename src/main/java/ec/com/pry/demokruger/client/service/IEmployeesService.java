package ec.com.pry.demokruger.client.service;

import ec.com.pry.demokruger.vo.EmployeesVO;
import java.util.List;

/**
 * Interface Employees Service.
 * @author Yuli.
 */
public interface IEmployeesService {

    /**
     * Metodo para guardar empleados.
     * @param employeesVO employeesVO
     */
    void saveEmployees(EmployeesVO employeesVO);

    /**
     * Metodo para actualizar empleados.
     * @param employeesVO employeesVO
     */
    void updateEmployees(EmployeesVO employeesVO);

    /**
     * Metodo para listar empleados.
     * @return list EmployeesVO.
     */
    List<EmployeesVO> findAllEmployees();

    /**
     * Metodo para listar empleados por id.
     * @param idEmployes String
     * @return EmployeesVO.
     */
    EmployeesVO findAllEmployeesById(String idEmployes);

    /**
     * Metodo para cambiar estado empleado activo/inactivo.
     * @param employeesVO employeesVO
     */
    void changeStatusEmployees (EmployeesVO employeesVO);

    /**
     * Metodo para listar empleados por estado de vacuna.
     * @param statusVaccine String
     * @return EmployeesVO.
     */
    List<EmployeesVO>  findByStatusVaccine(String statusVaccine);

    /**
     * Metodo para actualizat datos de empleados.
     * @param employeesVO employeesVO
     */
    void updateDatosEmployees(EmployeesVO employeesVO);

}
