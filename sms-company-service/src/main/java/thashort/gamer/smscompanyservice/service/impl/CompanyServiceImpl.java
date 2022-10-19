package thashort.gamer.smscompanyservice.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import thashort.gamer.smscompanyservice.entity.dao.CompanyDAO;
import thashort.gamer.smscompanyservice.entity.dto.CompanyDTO;
import thashort.gamer.smscompanyservice.repository.CompanyRepo;
import thashort.gamer.smscompanyservice.service.CompanyService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepo companyRepo;


    @Override
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        List<CompanyDTO> companyDTO = new ArrayList<>();
        List<CompanyDAO> companyDAO = companyRepo.findAll();
        for (CompanyDAO data :
                companyDAO) {
            CompanyDTO dto = new CompanyDTO();
            BeanUtils.copyProperties(data,dto);
            companyDTO.add(dto);
        }
        return ResponseEntity.ok(companyDTO);
    }

    @Override
    public ResponseEntity<CompanyDTO> getCompany(String id) {
        CompanyDTO dto = new CompanyDTO();
        CompanyDAO companyDAO = companyRepo.findByCompanyid(id);
        BeanUtils.copyProperties(companyDAO,dto);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<CompanyDTO> addCompany(CompanyDTO companyDTO) {
        CompanyDTO data = new CompanyDTO();
        CompanyDAO companyDAO = new CompanyDAO();
        BeanUtils.copyProperties(companyDTO,companyDAO);
        String uniqueId = UUID.randomUUID().toString();
        companyDAO.setCompanyid(uniqueId);

        CompanyDAO result = companyRepo.save(companyDAO);
        BeanUtils.copyProperties(result,data);
        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<CompanyDTO> updateCompany(String id, CompanyDTO companyDTO) {
        CompanyDAO companyDAO = companyRepo.findByCompanyid(id);
        companyDAO.setCompany_name(companyDTO.getCompany_name());
        companyDAO.setSubscription(companyDTO.getSubscription());

        final CompanyDAO result = companyRepo.save(companyDAO);
        CompanyDTO dto = new CompanyDTO();
        BeanUtils.copyProperties(result,dto);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<String> deleteCompany(String id) {
        CompanyDAO companyDAO = companyRepo.findByCompanyid(id);
        try {
            companyRepo.delete(companyDAO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(403).body("Could not delete company");
        }
        return ResponseEntity.ok("Successful");
    }

    @Override
    public ResponseEntity<CompanyDTO> updateCompanySub(String id, String sub) {
        CompanyDAO companyDAO = companyRepo.findByCompanyid(id);
        companyDAO.setSubscription(sub);

        final CompanyDAO result = companyRepo.save(companyDAO);
        CompanyDTO dto = new CompanyDTO();
        BeanUtils.copyProperties(result,dto);

        return ResponseEntity.ok(dto);
    }
}
