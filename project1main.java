
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class project1main {
	public static void main(String[] args) {
		/*
		*This part is to create necessary data structures to store the data of students and houses. It also takes a input file in 
		*which the information about students and houses provided in random order.
		*/		
		File inputfile = new File(args[0]);
		TreeSet<Student> newStudents = new TreeSet<Student>();
		TreeSet<Student> students = new TreeSet<Student>();
		TreeSet<House> houses = new TreeSet<House>();
		TreeSet<House> fullhouses = new TreeSet<House>();
		int numofsem = 0;
		Scanner sc;
		try {
			sc = new Scanner(inputfile);
		}catch(FileNotFoundException e1) {
			e1.printStackTrace();
			return;
		}
		/*Input handling part. This part creates house and student objects with the given data and separates them into different treeset 
		*according to their type and duration.
		*/ 
		while(sc.hasNext()) {
			String recordtype = sc.next();
			switch(recordtype) {
			case "h":
				House house = new House(sc.nextInt(),sc.nextInt(),sc.nextDouble());
				if(house.getDuration() > 0 ) {
					fullhouses.add(house);
				}
				else {
					houses.add(house);
			}
				break;
			case "s":
				Student student = new Student(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextDouble());
				if(student.getDuration()>numofsem) numofsem = student.getDuration();
				students.add(student);
				break;
			}
		}
		sc.close();
		//Simulation is executed in this part.(You can find necessary information regarding simulation in simulation class.)
		newStudents = HouseSimulation.runHouseSimulation(houses,fullhouses, students, numofsem);
		
		/*Output Handling Part
		 * This part is to write names of students who cannot be settled into a house during his univeristy life to 
		 * the output file the name of which is provided by user.
		 */
		File outputfile = new File(args[1]);
		PrintStream outstream;
		try {
			outstream = new PrintStream(outputfile);
		} catch(FileNotFoundException e1) {
			e1.printStackTrace();
			return;
		}
		Iterator<Student> studentsit = newStudents.iterator();
		while(studentsit.hasNext()){
			Student student =studentsit.next();
			outstream.println(student.getName());
		}
		outstream.close();
	}
}
