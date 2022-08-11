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
public class VaccineVO {
    private String idVaccine;
    private String idEmployes;
    private String vaccine;
    private Date dateVaccine;
    private String doseVaccine;
    private String name;
    private String lastname;
    private String idCard;
    private String address;
}
