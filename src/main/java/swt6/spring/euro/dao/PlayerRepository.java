package swt6.spring.euro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import swt6.spring.euro.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	@Query("select p from Player p where p.name like %?1%")
	Player getByName(String name);
}
