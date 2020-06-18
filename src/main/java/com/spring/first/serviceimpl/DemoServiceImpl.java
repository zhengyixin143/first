package com.spring.first.serviceimpl;


import com.spring.first.domain.Demo;
import com.spring.first.dao.DemoDao;
import com.spring.first.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoDao demoDao;

    public void save(Demo demo){

        demoDao.save(demo);
    }
    public Demo getDemoByTname(String tname){
        return demoDao.findByTname(tname);
    }


}
