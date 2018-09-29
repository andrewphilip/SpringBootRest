package andy.rest.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import andy.rest.web.domain.Location;

public interface LocationRepo extends JpaRepository<Location, Long> {

}
