package ec.com.pry.demokruger.client.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity Admin.
 * @author Yuli.
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ADMIN")
public class AdminEntity {
    private static final long serialVersionUID = -1790227661651184914L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID_ADMIN", nullable = false)
    private String idAdmin;

    @Column(name = "USSER")
    private String usser;

    @Column(name = "PASS")
    private String pass;

}
