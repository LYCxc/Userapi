package com.example.springboot.users.repository;

import com.example.springboot.users.pojo.entity.Userrs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<Userrs,Long> {
}
