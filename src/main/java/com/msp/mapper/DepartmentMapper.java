package com.msp.mapper;

import com.msp.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    @Select("select * from department")
    List<Department> getDepartments();

    Department getDepartment(Integer id);

    int insert(Department department);

    int insertWithName(String departmentName);

    int delete(Integer id);

    int deleteAll();

}