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
public class Player implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long Id;
	
	@Id @GeneratedValue
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	private String email;
	private String name;
	
	@OneToMany(mappedBy="owner", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Prediction> predictions = new HashSet<>();
	
	public Player(){}
	
	public Player(String name, String email){
		this.setName(name);
		this.setEmail(email);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addPrediction(Prediction p) {
		if(p.getOwner() != null)
			p.getOwner().predictions.remove(p);
		
		predictions.add(p);
		p.setOwner(this);
	}
	
	public void removePrediction(Prediction p) {
		if (p.getOwner() != null)
			p.setOwner(null);
		
		predictions.remove(p);
	}

	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public Set<Prediction> getPredictions() {
		return predictions;
	}

	public void setPredictions(Set<Prediction> predictions) {
		this.predictions = predictions;
	}
}
