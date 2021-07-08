package com.example.msp.service;

import com.example.msp.mapper.DepartmentMapper;
import com.example.msp.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepartments(){

        return departmentMapper.getDepartments();
    }

    public  Department getDepartment(int id){

        return departmentMapper.getDepartment(id);
    }

    public List<Department> insert(int id, String departmentName){

        departmentMapper.insert(new Department(id,departmentName));

        return departmentMapper.getDepartments();
    }

    public List<Department> insertWithName(String departmentName){

        departmentMapper.insertWithName(departmentName);

        return departmentMapper.getDepartments();
    }

    public  List<Department> delete(Integer id){

        departmentMapper.delete(id);

        return departmentMapper.getDepartments();
    }

    public  List<Department> deleteAll(){

        departmentMapper.deleteAll();

        return departmentMapper.getDepartments();
    }
}
