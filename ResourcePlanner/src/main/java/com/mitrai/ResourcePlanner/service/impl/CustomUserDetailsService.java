package com.mitrai.ResourcePlanner.service.impl;

import com.mitrai.ResourcePlanner.persistence.entity.CustomUser;
import com.mitrai.ResourcePlanner.persistence.entity.Permission;
import com.mitrai.ResourcePlanner.persistence.entity.User;
import com.mitrai.ResourcePlanner.persistence.repository.PermissionRepository;
import com.mitrai.ResourcePlanner.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PermissionRepository permissionRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		try {
			User user = userRepo.findByEmail(email);
			List<Permission> permissions = permissionRepo.getPermissionsByUser(email);
			Collection<GrantedAuthority> gratedAuthorities = new ArrayList<>();
			for(Permission permission: permissions) {
				GrantedAuthority g = new SimpleGrantedAuthority(permission.getName());
				gratedAuthorities.add(g);
			}
			
			if(user != null && user.getId() != null) {
				return new CustomUser(user, gratedAuthorities);
			} else {
				throw new UsernameNotFoundException("User " + email +" Not found in the database.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("User " + email +" Not found in the database.");
		}
	}

}
