package com.vaigay;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CreateListUser {
	private List<User> listUser;
	
	public void init() {
		listUser = new ArrayList<User>();
		listUser.add(new User(1,"hai"," Ha Noi"));
		listUser.add(new User(2,"tu"," Nam Dinh"));
		listUser.add(new User(3,"kien","Phu Tho"));
		listUser.add(new User(4,"giang","Binh Dinh"));
		listUser.add(new User(5,"hung","Thanh Hoa"));
	}
	
	public List<User> getList(){
		init();
		return listUser;
	}
}
