package com.vaigay;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private CreateListUser c;
	
	private List<User> listUser;
	
	
	@GetMapping("/users")
	public List<User> getAllUser() {
		listUser = c.getList();
		return listUser;
	}
	
	@GetMapping("/users/{id}")
	public User getOneUser(@PathVariable int id) {
		listUser = c.getList();
		for(User u : listUser) {
			if(u.getId() == id)
				return u;
		}
		return null;
	}
	
	@PostMapping("/users")
	public List<User> addUser(@RequestBody User user) {
		listUser = c.getList();
		int id = listUser.get(listUser.size() - 1).getId() + 1;
		user.setId(id);
		listUser.add(user);
		return listUser;
	}
	
	@PutMapping("/users")
	public List<User> updateUser(@RequestBody User user) {
		listUser = c.getList();
		System.out.println("oke. " + user.getId() + " " + user.getName() + " " + user.getAddress());
		for(User u : listUser) {
			if(u.getId() == user.getId()) {
				u.setName(user.getName());
				u.setAddress(user.getAddress());
				System.out.println(user.getName() + " " + user.getAddress() );
			}
		}
		return listUser;
	}
	
	@DeleteMapping("/users/{id}")
	public List<User> deletUser(@PathVariable int id){
		listUser = c.getList();
		int i = -1;
		for(;i<listUser.size();i++) {
			if(listUser.get(i).getId() == id) {
				break;
			}
		}
		if(i != -1)
			listUser.remove(i);
		return listUser;
	}
	
}
