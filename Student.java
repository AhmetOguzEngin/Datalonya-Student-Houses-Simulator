
public class Student implements Comparable<Student> {
	/*
	 * This part is to store necessary information about students such as id, name, duration and rating.
	 */
	private int id;
	private String name;
	private int duration;
	private double rating;
	//Constructor method is to create student objects with id, name, duration and rating.
	public Student(int id, String name, int duration, double rating) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.rating = rating; 
	}
	//This method is to keep students in necessary order in treeset.	
	@Override
	public int compareTo(Student o) {
		return this.id - o.id;
	}
	//Getter method for duration.	
	public int getDuration() {
		return duration;
	}
	//Setter method for duration.	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	//Getter method for name.	
	public String getName() {
		return name;
	}
	//Getter method for rating.
	public double getRating() {
		return rating;
	}
	//Getter method for id.	
	public int getId() {
		return id;
	}
	
	
	
	
}
