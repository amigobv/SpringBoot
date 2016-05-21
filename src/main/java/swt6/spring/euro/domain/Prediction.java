package swt6.spring.euro.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prediction {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int goalsHomeTeam;
	private int goalsGuetsTeam;
	
	private User owner;
	
	private Game game;
}
