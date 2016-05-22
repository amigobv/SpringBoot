package swt6.spring.euro.logic;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import swt6.spring.euro.dao.GameRepository;
import swt6.spring.euro.dao.TeamRepository;
import swt6.spring.euro.domain.Game;
import swt6.spring.euro.domain.Team;

@Component
@Transactional
public class GameImpl implements GameFacade {
	
	@Autowired
	private GameRepository gameRepo;
	
	@Autowired
	private TeamRepository teamRepo;
	
	//============== Setters =========================
	public void setGameRepo(GameRepository gameRepo) {
		this.gameRepo = gameRepo;
	}
	
	public void setTeamRepo(TeamRepository teamRepo) {
		this.teamRepo = teamRepo;
	}
	
	//============= Business logic for Team ===========
	@Override
	public Team syncTeam(Team team) {
		return teamRepo.saveAndFlush(team);
	}

	@Override
	public Team findTeamById(Long id) {
		return teamRepo.findOne(id);
	}

	@Override
	public Team findTeamByName(String name) {
		return teamRepo.getByName(name);
	}

	@Override
	public List<Team> findAllTeams() {
		return teamRepo.findAll();
	}

	//============= Business logic for Game ===========
	
	@Override
	public Game syncGame(Game game) {
		return gameRepo.saveAndFlush(game);
	}

	@Override
	public Game findGameById(Long id) {
		return gameRepo.findOne(id);
	}

	@Override
	public List<Game> findGameByDate(Date date) {
		return gameRepo.findByDay(date);
	}

	@Override
	public List<Game> findGamesByHost(Long hostId) {
		return gameRepo.findByHost(hostId);
	}

	@Override
	public List<Game> findGamesByGuest(Long guestId) {
		return gameRepo.findByGuest(guestId);
	}

	@Override
	public List<Game> findAllPlayedGames() {
		return gameRepo.findOlderThan(new Date());
	}

	@Override
	public List<Game> findUnplayedGames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> findAllGames() {
		return gameRepo.findAll();
	}

	//============= Business logic for Game ===========
}
