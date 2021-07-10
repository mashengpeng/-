package com.example.msp.service.impl;

import com.example.msp.mapper.DepartmentMapper;
import com.example.msp.pojo.Department;
import com.example.msp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepartments(){

        return departmentMapper.getDepartments();

    }

    @Override
    public  Department getDepartment(int id){

        return departmentMapper.getDepartment(id);
    }

    @Override
    public List<Department> insert(int id, String departmentName){

        departmentMapper.insert(new Department(id,departmentName));

        return departmentMapper.getDepartments();
    }

    @Override
    public List<Department> insertWithName(String departmentName){

        departmentMapper.insertWithName(departmentName);

        return departmentMapper.getDepartments();
    }

    @Override
    public  List<Department> delete(Integer id){

        departmentMapper.delete(id);

        return departmentMapper.getDepartments();
    }

    @Override
    public  List<Department> deleteAll(){

        departmentMapper.deleteAll();

        return departmentMapper.getDepartments();
    }
}
