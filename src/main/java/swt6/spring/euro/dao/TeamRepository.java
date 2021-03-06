package swt6.spring.euro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import swt6.spring.euro.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
	@Query("select t from Team t where t.name like %?1%")
	Team getByName(String name);
}
