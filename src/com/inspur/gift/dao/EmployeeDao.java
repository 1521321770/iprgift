package com.inspur.gift.dao;

import org.springframework.stereotype.Repository;

import com.inspur.gift.model.Employee;

@Repository("employeeDao")
public class EmployeeDao extends BaseDao<Employee, String>{

}
