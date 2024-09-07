package OOP;

import java.util.Arrays;

public class Movie {
	private String title;
	private String id;
	private String description;
	private String showType;
	private String[] genre;
	private String releaseYear;
	private int runtime;
	private double seasons;
	private Person[] array;
	
	public Movie(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShowType() {
		return showType;
	}
	public void setShowType(String showType) {
		this.showType = showType;
	}
	public String[] getGenre() {
		return genre;
	}
	public void setGenre(String[] genre) {
		this.genre = genre;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public double getSeasons() {
		return seasons;
	}
	public void setSeasons(double seasons) {
		this.seasons = seasons;
	}
	public Person[] getArray() {
		return array;
	}
	public void setArray(Person[] array) {
		this.array = array;
	}

	public String toString() {
		System.out.println("The " + showType + " " + title + " was released in " + releaseYear + ".");
		if(seasons > 0) {
			System.out.println("This " + showType + " has " + seasons + " seasons with each episode's runtime being " + runtime + " minutes. The following individuals were involved in the" +  showType 
					+ ":");
			System.out.println(Arrays.toString(array));
		}
		else {
			System.out.println("This " + showType + " runs for " + runtime + " minutes. The following individuals were involved in the " + showType + ": ");
			System.out.println(Arrays.toString(array));
		}
		return ("Completed");
	}
}
