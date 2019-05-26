package com.example.jpa;

import com.example.jpa.model.dto.CountryDTO;
import com.example.jpa.model.dto.RegionDTO;
import com.example.jpa.model.dto.StateDTO;
import com.example.jpa.service.CountryService;
import javax.swing.plaf.nimbus.State;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {

  @Autowired private CountryService countryService;

  @Test
  public void contextLoads() {
    // bulidCountry();
    // findCountrys();
    this.countryService.deleteAll();
  }

  public void bulidCountry() {
    StateDTO stateDTO =
        StateDTO.builder()
            .name("新加坡")
            .shortName("SG")
            .region(RegionDTO.builder().name("全国").shortName("ALL").regionCode("ALL").build())
            .build();

    CountryDTO countryDTO =
        CountryDTO.builder()
            .name("SINGAPORE")
            .shortName("SG")
            .countryCode("SG")
            .states(Lists.newArrayList(stateDTO))
            .build();

    this.countryService.createCountry(countryDTO);
  }

  public void findCountrys() {
    this.countryService.findCountrys().stream()
        .forEach(
            countryEntity -> {
              System.err.println(countryEntity.toString());
            });
  }
}
