package swt6.spring.euro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import swt6.spring.euro.domain.Player;
import swt6.spring.euro.domain.Team;
import swt6.spring.euro.logic.GameFacade;
import swt6.spring.euro.logic.PredictionFacade;

public class DatabaseInitializer implements CommandLineRunner {

	@Autowired
	private PredictionFacade prediction;
	
	@Autowired 
	private GameFacade game;
	
	@Override
	public void run(String... args) throws Exception {
		prediction.syncPlayer(new Player("Werner", "werner@students.fh-hagenberg.com"));
		prediction.syncPlayer(new Player("Sepp", "sepp@students.fh-hagenberg.com"));
		prediction.syncPlayer(new Player("Franz", "franz@students.fh-hagenberg.com"));
		
		game.syncTeam(new Team("Austria"));
		game.syncTeam(new Team("Romania"));
		game.syncTeam(new Team("Germany"));
		game.syncTeam(new Team("France"));
		game.syncTeam(new Team("Spain"));
		game.syncTeam(new Team("Italy"));
	}
}
