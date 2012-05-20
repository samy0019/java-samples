package pe.joedayz.ejemplos.netflix.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * @author joedayz
 * 
 */
@XmlRootElement
public class Movie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6356059940778649777L;
	
	private Integer id;
	private String title;
	private String description;
	private String director;
	private String genre;
	private String languages;
	private String starring;
	private String duration;
	private String year;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getStarring() {
		return starring;
	}
	public void setStarring(String starring) {
		this.starring = starring;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
	
	
}
