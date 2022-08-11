package ec.com.pry.demokruger.client.service;

import ec.com.pry.demokruger.vo.VaccineVO;

import java.util.Date;
import java.util.List;

/**
 * Interface Vaccine Service.
 * @author Yuli.
 */
public interface IVaccineService {

    /**
     * Metodo para guardar Tipos de Vacunas.
     * @param vaccineVO vaccineVO
     */
    void saveVaccine(VaccineVO vaccineVO);

    /**
     * Metodo para listar empleados por tipo de vacuna.
     * @param vaccineType vaccineType
     * @return VaccineVO.
     */
    List<VaccineVO> findEmployeesByVaccine(String vaccineType);

    /**
     * Metodo para listar empleados por fecha de vacunacion.
     * @param dateVaccineStart Date
     * @param dateVaccineEnd Date
     * @return VaccineVO.
     */
    List<VaccineVO> findEmployeesByDateVaccine(Date dateVaccineStart, Date dateVaccineEnd);
}
