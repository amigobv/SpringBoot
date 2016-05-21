package swt6.spring.euro.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	private String email;
	private String name;
	
	private Set<Prediction> predictions = new HashSet<>();
}
