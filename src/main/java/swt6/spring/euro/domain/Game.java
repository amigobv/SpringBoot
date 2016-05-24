package swt6.spring.euro.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Game implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Team host;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Team guest;
	
	private int hostGoals;
	
	private int guestGoals;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToMany(mappedBy="game", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Prediction> predictions = new HashSet<>();
	
	public Game() {}
	
	public Game(Team host, Team guest) {
		this.setHost(host);
		this.setGuest(guest);
	}
	
	public void setResult(int hostGoals, int guestGoals) {
		this.hostGoals = hostGoals;
		this.guestGoals = guestGoals;
	}
	
	public int getHostGoals() {
		return hostGoals; 
	}
	
	public void setHostGoals(int goals) {
		hostGoals = goals;
	}
	
	public int getGuestGoals() {
		return guestGoals;
	}
	
	public void setGuestGoals(int goals) {
		guestGoals = goals;
	}
	
	public String getResult() {
		return String.format("%d : %d", hostGoals, guestGoals);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Team getHost() {
		return host;
	}

	public void setHost(Team host) {
		this.host = host;
	}

	public Team getGuest() {
		return guest;
	}

	public void setGuest(Team guest) {
		this.guest = guest;
	}
	
	public void addPrediction(Prediction p) {
		if (p.getGame() != null)
			p.getGame().predictions.remove(p);
		
		predictions.add(p);
		p.setGame(this);
	}
	
	public void removePrediction(Prediction p) {
		if (p.getGame() != null)
			p.setGame(null);
		
		predictions.remove(p);
	}
}
