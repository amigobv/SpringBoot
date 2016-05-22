package swt6.spring.euro.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import swt6.spring.euro.domain.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	@Query("select g from Game g where g.date = ?1")
	List<Game> findByDay(Date date);
	
	@Query("select f from Game g where g.host = ?1 Or g.guest = ?1")
	List<Game> findByTeam(Long teamId);
	
	@Query("select g from Game g where g.date > ?1")
	List<Game> findOlderThan(Date date);
}
