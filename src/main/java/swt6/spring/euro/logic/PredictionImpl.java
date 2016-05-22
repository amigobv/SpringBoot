package swt6.spring.euro.logic;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import swt6.spring.euro.dao.PlayerRepository;
import swt6.spring.euro.dao.PredictionRepository;
import swt6.spring.euro.domain.Player;

@Component()
@Transactional
public class PredictionImpl implements PredictionFacade {

	@Autowired
	private PlayerRepository userRepo;
	
	@Autowired
	private PredictionRepository predictionRepo;
	
	//================ setter ======================
	public void setUserRepo(PlayerRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public void setPredictionRepo(PredictionRepository predictionRepo){
		this.predictionRepo = predictionRepo;
	}
	
	//================ Business logic method for User ================
	@Override
	public Player syncPlayer(Player user) {
		return userRepo.saveAndFlush(user);
	}

	@Override
	public Player findPlayerById(Long id) {
		return userRepo.findOne(id);
	}

	@Override
	public Player findPlayerByName(String name) {
		return userRepo.getByName(name);
	}

	@Override
	public List<Player> findAllPlayers() {
		return userRepo.findAll();
	}

}
