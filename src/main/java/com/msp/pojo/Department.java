package com.msp.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "部门类")
public class Department {

    @ApiModelProperty(value = "部门唯一标识")
    private Integer id;
    @ApiModelProperty(value = "部门名称")
    private String departmentName;

}