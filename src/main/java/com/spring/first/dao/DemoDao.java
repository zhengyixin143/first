package com.spring.first.dao;
import com.spring.first.domain.Demo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



public interface DemoDao extends JpaRepository<Demo, Long>{

    /**
     * Find by name.
     *
     * @param name the name
     * @return the user
     */

    public  Demo findByTname(String tname);





}
