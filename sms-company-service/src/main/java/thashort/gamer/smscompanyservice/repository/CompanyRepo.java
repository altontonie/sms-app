package thashort.gamer.smscompanyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thashort.gamer.smscompanyservice.entity.dao.CompanyDAO;
import thashort.gamer.smscompanyservice.entity.dto.CompanyDTO;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyDAO, Integer> {
    CompanyDAO findByCompanyid(String id);
}
