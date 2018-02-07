package com.SimpleStore.Dao;

import com.SimpleStore.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CountryDao extends JpaRepository<Country, Integer>{

}
