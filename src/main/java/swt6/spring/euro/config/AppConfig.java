package swt6.spring.euro.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import swt6.spring.euro.dao.PlayerRepository;
import swt6.spring.euro.domain.Player;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses={PlayerRepository.class})
@EnableAspectJAutoProxy
@EntityScan(basePackageClasses={Player.class})
public class AppConfig  {

}
