package OOP;

public class Person {
	protected String name;
	protected int personalId; //Not likely to be super important
	protected String movieId; //Will inherit from movie object it's within
	protected String role;
	
	public Person(String name, String role, int id, String movieid) {
		this.name = name;
		this.role = role;
		this.personalId = id;
		this.movieId = movieid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return movieId;
	}
	public void setId(String id) {
		this.movieId = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString() {
		System.out.println("The " + role + " " + name + " participated in this production.");
		return "person details";
	}
}
