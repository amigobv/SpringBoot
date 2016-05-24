package swt6.spring.euro.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import swt6.spring.euro.domain.Player;
import swt6.spring.euro.domain.Prediction;
import swt6.spring.euro.logic.PlayerFacade;

@Controller
public class PredictionController {
	private final Logger logger = LoggerFactory.getLogger(PredictionController.class);
	
	@Autowired
	private PlayerFacade player;
	
	@RequestMapping("/users/{playerId}/predictions")
	public String games(@PathVariable("playerId") long userId, Model model) {
		Player user = player.findPlayerById(userId);
		
		logger.debug("Games detail for user {}", user);
		
		List<Prediction> predictions = new ArrayList<Prediction>(user.getPredictions());
		Collections.sort(predictions, (p1, p2) -> p1.getGame().getHost().getName().compareTo(p2.getGame().getHost().getName()));
		
		model.addAttribute("player", user);
		model.addAttribute("predictions", predictions);
		
		return "predictions";
	}
}
