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

import com.example.demo.model.User;
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
		User user = userRepository.findUserByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        
        List<String> roleNames = this.roleRepository.getRolesName(user.getUserId());
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        
        for (String role : roleNames) {
            
            GrantedAuthority authority = new SimpleGrantedAuthority(role);
            grantList.add(authority);
        }
   //     UserDetails userDetails = (UserDetails) new User(user.getUserName(), user.getEncrytedPassword(), grantList);
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(), user.getEncrytedPassword(), grantList);
	}

}
