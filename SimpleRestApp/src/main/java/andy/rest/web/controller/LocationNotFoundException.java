package andy.rest.web.controller;

public class LocationNotFoundException extends RuntimeException {

	public LocationNotFoundException(Long id) {
		super("Location not found by - "+id);
	}

	
}
