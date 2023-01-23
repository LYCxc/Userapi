package com.example.springboot;

import com.example.springboot.users.Userapplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import  static  org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Myapplicationtest  {
  @Autowired
    private MockMvc mvc;
  @Test
  public void test() throws Exception{
        RequestBuilder request;
        request=post("/userinfo")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"5264\",\"Fname\":\"July\",\"Lname\":\"Ford\",\"date\":\"2010-10-25\"}");
        MvcResult result=mvc.perform(request)
                .andReturn();
      MockHttpServletResponse response = result.getResponse();
      assertEquals(HttpStatus.CREATED.value(),response.getStatus());
      String expected="{\"id\":\"5264\",\"Fname\":\"July\",\"Lname\":\"Ford\",\"date\":\"2010-10-25\"}";
      JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);

    }
}
