package dbSample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")

public class City {
//プロパティ
    @Id
    @Column(name="ID")
    private Integer id;
    
    @Column(name="Name")
    private String name;
    
    @Column(name="CountryCode")
    private String countrycode;
    
    @Column(name="District")
    private String district;
    
    @Column(name="population");
    private int population;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id=id;
    }
    public String getName() {
        return name;
        
    }
    public void setName(String name) {
       this.countrycode=countrycode;
    }
    public void setDistrict(String district) {
        this.district=district;
    }
    public int get Population() {
        return population;
    }
    public void setPoulation(int population) {
        this.population=population;
    }
}
    
