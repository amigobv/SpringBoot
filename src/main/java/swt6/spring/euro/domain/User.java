package swt6.spring.euro.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	private String email;
	private String name;
	
	@OneToMany(mappedBy="owner", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Prediction> predictions = new HashSet<>();
	
	public User(){}
	
	public User(String name, String email){
		this.name = name;
		this.email = email;
	}
}
