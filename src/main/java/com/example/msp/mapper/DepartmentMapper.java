package com.example.msp.mapper;

import com.example.msp.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    List<Department> getDepartments();

    Department getDepartment(Integer id);

    int insert(Department department);

    int insertWithName(String departmentName);

    int delete(Integer id);

    int deleteAll();

}