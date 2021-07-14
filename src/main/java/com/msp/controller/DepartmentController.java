package com.msp.controller;

import com.msp.pojo.Department;
import com.msp.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    // 查询全部部门
    @GetMapping("/getDepartments")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    // 查询全部部门
    @GetMapping("/getDepartment/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentService.getDepartment(id);
    }


    @GetMapping("/insert/{id}/{departmentName}")
    public List<Department> insert(@PathVariable("id") Integer id, @PathVariable("departmentName") String departmentName){
        return departmentService.insert(id, departmentName);
    }

    @GetMapping("/insert/{departmentName}")
    public List<Department> insertWithName(@PathVariable("departmentName") String departmentName){
        return departmentService.insertWithName(departmentName);
    }

    @GetMapping("/delete/{id}")
    public List<Department> delete(@PathVariable("id") Integer id){
        return departmentService.delete(id);
    }

    @GetMapping("/deleteAll")
    public List<Department> deleteAll(){
        return departmentService.deleteAll();
    }
}



