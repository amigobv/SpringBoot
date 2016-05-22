package swt6.spring.euro.logic;

import java.util.Date;
import java.util.List;

import swt6.spring.euro.domain.Game;
import swt6.spring.euro.domain.Team;

public interface GameFacade {
	public Team syncTeam(Team team);
	public Team findTeamById(Long id);
	public Team findTeamByName(String name);
	public List<Team> findAllTeams();
	
	public Game syncGame(Game game);
	public Game findGameById(Long id);
	public List<Game> findGameByDate(Date date);
	public List<Game> findGamesByHost(Long hostId);
	public List<Game> findGamesByGuest(Long guestId);
	public List<Game> findAllPlayedGames();
	public List<Game> findUnplayedGames();
	public List<Game> findAllGames();
}
