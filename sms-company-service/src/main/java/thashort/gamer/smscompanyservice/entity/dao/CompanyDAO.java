package thashort.gamer.smscompanyservice.entity.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "company")
public class CompanyDAO {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name = "companyid", unique = true)
    private String companyid;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "subscription")
    private String subscription;

}
