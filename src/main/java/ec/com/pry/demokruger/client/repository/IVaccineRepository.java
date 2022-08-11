package ec.com.pry.demokruger.client.repository;

import ec.com.pry.demokruger.client.entity.VaccineEntity;
import ec.com.pry.demokruger.client.repository.configuration.IConfigJPAPersistence;
import ec.com.pry.demokruger.vo.VaccineVO;

import java.util.Date;
import java.util.List;

/**
 * Interface Vaccine Repository.
 * @author Yuli.
 */

public interface IVaccineRepository extends IConfigJPAPersistence<VaccineEntity> {

    /**
     * Metodo para guadar Tipos de Vacunas.
     * @param vaccineEntity vaccineEntity
     */
    void saveVaccine(VaccineEntity vaccineEntity);

    /**
     * Metodo para listar empleados por tipo de vacuna.
     * @param vaccineType String
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
