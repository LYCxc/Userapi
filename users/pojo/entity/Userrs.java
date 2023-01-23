package com.example.springboot.users.pojo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name="USERS")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Userrs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name="FIRST_NAME")
    String First_name;

    @Column(name="LAST_NAME")
    String Last_Name;

    @Column(name="DOB")
    Date date;
    @Column(name="Middle_NAME")
    String Middle_name;


}
