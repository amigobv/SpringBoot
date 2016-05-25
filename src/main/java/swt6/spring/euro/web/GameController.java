package swt6.spring.euro.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import swt6.spring.euro.domain.Game;
import swt6.spring.euro.domain.Team;
import swt6.spring.euro.logic.GameFacade;

@Controller
public class GameController {
	private final Logger logger = LoggerFactory.getLogger(GameController.class);

	@Autowired
	private GameFacade gameService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");
		//dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	

	@RequestMapping("/games")
	public String games(Model model) {
		List<Game> games = gameService.findAllGames();

		model.addAttribute("games", games);

		logger.debug("games: {}", games);

		return "games";
	}

	@RequestMapping(value = "/games/new", method = RequestMethod.GET)
	public String initNew(Model model) {
		Game game = new Game(new Team(""), new Team(""), new Date());
		List<Team> teams = gameService.findAllTeams();
		
		model.addAttribute("teams", teams);
		model.addAttribute("game", game);
		
		return "game";
	}
	

	@RequestMapping(value = "/games/new", method = RequestMethod.POST)
	public String processNew(@ModelAttribute("game") Game game,
			BindingResult result, Model model) {

		if (result.hasErrors())
			return "game";
		else {
			game = gameService.syncGame(game);
		}
		return "redirect:/games";
	}

	@RequestMapping(value = "/{gameId}/update", method = RequestMethod.GET)
	public String initUpdate(@PathVariable("gameId") Long gameId, Model model) {
		
		Game g = gameService.findGameById(gameId);
		model.addAttribute("game", g);

		return "update";
	}
	
	@RequestMapping(value = "/game/{gameId}/update", params = {"host", "hostGoals", "guest", "guestGoals"})
	public String processUpdate(@PathVariable("gameId") Long gameId,  
								@RequestParam(value = "host") String host,
								@RequestParam(value = "hostGoals") int hGoals,
								@RequestParam(value = "guest") String guest,
								@RequestParam(value = "guestGoals") int gGoals,
								Model model) {
		
		Game g = gameService.findGameById(gameId);
		g.setHostGoals(hGoals);
		g.setGuestGoals(gGoals);
		g = gameService.syncGame(g);

		return "redirect:/games";
	}

	@RequestMapping("/{gameId}/play")
	public String playGame(@PathVariable("gameId") Long gameId, Model model) {

		return "edit";
	}
}
