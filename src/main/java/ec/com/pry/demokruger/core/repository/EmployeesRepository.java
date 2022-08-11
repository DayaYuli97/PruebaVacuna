package ec.com.pry.demokruger.core.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import ec.com.pry.demokruger.client.entity.EmployeesEntity;
import ec.com.pry.demokruger.client.entity.QEmployeesEntity;
import ec.com.pry.demokruger.client.repository.IEmployeesRepository;
import ec.com.pry.demokruger.core.repository.configuration.ConfigJPAPersistence;
import ec.com.pry.demokruger.vo.EmployeesVO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Employees Repository.
 * @author Yuli.
 */
@Lazy
@Repository
public class EmployeesRepository extends ConfigJPAPersistence<EmployeesEntity> implements IEmployeesRepository {

    /**
     * Constructor.
     */
    public EmployeesRepository() {
        super(EmployeesEntity.class);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void saveEmployees(EmployeesEntity employeesEntity) {
        save(employeesEntity);

    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void updateEmployees(EmployeesEntity employeesEntity) {
        QEmployeesEntity qEmployees= QEmployeesEntity.employeesEntity;
        update(qEmployees)
                .where(qEmployees.idEmployes.eq(employeesEntity.getIdEmployes()))
                .set(qEmployees.idCard, employeesEntity.getIdCard())
                .set(qEmployees.name, employeesEntity.getName())
                .set(qEmployees.lastname, employeesEntity.getLastname())
                .set(qEmployees.mail, employeesEntity.getMail())
                .execute();
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public List<EmployeesVO> findAllEmployees() {
        QEmployeesEntity qEmployees= QEmployeesEntity.employeesEntity;
        JPQLQuery<EmployeesVO> query =from(qEmployees).select(

                Projections.bean(EmployeesVO.class,
                        qEmployees.idEmployes,
                        qEmployees.idCard,
                        qEmployees.name,
                        qEmployees.lastname,
                        qEmployees.mail,
                        qEmployees.dateBirth,
                        qEmployees.address,
                        qEmployees.cellphone,
                        qEmployees.vaccineStatus,
                        qEmployees.usser,
                        qEmployees.status
                )
        );
        query.orderBy(qEmployees.lastname.asc());
        return query.fetch();
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public EmployeesVO findAllEmployeesById(String idEmployes) {
        QEmployeesEntity qEmployees= QEmployeesEntity.employeesEntity;
        JPQLQuery<EmployeesVO> query =from(qEmployees).select(
                Projections.bean(EmployeesVO.class,
                        qEmployees.idEmployes,
                        qEmployees.idCard,
                        qEmployees.name,
                        qEmployees.lastname,
                        qEmployees.mail,
                        qEmployees.dateBirth,
                        qEmployees.address,
                        qEmployees.cellphone,
                        qEmployees.vaccineStatus,
                        qEmployees.status
                ));
        BooleanBuilder where = new BooleanBuilder();
        where.and(qEmployees.status.isTrue())
                .and(qEmployees.idEmployes.eq(idEmployes));
        query.where(where);
    return query.fetchOne();

    }

    /**
     *{@inheritDoc}
     */
    @Override
    public  List<EmployeesVO> findByStatusVaccine(String statusVaccine) {
        QEmployeesEntity qEmployees= QEmployeesEntity.employeesEntity;
        JPQLQuery<EmployeesVO> query =from(qEmployees).select(
                Projections.bean(EmployeesVO.class,
                        qEmployees.idEmployes,
                        qEmployees.idCard,
                        qEmployees.name,
                        qEmployees.lastname,
                        qEmployees.mail,
                        qEmployees.dateBirth,
                        qEmployees.address,
                        qEmployees.cellphone,
                        qEmployees.vaccineStatus,
                        qEmployees.usser,
                        qEmployees.status));
        BooleanBuilder where = new BooleanBuilder();
        if (statusVaccine != null) {
            where.and(qEmployees.vaccineStatus.eq(statusVaccine));
            query.where(where);
        }


        return query.fetch();
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void changeStatusEmployees(EmployeesEntity employeesEntity) {
        QEmployeesEntity qEmployees= QEmployeesEntity.employeesEntity;
        update(qEmployees)
                .where(qEmployees.idEmployes.eq(employeesEntity.getIdEmployes()))
                .set(qEmployees.status, employeesEntity.getStatus())
                .execute();
    }


    /**
     *{@inheritDoc}
     */
    @Override
    public void updateDatosEmployees(EmployeesEntity employeesEntity) {
        QEmployeesEntity qEmployees= QEmployeesEntity.employeesEntity;
        update(qEmployees)
                .where(qEmployees.idEmployes.eq(employeesEntity.getIdEmployes()))
                .set(qEmployees.dateBirth, employeesEntity.getDateBirth())
                .set(qEmployees.address, employeesEntity.getAddress())
                .set(qEmployees.cellphone, employeesEntity.getCellphone())
                .set(qEmployees.vaccineStatus, employeesEntity.getVaccineStatus())
                .execute();
    }


}
