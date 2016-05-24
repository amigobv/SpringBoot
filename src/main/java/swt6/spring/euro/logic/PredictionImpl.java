package swt6.spring.euro.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import swt6.spring.euro.dao.PredictionRepository;

@Component()
@Transactional
public class PredictionImpl implements PredictionFacade {

	@Autowired
	private PredictionRepository predictionRepo;
	
	//================ setter ======================
	public void setPredictionRepo(PredictionRepository predictionRepo){
		this.predictionRepo = predictionRepo;
	}

}
