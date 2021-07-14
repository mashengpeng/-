package com.msp.service;

import com.msp.pojo.Department;

import java.util.List;



public interface DepartmentService {

    public List<Department> getDepartments();

    public Department getDepartment(int id);

    public List<Department> insert(int id, String departmentName);

    public List<Department> insertWithName(String departmentName);

    public List<Department> delete(Integer id);

    public List<Department> deleteAll();

}
