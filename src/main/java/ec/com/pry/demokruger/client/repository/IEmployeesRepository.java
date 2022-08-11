package ec.com.pry.demokruger.client.repository;

import ec.com.pry.demokruger.client.entity.EmployeesEntity;
import ec.com.pry.demokruger.client.repository.configuration.IConfigJPAPersistence;
import ec.com.pry.demokruger.vo.EmployeesVO;

import java.util.List;

/**
 * Interface Employees Repository.
 * @author Yuli.
 */

public interface IEmployeesRepository extends IConfigJPAPersistence<EmployeesEntity> {


    /**
     * Metodo para guardar datos de Empleados.
     * @param employeesEntity employesEntity.
     */
    void saveEmployees(EmployeesEntity employeesEntity);

    /**
     * Metodo para actualizar datos de Empleados.
     * @param employeesEntity employeesEntity.
     */
    void updateEmployees(EmployeesEntity employeesEntity);

    /**
     * Metodo para retornar la lista de todos los Empleados.
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
     * Metodo para cambiar de estado a Empleado Activo/Inactivo.
     * @param employeesEntity employeesEntity
     */
    void changeStatusEmployees (EmployeesEntity employeesEntity);

    /**
     * Metodo para listar empleados por estado de vacunacion.
     * @param statusVaccine String
     * @return EmployeesVO.
     */
    List<EmployeesVO> findByStatusVaccine(String statusVaccine);


    /**
     * Metodo para actualizar datos del empleado.
     * @param employeesEntity employeesEntity
     */
    void updateDatosEmployees(EmployeesEntity employeesEntity);



}
