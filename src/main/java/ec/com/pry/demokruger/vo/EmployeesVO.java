package ec.com.pry.demokruger.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesVO {
    private String idEmployes;
    private String idCard;
    private String name;
    private String lastname;
    private String mail;
    private Date dateBirth;
    private String address;
    private String cellphone;
    private String vaccineStatus;
    private String usser;
    private String pass;
    private Boolean status;
    private VaccineVO vaccineVO;
}
