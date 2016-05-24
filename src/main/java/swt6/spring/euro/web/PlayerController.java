package swt6.spring.euro.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import swt6.spring.euro.domain.Player;
import swt6.spring.euro.logic.PlayerFacade;

@Controller
public class PlayerController {
	private final Logger logger = LoggerFactory.getLogger(PlayerController.class);
	
	@Autowired
	private PlayerFacade player;
	
	@RequestMapping("/users")
	public String users(Model model) {
		List<Player> players = player.findAllPlayers();
		
		model.addAttribute("players", players);
		
		logger.debug("players: {}", players);
		
		return "users";
	}
}
