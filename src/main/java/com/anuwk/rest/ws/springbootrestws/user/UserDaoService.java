package com.anuwk.rest.ws.springbootrestws.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 3;
	
	static {
		users.add(new User(1,"Adam",new Date()));
		users.add(new User(2,"Eve",new Date()));
		users.add(new User(3,"Jack",new Date()));
		
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		
		for (User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
		
	}
	
	public User deleteById(int id) {
		Iterator<User> userItr = users.iterator();

		while(userItr.hasNext()) {
			User user = userItr.next();
			if(user.getId()==id) {
				userItr.remove();
				return user;
			}
		}
		
		return null;
		
	}
}
