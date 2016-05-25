package swt6.spring.euro.config;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import swt6.spring.euro.domain.Game;
import swt6.spring.euro.domain.Player;
import swt6.spring.euro.domain.Prediction;
import swt6.spring.euro.domain.Team;
import swt6.spring.euro.logic.GameFacade;
import swt6.spring.euro.logic.PlayerFacade;
import swt6.spring.euro.logic.PredictionFacade;
import swt6.util.DateUtil;

public class DatabaseInitializer implements CommandLineRunner {

	@Autowired
	private PlayerFacade player;
	
	@Autowired 
	private GameFacade game;
	
	@Override
	public void run(String... args) throws Exception {
		Team austria = new Team("Austria");
		Team romania = new Team("Romania");
		Team germany = new Team("Germany");
		Team france = new Team("France");
		Team spain = new Team("Spain");
		Team italy = new Team("Italy");
		
//		game.syncTeam(austria);
//		game.syncTeam(romania);
//		game.syncTeam(germany);
//		game.syncTeam(france);
//		game.syncTeam(spain);
//		game.syncTeam(italy);
		
		game.syncGame(new Game(austria, romania, DateUtil.getDate(2016, 06, 15)));
		game.syncGame(new Game(germany, france, DateUtil.getDate(2016, 06, 16)));
		game.syncGame(new Game(spain, italy, DateUtil.getDate(2016, 06, 17)));
//		game.syncGame(new Game(austria, germany, DateUtil.getDate(2016, 06, 16)));
		
		player.syncPlayer(new Player("Werner", "werner@students.fh-hagenberg.com"));
		player.syncPlayer(new Player("Sepp", "sepp@students.fh-hagenberg.com"));
		player.syncPlayer(new Player("Franz", "franz@students.fh-hagenberg.com"));
	}
}
