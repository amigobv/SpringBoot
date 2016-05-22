package swt6.spring.euro.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import swt6.spring.euro.domain.Team;
import swt6.spring.euro.logic.GameFacade;

@Controller
public class TeamController {
	private final Logger logger = LoggerFactory.getLogger(TeamController.class);
	
	@Autowired
	private GameFacade game;
	
	@RequestMapping("/teams")
	public String teams(Model model) {
		logger.debug("TeamController!");
		
		List<Team> teams = game.findAllTeams();
		
		model.addAttribute("teams", teams);
		
		logger.debug("teams: {}", teams);

		return "teams";
	}
	
}
