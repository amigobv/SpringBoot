package swt6.spring.euro.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import swt6.spring.euro.domain.Game;
import swt6.spring.euro.domain.Team;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	@Query("select g from Game g where g.gameDay = ?1")
	List<Game> findByDay(Date date);
	
	@Query("select g from Game g where g.host = ?1 Or g.guest = ?1")
	List<Game> findByTeam(Team host);
	
	@Query("select g from Game g where g.host = ?1")
	List<Game> findByHost(Long host);
	
	@Query("select g from Game g where g.guest = ?1")
	List<Game> findByGuest(Long host);
	
	@Query("select g from Game g where g.gameDay > ?1")
	List<Game> findOlderThan(Date date);
	
	
}
