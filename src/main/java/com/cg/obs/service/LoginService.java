package com.cg.obs.service;

import com.cg.obs.dto.User;

public interface LoginService {
	
	 boolean userLogin(User user);
	 boolean adminLogin(User user);
	 User newUser(User user);

}
