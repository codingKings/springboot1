package com.eway.springboot1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @author 程龙
* @version 创建时间：2019年9月7日 下午9:00:45
* @ClassName 类名称
* @Description 类描述
*/
@RestController
@RequestMapping("/api")
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}
}
