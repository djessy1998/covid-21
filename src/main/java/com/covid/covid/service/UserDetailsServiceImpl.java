package com.covid.covid.service;
import java.io.IOException;
import java.util.Base64;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.covid.covid.model.Role;
import com.covid.covid.model.User;
import com.covid.covid.repository.FriendshipRepository;
import com.covid.covid.repository.NotificationRepository;
import com.covid.covid.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private FriendshipRepository friendshipRepository;

	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;


	public User save(User registration) {
		User user = new User();
		user.setUsername(registration.getUsername());
		user.setFirstName(registration.getFirstName());
		user.setLastName(registration.getLastName());

		// On ajoute les rôles à l'utilisateur
		Role role = new Role();
		// 2 est l'id de l'utilisateur lambda
		role.setRoleId(2);
		HashSet<Role> listeRole = new HashSet<>();
		listeRole.add(role);
		user.setRoles(listeRole);
		user.setPassword(bCryptPasswordEncoder.encode(registration.getPassword()));
		return usersRepository.save(user);
	}

	public void changeUsername(User user, String username){
		// TODO : vérifier que le username n'existe pas déjà
		user.setUsername(username);
		usersRepository.save(user);
	}

	public void changeFirstName(User user, String firstname){
		user.setFirstName(firstname);
		usersRepository.save(user);
	}

	public void changeLastName(User user, String lastname){
		user.setLastName(lastname);
		usersRepository.save(user);
	}

	public void changePassword(User user, String password){
		user.setPassword(bCryptPasswordEncoder.encode(password));
		usersRepository.save(user);
	}

	public boolean checkIfUserExist(String email) {
		return usersRepository.findUser(email) != null;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<User> userList = usersRepository.findUser(userName);
		
		if (userList != null && userList.size() == 1) {
			User user = userList.get(0);
			Set<Role> roleList = new HashSet<>(user.getRoles());
			user.setRoles(roleList);
			return user;

		} else {
			throw new UsernameNotFoundException("User Name is not Found");
		}
	}

	public void changeImage(User user, MultipartFile file){
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")){
			return; // nom de fichier non valide, on part
		}

		try {
			user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			usersRepository.save(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}