package com.spring.first.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.first.service.NodeService;
import com.spring.first.dao.NodeDao;
import com.spring.first.domain.Node;

import java.util.List;

@Service
public class NodeServiceImpl implements NodeService{
    @Autowired
    private NodeDao nodeDao;

    public void save(Node node){

        nodeDao.save(node);
    }

    public List<Node> findByNameLike(String name){

        return nodeDao.findByNameLike(name);
    }

    public List<Node> selectNodes(String querystr){
        return nodeDao.selectNodes(querystr);
    }

}
