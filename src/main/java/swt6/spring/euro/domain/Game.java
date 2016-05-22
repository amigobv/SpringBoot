package swt6.spring.euro.domain;

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
public class Game {
	
	@Id
	@GeneratedValue
	private String id;
	
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
}
