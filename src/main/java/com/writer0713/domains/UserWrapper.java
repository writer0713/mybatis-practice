package com.writer0713.domains;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWrapper {

	@XmlElementWrapper(name = "users")
	@XmlElement(name = "user")
	private List<User> userList;

	public UserWrapper() {
		userList = new ArrayList<>();
	}

	public List<User> getUserList() {
		return userList;
	}

	public void addUser(User user) {
		userList.add(user);
	}
}
