package swt6.spring.euro.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prediction implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private int hostGoals;
	
	private int guetsGoals;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Player owner;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Game game;
	
	public Prediction() {}
	
	public Prediction(int hostGoals, int guestGoals) {
		this.setHostGoals(hostGoals);
		this.setGuetsGoals(guestGoals);
	}

	public int getHostGoals() {
		return hostGoals;
	}

	public void setHostGoals(int hostGoals) {
		this.hostGoals = hostGoals;
	}

	public int getGuetsGoals() {
		return guetsGoals;
	}

	public void setGuetsGoals(int guetsGoals) {
		this.guetsGoals = guetsGoals;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	
}
