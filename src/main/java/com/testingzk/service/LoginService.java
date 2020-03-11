package com.testingzk.service;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import com.testingzk.model.UserCredential;
import com.testingzk.model.dto.LoginDTO;

public class LoginService {
	public boolean doLogin(LoginDTO data) {
		Session sess = Sessions.getCurrent();
		
		if (data.getUsername().equalsIgnoreCase("ADMIN") && data.getPassword().equalsIgnoreCase("admin")) {
			sess.setAttribute("usercredential", new UserCredential(data.getUsername(), data.getPassword()));
			return true;
		}
		
		return false;
	}
}
