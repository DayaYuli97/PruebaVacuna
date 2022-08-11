package ec.com.pry.demokruger.core.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import ec.com.pry.demokruger.client.entity.QEmployeesEntity;
import ec.com.pry.demokruger.client.entity.QVaccineEntity;
import ec.com.pry.demokruger.client.entity.VaccineEntity;
import ec.com.pry.demokruger.client.repository.IVaccineRepository;
import ec.com.pry.demokruger.core.repository.configuration.ConfigJPAPersistence;
import ec.com.pry.demokruger.vo.VaccineVO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Vaccine Repository.
 * @author Yuli.
 */
@Lazy
@Repository
public class VaccineRepository extends ConfigJPAPersistence<VaccineEntity> implements IVaccineRepository {

    /**
     * Constructor.
     */
    public VaccineRepository() {
        super(VaccineEntity.class);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void saveVaccine(VaccineEntity vaccineEntity) {
        save(vaccineEntity);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public List<VaccineVO> findEmployeesByVaccine(String vaccineType) {
        QVaccineEntity qVaccine= QVaccineEntity.vaccineEntity;
        QEmployeesEntity qEmployees= QEmployeesEntity.employeesEntity;
        JPQLQuery<VaccineVO> query = from(qVaccine)
                .innerJoin(qVaccine.employeesEntity,qEmployees)
                .select(
                        Projections.bean(VaccineVO.class,
                                qVaccine.idEmployes,
                                qVaccine.vaccine,
                                qVaccine.dateVaccine,
                                qVaccine.doseVaccine,
                                qEmployees.name.as("name"),
                                qEmployees.lastname.as("lastname"),
                                qEmployees.idCard.as("idCard"),
                                qEmployees.address.as("address")
                        ));
        BooleanBuilder where= new BooleanBuilder();
        where.and(qVaccine.vaccine.eq(vaccineType));
        query.where(where);

        return query.fetch();
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public List<VaccineVO> findEmployeesByDateVaccine (Date dateVaccineStart, Date dateVaccineEnd) {
        QVaccineEntity qVaccine= QVaccineEntity.vaccineEntity;
        QEmployeesEntity qEmployees= QEmployeesEntity.employeesEntity;
        JPQLQuery<VaccineVO> query = from(qVaccine)
                .innerJoin(qVaccine.employeesEntity,qEmployees)
                .select(
                        Projections.bean(VaccineVO.class,
                                qVaccine.idEmployes,
                                qVaccine.vaccine,
                                qVaccine.dateVaccine,
                                qVaccine.doseVaccine,
                                qEmployees.name.as("name"),
                                qEmployees.lastname.as("lastname"),
                                qEmployees.idCard.as("idCard"),
                                qEmployees.address.as("address")
                        ));
        BooleanBuilder where= new BooleanBuilder();
        where.and(qVaccine.dateVaccine.between(dateVaccineStart, dateVaccineEnd));
        query.where(where);

        return query.fetch();
    }

}
