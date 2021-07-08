package com.example.msp.service;

import com.example.msp.mapper.DepartmentMapper;
import com.example.msp.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



public interface DepartmentService {

    public List<Department> getDepartments();

    public Department getDepartment(int id);

    public List<Department> insert(int id, String departmentName);

    public List<Department> insertWithName(String departmentName);

    public List<Department> delete(Integer id);

    public List<Department> deleteAll();

}
