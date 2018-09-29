package andy.rest.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import andy.rest.web.domain.Location;
import andy.rest.web.repo.LocationRepo;

@RestController
public class LocationController {

	private static final Logger log = LoggerFactory.getLogger(LocationController.class);
	
	@Autowired
	private  LocationRepo repo;

	@GetMapping("/locations")
	List<Location> getAllLocations(){
		return repo.findAll();
	}
	
	@GetMapping("/locations/{id}")
	Location getLocationById(@PathVariable Long id) {
		log.info("GetLocationById:"+id);
		return repo.findById(id)
					.orElseThrow(() -> new LocationNotFoundException(id));
	}
	
	@PostMapping("/locations")
	Location insertLocation(@RequestBody Location loc) {
		log.info("Inserting Location:"+loc.toString());
		return repo.save(loc);
	}
	
	@DeleteMapping("/locations/{id}")
	void removeLocation(@PathVariable Long id) {
		log.info("RemoveLocationById:"+id);
		repo.deleteById(id);
	}
}
