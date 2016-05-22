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
public class Team {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy="host", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Game> hostGames = new HashSet<>();
	
	@OneToMany(mappedBy="guest", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Game> guestGames = new HashSet<>();
	
	private String name;
	
	public Team() {}
	
	public Team(String name) {
		this.name = name;
	}
}
