package com.spring.first.service;
import com.spring.first.domain.Node;

import java.util.List;

public interface NodeService {
    public void save(Node node);

    public List<Node> findByNameLike(String name);

    public List<Node> selectNodes(String querystr);
}
