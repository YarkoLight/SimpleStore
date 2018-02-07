package com.SimpleStore.Service;

import java.util.List;

import com.SimpleStore.Entity.User;


public interface UserService {
	
	void save(User user) throws Exception;

	List<User> findAll();

	User findOne(int id);

	void delete(int id);

    void update(User user);


	User findUserWithOrders(int id);

    void findByName  (String name);

	User findByUuid(String uuid);

	User findUserWithClothes(int id);

	User findUserByNameWithClothes(String name);

}
