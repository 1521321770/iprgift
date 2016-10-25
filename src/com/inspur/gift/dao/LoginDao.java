package com.inspur.gift.dao;

import org.springframework.stereotype.Repository;

import com.inspur.gift.model.Employee;

@Repository("loginDao")
public class LoginDao  extends BaseDao<Employee, String>{

}
