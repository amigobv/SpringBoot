package swt6.spring.euro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swt6.spring.euro.domain.Prediction;

@Repository
public interface PredictionRepository extends JpaRepository<Prediction, Long> {

}
