package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "grupos")
public class Group {

	//ATRIBUTOS
	private int id;
	private String name;

	//mas eficiente la utilizacion de un set que de un list
	private Set<UserGroup> userGroups = new HashSet<UserGroup>();



	//CONSTRUCTOR
	public Group() {
	}

	public Group(String name) {
		this.name = name;
	}


	//GETTER Y SETTER
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "group_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE)

	//get y set del hashset
	public Set<UserGroup> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(Set<UserGroup> groups) {
		this.userGroups = groups;
	}

	//OJO MUY IMPORTANTEcon el siguiente metodo.
	// Tengo que hacerle para añadir un objeto de tipo usergroup al hashset
	public void addUserGroup(UserGroup userGroup) {
		this.userGroups.add(userGroup);
	}

}