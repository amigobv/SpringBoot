package swt6.spring.euro.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team {

	@Id
	@GeneratedValue
	private Long id;
	
	private Set<Game> games = new HashSet<>();
	
	private String name;
	
}
