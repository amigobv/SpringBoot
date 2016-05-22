package swt6.spring.euro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import swt6.spring.euro.domain.Prediction;

@Repository
public interface PredictionRepository extends JpaRepository<Prediction, Long> {
	@Query("select p from Prediction p where p.Owner = ?1")
	List<Prediction> getByOwner(Long id);
}
