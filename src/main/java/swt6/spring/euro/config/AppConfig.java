package swt6.spring.euro.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import swt6.spring.euro.dao.GameRepository;
import swt6.spring.euro.dao.PredictionRepository;
import swt6.spring.euro.dao.TeamRepository;
import swt6.spring.euro.dao.UserRepository;
import swt6.spring.euro.domain.Game;
import swt6.spring.euro.domain.Prediction;
import swt6.spring.euro.domain.Team;
import swt6.spring.euro.domain.User;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses={GameRepository.class, 
		PredictionRepository.class, 
		TeamRepository.class,
		UserRepository.class})
@EnableAspectJAutoProxy
@EntityScan(basePackageClasses={Game.class, Prediction.class, Team.class, User.class})
public class AppConfig {

}
