package swt6.spring.euro.logic;

import java.util.List;

import swt6.spring.euro.domain.Player;

public interface PredictionFacade {
	public Player syncPlayer(Player user);
	public Player findPlayerById(Long id);
	public Player findPlayerByName(String name);
	public List<Player> findAllPlayers();
}
