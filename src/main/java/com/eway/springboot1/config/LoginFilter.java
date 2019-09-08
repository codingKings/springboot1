package com.eway.springboot1.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
* @author 程龙
* @version 创建时间：2019年9月7日 下午9:52:12
* @ClassName 类名称：LoginFilter
* @Description 类描述：LoginFilter配置用户认证类实现UserDetailsService接口，因为我们是要有自己的一套用户体系，所以要配置用户认证
*/
@Component
public class LoginFilter implements UserDetailsService {

	@Autowired
    private PasswordEncoder passwordEncoder;
	private Logger logger = LoggerFactory.getLogger("adminLogger");
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("用户的用户名: {}", username);
		// TODO 根据用户名，查找到对应的密码，与权限
		//封装用户信息，并返回。参数分别是：用户名，密码，用户权限
		User user = new User(username, passwordEncoder.encode("123456"),
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
	}

}
