package com.example.springboot.users.service.impl;

import com.example.springboot.users.pojo.entity.Userrs;
import com.example.springboot.users.repository.Userrepository;
import com.example.springboot.users.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userserviceimpl implements Userservice {
    private final Userrepository userrepository;
    @Autowired
    public  Userserviceimpl(Userrepository userrepository)
    {
        this.userrepository=userrepository;
    }
    @Override
    public List<Userrs> getAll() {
        List<Userrs> list=null;
        list=userrepository.findAll();
        return  list;
    }

    @Override
    public void Insert_User_Info(Userrs userrs) {
        userrepository.save(userrs);
    }
}
