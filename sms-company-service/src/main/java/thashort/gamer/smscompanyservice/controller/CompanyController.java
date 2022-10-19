package thashort.gamer.smscompanyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thashort.gamer.smscompanyservice.entity.dto.CompanyDTO;
import thashort.gamer.smscompanyservice.service.CompanyService;

import java.util.List;

@RequestMapping(path = "/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping()
    public ResponseEntity<List<CompanyDTO>> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable String id){
        return companyService.getCompany(id);
    }

    @PostMapping()
    public ResponseEntity<CompanyDTO> addCompany(@RequestBody CompanyDTO companyDTO){
        return companyService.addCompany(companyDTO);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable String id, @RequestBody CompanyDTO companyDTO ){
        return companyService.updateCompany(id,companyDTO);
    }

    @PutMapping(path = "/{id}/{sub}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable String id, @PathVariable String sub ){
        return companyService.updateCompanySub(id,sub);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable String id){
        return companyService.deleteCompany(id);
    }


}
