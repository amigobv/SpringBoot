package swt6.spring.euro.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import swt6.spring.euro.logic.GameFacade;

@Controller
public class GameController {
	private final Logger logger = LoggerFactory.getLogger(GameController.class);
	
	@Autowired
	private GameFacade game;
	
	@RequestMapping("/games")
	public String games(Model model) {
		
		return "gameList";
	}
	
}
