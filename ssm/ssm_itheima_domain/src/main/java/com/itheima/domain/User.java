package com.itheima.domain;


import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable{

  private String name;
  private Integer id;
  private String gender;
  private Integer age;
  private String address;
  private String qq;
  private String email;
  private String username;
  private String password;

}
