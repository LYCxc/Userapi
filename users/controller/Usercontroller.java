package com.example.springboot.users.controller;

import com.example.springboot.users.pojo.entity.Userrs;
import com.example.springboot.users.service.impl.Userserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class Usercontroller {

    private  final Userserviceimpl userserviceimpl;
    @Autowired
    public Usercontroller(Userserviceimpl userserviceimpl)
    {
        this.userserviceimpl=userserviceimpl;
    }
    @RequestMapping()
    @ResponseBody
    public List<Userrs> getAll()
    {
        List<Userrs> list=null;
        list=userserviceimpl.getAll();
        return  list;
    }


    @RequestMapping(value = "",method = RequestMethod.POST)
    public void Insert_User(@RequestParam("id")Integer id,@RequestParam("Fname") String Fname, @RequestParam("Lname")String Lname
                           ,@RequestParam("date") String date,@RequestParam("Mname") String Mname) throws ParseException {
        Userrs user=new Userrs();
        user.setFirst_name(Fname);
        user.setLast_Name(Lname);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date parseddate=dateFormat.parse(date);
        user.setDate(parseddate);
        if(Mname!=null&!Mname.isEmpty())
            user.setMiddle_name(Mname);
        else if(Mname=="")
            user.setMiddle_name(".");

            userserviceimpl.Insert_User_Info(user);
             return;
    }
}
