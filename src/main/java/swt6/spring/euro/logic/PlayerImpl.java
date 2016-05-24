package swt6.spring.euro.logic;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import swt6.spring.euro.dao.PlayerRepository;
import swt6.spring.euro.domain.Player;

@Component()
@Transactional
public class PlayerImpl implements PlayerFacade {
	@Autowired
	private PlayerRepository playerRepo;

	// ================ setter ======================
	public void setPlayerRepo(PlayerRepository playerRepo) {
		this.playerRepo = playerRepo;
	}

	// ================ Business logic method for User ================
	public Player syncPlayer(Player user) {
		return playerRepo.saveAndFlush(user);
	}

	@Transactional(readOnly = true)
	public Player findPlayerById(Long id) {
		return playerRepo.findOne(id);
	}

	@Transactional(readOnly = true)
	public Player findPlayerByName(String name) {
		return playerRepo.getByName(name);
	}

	@Transactional(readOnly = true)
	public List<Player> findAllPlayers() {
		return playerRepo.findAll();
	}
}
