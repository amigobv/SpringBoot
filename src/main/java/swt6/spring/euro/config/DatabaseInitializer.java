package swt6.spring.euro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import swt6.spring.euro.domain.Team;
import swt6.spring.euro.domain.User;
import swt6.spring.euro.logic.TeamFacade;
import swt6.spring.euro.logic.UserFacade;

public class DatabaseInitializer implements CommandLineRunner {

	@Autowired
	private UserFacade user;
	
	@Autowired 
	private TeamFacade team;
	
	@Override
	public void run(String... args) throws Exception {
		User werner = new User("Werner", "werner@students.fh-hagenberg.com");
		User sepp = new User("Sepp", "sepp@students.fh-hagenberg.com");
		User franz = new User("Franz", "franz@students.fh-hagenberg.com");
		
		Team austria = new Team("Austria");
		Team romania = new Team("Romania");
		Team germany = new Team("Germany");
		Team france = new Team("France");
		Team spain = new Team("Spain");
		Team italy = new Team("Italy");
	}
}
