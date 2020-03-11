package com.testingzk.model;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class UserCredential {
	@Setter
	@Getter
	private String account;
	
	@Setter
	@Getter
	private String name;
	
	private Set<String> roles = new HashSet<String>();
	
	public UserCredential() {
		this.account = "anonymous";
		this.name = "anonymous";
		roles.add("anonymous");
	}
	
	public UserCredential(String account, String name) {
		this.account = account;
		this.name = name;
	}
	
	public boolean hasRole(String role){
		return roles.contains(role);
	}
	
	public void addRole(String role){
		roles.add(role);
	}
}
