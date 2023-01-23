package com.example.springboot.users.service;

import com.example.springboot.users.pojo.entity.Userrs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Userservice {
    public List<Userrs> getAll();
    public void Insert_User_Info(Userrs userrs);
}
