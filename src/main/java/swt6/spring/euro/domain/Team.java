package swt6.spring.euro.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team implements Serializable{
	private static final long serialVersionUID = 1L;

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
		this.setName(name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Game> getHostGames() {
		return hostGames;
	}

	public void setHostGames(Set<Game> hostGames) {
		this.hostGames = hostGames;
	}

	public Set<Game> getGuestGames() {
		return guestGames;
	}

	public void setGuestGames(Set<Game> guestGames) {
		this.guestGames = guestGames;
	}
	
	public void addHostGame(Game game) {
		if(game.getHost() != null)
			game.getHost().hostGames.remove(game);
		
		hostGames.add(game);
		game.setHost(this);
	}
	
	public void removeHostGame(Game game) {
		if (game.getHost() != null)
			game.setHost(null);
		
		hostGames.remove(game);
	}
	
	public void addGuestGame(Game game) {
		if(game.getGuest() != null)
			game.getGuest().guestGames.remove(game);
		
		guestGames.add(game);
		game.setGuest(this);
	}
	
	public void removeGuestGame(Game game) {
		if (game.getGuest() != null)
			game.setGuest(null);
			
		guestGames.remove(game);	
	}
	
	@Override
	public String toString() {
		return name;
	}
}
