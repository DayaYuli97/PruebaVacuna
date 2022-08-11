package ec.com.pry.demokruger.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminVO {
    private String idAdmin;
    private String usser;
    private String pass;
}
