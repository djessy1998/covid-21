package com.covid.covid.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.covid.covid.model.Role;
import com.covid.covid.model.User;
import com.covid.covid.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		List<User> userList = usersRepository.findAdmin(userName);

		if (userList != null && userList.size() == 1) {
			User user = userList.get(0);
			Set<Role> roleList = new HashSet<>(user.getRoles());
			user.setRoles(roleList);
			return user;

		} else {
			throw new UsernameNotFoundException("User Name is not Found");
		}

	}
}