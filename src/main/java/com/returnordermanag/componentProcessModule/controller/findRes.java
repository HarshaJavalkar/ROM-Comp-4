package com.returnordermanag.componentProcessModule.controller;

import javax.persistence.Entity;

public class findRes {

	private String useraname;

	public String getUseraname() {
		return useraname;
	}

	public void setUseraname(String useraname) {
		this.useraname = useraname;
	}

	public findRes(String useraname) {
		super();
		this.useraname = useraname;
	}
	
	

	public findRes() {

	}
	
	
}
