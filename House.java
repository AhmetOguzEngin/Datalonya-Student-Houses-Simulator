
public class House implements Comparable<House>{
	/*
	 * This part is to store necessary information about houses such as id, duration and rating.
	 */
	private int id;
	private int duration;
	private double rating;
	//Constructor method is to create house objects with id, duration and rating.  	
	public House(int id, int duration, double rating) {
		this.id = id;
		this.duration = duration;
		this.rating = rating;
	}
	//This method is to keep houses in necessary order in treeset.	
	@Override
	public int compareTo(House o) {
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
	//Getter method for rating.
	public double getRating() {
		return rating;
	}
	//Getter method for id.
	public int getId() {
		return id;
	}
}
