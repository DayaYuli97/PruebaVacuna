package ec.com.pry.demokruger.client.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Entity Employees.
 * @author Yuli.
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EMPLOYES")
public class EmployeesEntity {
    private static final long serialVersionUID = -2668358477197676632L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID_EMPLOYES", nullable = false)
    private String idEmployes;

    @Column(name = "IDCARD")
    private String idCard;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "DATE_BIRTH")
    private Date dateBirth;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CELLPHONE")
    private String cellphone;

    @Column(name = "VACCINE_STATUS")
    private String vaccineStatus;

    @Column(name = "USERNAME")
    private String usser;

    @Column(name = "PASS")
    private String pass;

    @Column(name = "STATUS")
    private Boolean status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employeesEntity")
    private List<VaccineEntity> vaccineEntities;

}
