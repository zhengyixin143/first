package com.spring.first.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.function.Predicate;

import com.spring.first.domain.Node;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public interface NodeDao extends CrudRepository<Node,Long> {

    //根据编号查询
    public Node findById(long id);

    @Query(value = "select * from node where name like %?1%",nativeQuery = true)
    @Modifying
    public List<Node> findByNameLike(String name);

    @Query(value="select * from node where ?1 ",nativeQuery = true)
    @Modifying
    public List<Node> selectNodes(String querystr);




}
