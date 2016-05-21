package swt6.spring.euro.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {
	
	@Id
	@GeneratedValue
	private String id;
	
	private Team homeTeam;
	
	private Team guestTeam;
	
	private int goalsHomeTeam;
	
	private int goalsGuestTeam;
	
	private Date date;
	
	private Set<Prediction> predictions = new HashSet<>();
}
