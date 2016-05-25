package swt6.spring.euro.domain;

import java.io.Serializable;
import java.text.DateFormat;
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
	private static final DateFormat fmt = DateFormat.getDateTimeInstance();
	
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
	private Date gameDay;
	
	@OneToMany(mappedBy="game", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Prediction> predictions = new HashSet<>();
	
	public Game() {}
	
	public Game(Team host, Team guest, Date gameDay) {
		host.addHostGame(this);
		guest.addGuestGame(this);
		this.gameDay = gameDay;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGameDay() {
		return gameDay;
	}

	public void setGameDay(Date gameDay) {
		this.gameDay = gameDay;
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
	
	@OneToMany(mappedBy="game", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public Set<Prediction> getPredictions() {
		return predictions;
	}
	
	@Override
	public String toString() {
	    StringBuffer sb = new StringBuffer();
	    sb.append(id + ": " + host.getName() + " : " + guest.getName() + " (" + fmt.format(gameDay.toString()) + ")" );
	    
	    return sb.toString();
	  }
}
