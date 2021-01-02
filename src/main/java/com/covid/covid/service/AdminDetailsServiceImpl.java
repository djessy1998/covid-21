package com.covid.covid.service;

import java.util.ArrayList;
import java.util.List;

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
			List<String> roleList = new ArrayList<String>();
			for (Role role : user.getRoles()) {
				roleList.add(role.getRoleName());
			}
            return org.springframework.security.core.userdetails.User.builder()
                	.username(user.getUsername())
                	.password(bCryptPasswordEncoder.encode(user.getPassword()))
                	.disabled(user.isDisabled())
                	.accountExpired(user.isAccountExpired())
                	.accountLocked(user.isAccountLocked())
                	.credentialsExpired(user.isCredentialsExpired())
                	.roles(roleList.toArray(new String[0]))
                	.build();
		} else {
			throw new UsernameNotFoundException("User Name is not Found");
		}
	}
}