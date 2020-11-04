package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalQuizApplication.class, args);
	}

}

// TODO GTB-完成度: * 完成了所有功能，小部分存在bug
// TODO GTB-完成度: * 删除学员的接口没有处理id不存在的情况
// TODO GTB-测试: * 没有包含测试
// TODO GTB-知识点: * Spring MVC相关的知识点掌握的不错
// TODO GTB-知识点: * Restful API Design相关的知识点掌握的不错
// TODO GTB-知识点: * Spring IoC相关的知识掌握的不错
// TODO GTB-知识点: * 使用了Collections.shuffle()实现自从分组
// TODO GTB-知识点: * 合理处理了异常
// TODO GTB-工程实践: * clean code做的不错
// TODO GTB-工程实践: * git commit message表意，遵循了小步提交