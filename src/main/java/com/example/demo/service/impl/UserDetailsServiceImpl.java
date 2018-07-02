package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Utils.LogUtil;
import com.example.demo.repo.UserRepository;
import com.example.demo.repo.UserRoleRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository roleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
        LogUtil.Debug(this.getClass(), "user");
	//	User user = userRepository.findUserByUserName(userName);
		User user = new User();
        if (user == null) {
        	LogUtil.Debug(this.getClass(), "user not found");
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        LogUtil.Debug(this.getClass(), user.getUserId().toString());
        List<String> roleNames = this.roleRepository.getRolesName(user.getUserId());
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        
        for (String role : roleNames) {
            LogUtil.Debug(this.getClass(), role);
            GrantedAuthority authority = new SimpleGrantedAuthority(role);
            grantList.add(authority);
        }
        LogUtil.Debug(this.getClass(), user.getUserName());
        LogUtil.Debug(this.getClass(), user.getEncrytedPassword());
   //     UserDetails userDetails = (UserDetails) new User(user.getUserName(), user.getEncrytedPassword(), grantList);
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(), user.getEncrytedPassword(), grantList);
	}

}
