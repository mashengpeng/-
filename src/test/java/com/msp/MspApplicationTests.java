package com.msp;

import com.alibaba.fastjson.JSON;
import com.msp.pojo.Department;
import com.msp.service.RedisService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;



@SpringBootTest
class MspApplicationTests {

	public static final Logger logger = LoggerFactory.getLogger(MspApplicationTests.class);

	@Resource
	public RedisService redisService;

	@Test
	void contextLoads() {

		//测试redis的string类型
		redisService.setString("weichat","程序员私房菜");
		logger.info("我的微信公众号为：{}", redisService.getString("weichat"));
		// 如果是个实体，我们可以使用json工具转成json字符串，
		Department department = new Department(1, "计算机科学与技术");
		redisService.setString("userInfo", JSON.toJSONString(department));
		logger.info("用户信息：{}", redisService.getString("userInfo"));



	}

}
