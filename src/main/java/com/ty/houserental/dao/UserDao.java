package com.ty.houserental.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.houserental.dto.Users;
import com.ty.houserental.repository.UserReposotory;

import lombok.Data;

@Data
@Repository
public class UserDao {

	@Autowired
	UserReposotory userRepository;

	public Users registerUsers(Users users) {
		Users users2 = userRepository.save(users);
		return users2;
	}

	public Users passwordUpdate(Users users) {
		Optional<Users> id = userRepository.findById(users.getUserId());
		if (id != null) {
			Users users2 = userRepository.save(users);
			return users2;
		}
		throw new IllegalArgumentException("users details are not present");

	}

	public String deleteAdmin(int adminId) {
		Optional<Users> id = userRepository.findById(adminId);
		if (id != null && id.get().getUserRole().equalsIgnoreCase("role_admin")) {
			userRepository.delete(id.get());
			return "User Deleted sucessfully";
		}
		throw new IllegalArgumentException("please enter valid adminId");
	}

	public Iterable<Users> getDetailsOfUsers() {
		return userRepository.findAll();
	}
}
