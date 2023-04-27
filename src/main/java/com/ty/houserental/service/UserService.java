package com.ty.houserental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.houserental.dao.UserDao;
import com.ty.houserental.dto.Users;
import com.ty.houserental.response.ResponseStructure;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public ResponseStructure<Users> passwordUpdate(Users users) {
		Users passwordUpdate = userDao.passwordUpdate(users);
		ResponseStructure<Users> responseStructure = new ResponseStructure<>();
		responseStructure.setData(passwordUpdate);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setCode(200);
		return responseStructure;
	}

	public ResponseStructure<Users> registerUser(Users users) {
		Users registerUsers = userDao.registerUsers(users);
		ResponseStructure<Users> responseStructure = new ResponseStructure<>();
		responseStructure.setData(registerUsers);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setCode(200);
		return responseStructure;
	}

	public ResponseStructure<String> deleteAdmin(int adminId) {
		String deleteAdmin = userDao.deleteAdmin(adminId);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setData(deleteAdmin);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setCode(200);
		return responseStructure;
	}

	public ResponseStructure<Iterable<Users>> getDetailsOfUsers() {
		Iterable<Users> detailsOfUsers = userDao.getDetailsOfUsers();
		ResponseStructure<Iterable<Users>> responseStructure = new ResponseStructure<>();
		responseStructure.setData(detailsOfUsers);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setCode(200);
		return responseStructure;
	}
	

}
