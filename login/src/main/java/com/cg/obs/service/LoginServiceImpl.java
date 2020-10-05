package com.cg.obs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.obs.dao.UserRepository;
import com.cg.obs.dto.User;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	UserRepository userRepo;

	@Override
	public boolean userLogin(User user) {
		List<User> userList = (List<User>) userRepo.findAll();
		int flag=0;
		for(User tempUser:userList)
		{System.out.println(user);
		System.out.println(tempUser); 
			if(tempUser.getPhoneNo()==(user.getPhoneNo()) && tempUser.getPassWord().equals(user.getPassWord()))
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			System.out.println(true);
			return true;
		}
		else
		{
			System.out.println(false);
			return false;
		}
	
	}

	@Override
	public boolean adminLogin(User user) {
		System.out.println(user);
		if(9876543210l==(user.getPhoneNo()) && "Admin@123".equals(user.getPassWord()))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public User newUser(User user) {
		return userRepo.saveAndFlush(user);
	}

	

}
