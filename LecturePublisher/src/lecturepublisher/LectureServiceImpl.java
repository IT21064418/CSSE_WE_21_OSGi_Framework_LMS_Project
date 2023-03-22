package lecturepublisher;

import java.util.ArrayList;
import java.util.Scanner;

public class LectureServiceImpl implements ILectureServices{
	
	private ArrayList<Lecture> lecturesList = new ArrayList<Lecture>();

	@Override
	public void startService() {
		
		System.out.println("Lecture management services Started.");
		
		Lecture lecture1 = new Lecture("SA Lecture 01", "Software Architecture", "SE3030", "Ms.Karthiga Rajendran", 90 );
		Lecture lecture2 = new Lecture("AF Lecture 01", "Application Frameworks", "SE3040", "Mr.Thusithanjana Thilakarathna", 90 );
		Lecture lecture3 = new Lecture("SEPQM Lecture 01", "Software Engineering process and Qualtiy Management", "SE3010", "Mr.Samitha Vidhanaarachchi", 90 );
		
		lecturesList.add(lecture1);
		lecturesList.add(lecture2);
		lecturesList.add(lecture3);
		
	}

	@Override
	public ArrayList<Lecture> viewAllLectures() {
		
		return lecturesList;
		
	}

	@Override
	public int addLecture(String lectureName, String module, String moduleCode, String lecturer, int duration) {
		Lecture newLecture = new Lecture(lectureName, module, moduleCode, lecturer, duration);
		lecturesList.add(newLecture);
		return 1;
	}

	@Override
	public int removeLecture(int index) {
		
		int arrPosition = index - 1;
		lecturesList.remove(arrPosition);
		return 1;
		
	}
	
	public int updateLecture(int index) {
		
		Scanner sc = new Scanner(System.in);
		
		int arrPosition = index - 1;
		
		Lecture lecture = lecturesList.get(arrPosition);
		
		System.out.println("Lecture Name: "+ lecture.getLectureName());
		System.out.println("Module: "+ lecture.getModule());
		System.out.println("Module Code: "+ lecture.getModuleCode());
		System.out.println("lecturer: "+ lecture.getLecturer());
		System.out.println("Lecture Duration: "+ lecture.getDuration());
		System.out.println("---------------------------------");
	    System.out.print("Are You Sure Want To Update:");
	    char update = sc.next().charAt(0);
	    
	    if(update == 'Y' || update == 'y') {
	    	
	    	System.out.println("Enter the lecture name: ");
			String lectureName = sc.nextLine();
			lectureName = sc.nextLine();
			System.out.print("Enter the module: ");
			String module = sc.nextLine();
			System.out.println("Enter the module code: ");
			String moduleCode = sc.nextLine();
			System.out.println("Enter the name of the lecturer: ");
			String lecturer = sc.nextLine();
			System.out.println("Enter the lecture duration(in mins): ");
			int duration = sc.nextInt();
			
			lecture.setLectureName(lectureName);
			lecture.setModule(module);
			lecture.setModuleCode(moduleCode);
			lecture.setLecturer(lecturer);
			lecture.setDuration(duration);
			
			System.out.println("Lecture Name: "+ lecture.getLectureName());
			System.out.println("Module: "+ lecture.getModule());
			System.out.println("Module Code: "+ lecture.getModuleCode());
			System.out.println("lecturer: "+ lecture.getLecturer());
			System.out.println("Lecture Duration: "+ lecture.getDuration());
			System.out.println("---------------------------------");
	    	
	    }
		
		return 1;
		
	}

	@Override
	public void displayMenu() {
		
		System.out.println("Welcome to Lecture management menu");
		System.out.println("1. Add Lectures");
		System.out.println("2. Update Lecture");
		System.out.println("3. View Lectures");
		System.out.println("4. Remove Lecture");
		System.out.println("5. Quit");
		System.out.println();
		
	}

}
