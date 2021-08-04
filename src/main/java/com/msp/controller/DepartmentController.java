package com.msp.controller;

import com.msp.pojo.Department;
import com.msp.pojo.JsonResult;
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
    public JsonResult<List> getDepartments(){
        return new JsonResult<>(departmentService.getDepartments());
    }

    // 查询全部部门
    @GetMapping("/getDepartment/{id}")
    public JsonResult<Department> getDepartment(@PathVariable("id") Integer id){
        return new JsonResult<>(departmentService.getDepartment(id));
    }


    @GetMapping("/insert/{id}/{departmentName}")
    public JsonResult<List> insert(@PathVariable("id") Integer id, @PathVariable("departmentName") String departmentName){
        return new JsonResult<>(departmentService.insert(id, departmentName));
    }

    @GetMapping("/insert/{departmentName}")
    public JsonResult<List> insertWithName(@PathVariable("departmentName") String departmentName){
        return new JsonResult<>(departmentService.insertWithName(departmentName));
    }

    @GetMapping("/delete/{id}")
    public JsonResult<List> delete(@PathVariable("id") Integer id){
        return new JsonResult<>(departmentService.delete(id));
    }

    @GetMapping("/deleteAll")
    public JsonResult<List> deleteAll(){
        return new JsonResult<>(departmentService.deleteAll());
    }
}



