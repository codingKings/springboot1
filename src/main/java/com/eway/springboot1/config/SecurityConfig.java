package com.eway.springboot1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
* @author 程龙
* @version 创建时间：2019年9月7日 下午9:36:55
* @ClassName 类名称：SecurityConfig，配置类，可以配置关闭自带的登入验证功能，也可以配置自定义用户登录时转到的登录页面
* @Description 类描述：配置类，可以配置关闭自带的登入验证功能，也可以配置自定义用户登录时转到的登录页面
*/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder(){
	    //当然，如果你有自己的加密方法，这个方法就写自己的加密方法好了
	    return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//关闭security自带的安全访问功能
//		http.authorizeRequests()
//		.anyRequest()
//		.permitAll()
//		.and()
//		.logout()
//		.permitAll();
		
		//配置需要登入验证
//        http.formLogin() 
//        // 定义当需要用户登录时候，转到的登录页面。
//        .and()
//        .authorizeRequests()// 定义哪些URL需要被保护、哪些不需要被保护
//        .anyRequest()     // 任何请求,登录后可以访问
//        .authenticated();
        
		//配置需要登入验证的自定义配置
        http.formLogin()          // 定义当需要用户登录时候，转到的登录页面。
        .loginPage("/login.html")      // 设置登录页面
        .loginProcessingUrl("/user/login") // 自定义的登录接口
        .and()
        .authorizeRequests()    // 定义哪些URL需要被保护、哪些不需要被保护
        .antMatchers("/login.html").permitAll()   // 设置所有人都可以访问登录页面
        .anyRequest()        // 任何请求,登录后可以访问
        .authenticated()
        .and()
        .csrf().disable();     // 关闭csrf防护
        
	}

	
}
