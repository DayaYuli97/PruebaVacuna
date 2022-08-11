package ec.com.pry.demokruger.client.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity Vaccine.
 * @author Yuli.
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "VACCINE")
public class VaccineEntity {
    private static final long serialVersionUID = -1821928956548576869L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID_VACCINE", nullable = false)
    private String idVaccine;

    @Column(name = "ID_EMPLOYES")
    private String idEmployes;

    @Column(name = "VACCINE")
    private String vaccine;

    @Column(name = "DATE_VACCINE")
    private Date dateVaccine;

    @Column(name = "DOSE_VACCINE")
    private String doseVaccine;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EMPLOYES", referencedColumnName = "ID_EMPLOYES", insertable = false, updatable = false)
    private EmployeesEntity employeesEntity;

}
