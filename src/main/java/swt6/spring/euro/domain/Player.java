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
			p.getOwner().getPredictions().remove(p);
		
		predictions.add(p);
		p.setOwner(this);
	}
	
	public void removePrediction(Prediction p) {
		if (p.getOwner() != null)
			p.setOwner(null);
		
		predictions.remove(p);
	}

	public Set<Prediction> getPredictions() {
		return predictions;
	}

	public void setPredictions(Set<Prediction> predictions) {
		this.predictions = predictions;
	}
}
