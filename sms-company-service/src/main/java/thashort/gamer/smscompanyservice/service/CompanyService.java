package thashort.gamer.smscompanyservice.service;

import org.springframework.http.ResponseEntity;
import thashort.gamer.smscompanyservice.entity.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {
    ResponseEntity<List<CompanyDTO>> getAllCompanies();

    ResponseEntity<CompanyDTO> getCompany(String id);

    ResponseEntity<CompanyDTO> addCompany(CompanyDTO companyDTO);

    ResponseEntity<CompanyDTO> updateCompany(String id, CompanyDTO companyDTO);

    ResponseEntity<String> deleteCompany(String id);

    ResponseEntity<CompanyDTO> updateCompanySub(String id, String sub);
}
