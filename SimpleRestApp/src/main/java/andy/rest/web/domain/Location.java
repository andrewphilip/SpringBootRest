package andy.rest.web.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {

	private @Id @GeneratedValue Long id;
	private String city;
	private String country;
	
	public Location() {}
	
	public Location(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", country=" + country + "]";
	}
	
	
	
}
