package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "usuarios")
public class User {

	//ATRIBUTOS
	private int id;
	private String username;
	private String password;
	private String email;	

	private Set<UserGroup> userGroups = new HashSet<UserGroup>();


	//CONSTRUCTOR
	public User() {
	}

	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public void addGroup(UserGroup group) {
		this.userGroups.add(group);
	}


	//GETTER Y SETTER
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id")

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.DETACH)
	public Set<UserGroup> getUserGroups() {

		return userGroups;
	}

	public void setUserGroups(Set<UserGroup> groups) {

		this.userGroups = groups;
	}

	//OJO MUY IMPORTANTEcon el siguiente metodo.
	//Tengo que hacerle para añadir un objeto de tipo usergroup al hashset
	//si te fijas es igual que en la clase group
	public void addUserGroup(UserGroup userGroup) {

		this.userGroups.add(userGroup);
	}	
}