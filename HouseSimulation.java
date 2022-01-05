
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;


public class HouseSimulation {
	public static TreeSet<Student> runHouseSimulation(TreeSet<House> houses,TreeSet<House> fullhouses, TreeSet<Student> students, int numofsem) {
		/*
		 * The whole simulation is executed in this class. This part of project checks for each student that's not graduated if there is a available
		 * house or not. If it can finds one, student is removed from the treeset and house is added to fullhouse list. Each semester duration of houses
		 * and students is decremented by 1. At the end of the 8 semesters (or it might be less than 8) students list contains only students who cannot be 
		 * settled during their university life.     
		 */
		ArrayList<Student> graduatedStudents = new ArrayList<Student>();
		while(numofsem!=0) {
			Iterator<Student> stdit = students.iterator();
			while(stdit.hasNext()) {
				Student student = stdit.next();
				Iterator<House> hsit = houses.iterator();
				while(hsit.hasNext()) {
					House house = hsit.next();
					if(house.getRating() >= student.getRating() && house.getDuration() == 0 && student.getDuration() > 0) {
						fullhouses.add(house);
						house.setDuration(student.getDuration());
						hsit.remove();
						stdit.remove();
						break;
					}

				}
				student.setDuration(student.getDuration()-1);
				/*
				 * This parts removes the graduated students from treeset.
				 */
				if(students.contains(student) && student.getDuration() <= 0) {
					stdit.remove();
					graduatedStudents.add(student);
				}
			}
			numofsem--;
			/*
			 * This part checks if the fullhouses are available now. 
			 */
			Iterator<House> fullhsit = fullhouses.iterator();
			while(fullhsit.hasNext()) {
				House house = fullhsit.next();
				house.setDuration(house.getDuration() - 1);
				if(house.getDuration() == 0) {
					fullhsit.remove();
					houses.add(house);
				}	
			}
		}
		/*
		 * Returns the list of students who can not be settled. 
		 */
		students.addAll(graduatedStudents);
		return students;
	}
}
