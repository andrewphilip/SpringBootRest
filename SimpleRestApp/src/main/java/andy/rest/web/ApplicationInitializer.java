package andy.rest.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import andy.rest.web.domain.Location;
import andy.rest.web.repo.LocationRepo;

@Configuration
public class ApplicationInitializer {
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationInitializer.class);
	
	@Bean
	CommandLineRunner initialize(LocationRepo repo) {
		return  args -> {
			log.info("Loading "+repo.save(new Location("Rome","Italy")));
			log.info("Loading "+repo.save(new Location("Paris","France")));
			log.info("Loading "+repo.save(new Location("Boston","USA")));
			log.info("Loading "+repo.save(new Location("London","UK")));
			log.info("Loading "+repo.save(new Location("Tokyo","Japan")));
		};
	}
}
