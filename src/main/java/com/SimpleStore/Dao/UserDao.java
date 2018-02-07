package com.SimpleStore.Dao;

import com.SimpleStore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserDao extends JpaRepository<User, Integer>{
	
//	User findByNameAndEmail(String name);

	@Query("select distinct u from User u  where u.id=:id")
	User findUser(@Param("id") int id);

	@Query("select distinct u from User u  where u.name=:name")
	User findUserByName(@Param("name") String name);



	@Query("select u from User u left join fetch u.clothes where u.id=:id")
	User findUserWithClothes(@Param("id")int id);

	@Query("select u from User u left join fetch u.orders o left join fetch o.clothes where u.id=:id")
	User findUserWithOrders(@Param("id") int id);

	User findByName(String name);
	@Query("select u from User u where u.name =:parameter or u.email=:parameter")
	User findByNameOrEmail(@Param("parameter") String parameter);

	User findByEmail(String email);

	@Query("select u from User u where u.uuid =:uuid")
	User findByUuid(@Param("uuid") String uuid);

	@Query("select distinct u from User u left join fetch u.clothes where u.name=:name")
	User findUserByNameWithClothes(@Param("name") String name);



}
