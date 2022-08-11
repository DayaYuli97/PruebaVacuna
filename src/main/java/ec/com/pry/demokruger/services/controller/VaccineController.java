package ec.com.pry.demokruger.services.controller;

import ec.com.pry.demokruger.client.service.IVaccineService;
import ec.com.pry.demokruger.vo.VaccineVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Controller Vaccine.
 * @author Yuli.
 */
@RestController
@RequestMapping("/api/vaccine")
public class VaccineController {
    @Autowired
    private IVaccineService service;

    /**
     * WS crear vacunas.
     * @param vaccineVO vaccineVO
     * @return boolean
     */
    @PostMapping("/create")
    public boolean createVaccine(@RequestBody VaccineVO vaccineVO){
        service.saveVaccine(vaccineVO);
        return true;
    }

    /**
     * WS listar empleados por tipo vacuna.
     * @param vaccineType String
     * @return list vaccineVO.
     */
    @PostMapping("/findEmployeesByVaccine")
    public List<VaccineVO> findEmployeesByVaccine(@RequestBody String vaccineType){
        return service.findEmployeesByVaccine(vaccineType);
    }

    /**
     * WS listar empleados por fecha de vacuna.
     * @param dateVaccineStart String
     * @param dateVaccineEnd String
     * @return list vaccineVO.
     * @throws ParseException
     */
    @GetMapping("/findEmployeesByDateVaccine")
    public List<VaccineVO> findEmployeesByVaccine(@RequestParam("dateVaccineStart") String dateVaccineStart, @RequestParam("dateVaccineEnd") String dateVaccineEnd) throws ParseException {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse(dateVaccineStart);
        Date end = sdf.parse(dateVaccineEnd);
        return service.findEmployeesByDateVaccine(start, end);
    }

}
