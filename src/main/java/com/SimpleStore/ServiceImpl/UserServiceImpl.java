package com.SimpleStore.ServiceImpl;

import java.util.List;

import com.SimpleStore.Dao.UserDao;
import com.SimpleStore.Entity.Role;
import com.SimpleStore.Entity.User;
import com.SimpleStore.Service.UserService;
import com.SimpleStore.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	private UserDao userDao;

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public void save(User user) throws Exception {
		validator.validate(user);
		user.setRole(Role.CHARACTER_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findOne(int id) {
		return userDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);

	}

	@Override
	public void update(User user) {
		userDao.save(user);

	}

	public User findUserWithOrders(int id) {
		return userDao.findUserWithOrders(id);
	}


	@Override
	public void findByName(String name) {
		 userDao.findByName(name);
	}

	@Override
	public User findByUuid(String uuid) {
		return userDao.findByUuid(uuid);
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return null;
	}

	@Override
	public User findUserWithClothes(int id) {
		return userDao.findUserWithClothes(id);
	}

	@Override
	public User findUserByNameWithClothes(String name) {
		return userDao.findUserByNameWithClothes(name);
	}
}
