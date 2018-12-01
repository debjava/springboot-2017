package com.ddlab.services;

import org.springframework.stereotype.Component;

import com.ddlab.entity.User;
@Component(value="userService")
public class UserServiceImpl implements IUserService {

	public void createUser(User user) {
		System.out.println("User created successfully...");
	}

	public void updateUser(User user) {
		System.out.println("User information updated successfully...");
	}

	public void deleteUser(User user) {
		System.out.println("User information deleted successfully...");
	}

	public User getUserById(String id) {
		if( id == null ) throw new NullPointerException("User id can not be blank or empty");
		User user = new User();
		user.setFirstName("Deb");
		user.setLastName("Mishra");
		user.setId(Integer.parseInt(id));
		return user;
	}
}
