package adminpublisher;

import java.util.ArrayList;
import java.util.Scanner;

public class PublisherImpl implements Publisher{


	private ArrayList<Lecturer> lecturerlist = new ArrayList<Lecturer>();
	Scanner sc = new Scanner(System.in); 
	@Override
	public void startService() {
		System.out.println("-------------WELCOME TO THE ADMIN-------------");
		
		Lecturer lecturer_1 = new Lecturer(1, "Thusitha Perera", "thusitha7@gmail.com", "0778956550");
		Lecturer lecturer_2 = new Lecturer(2, "Mahen Fernando", "mahen.f@gmail.com", "0717785623");
		Lecturer lecturer_3 = new Lecturer(3, "Geeshani Mendis", "geeshani.m@gmial.com", "0761547877");
		Lecturer lecturer_4 = new Lecturer(4, "Samitha Gomez", "samitha55@gmail.com", "0777802524");
		
		lecturerlist.add(lecturer_1);
		lecturerlist.add(lecturer_2);
		lecturerlist.add(lecturer_3);
		lecturerlist.add(lecturer_4);
	}

	@Override
	public ArrayList<Lecturer> viewLecturers() {
		return lecturerlist;
	}

	@Override
	public int addLecturers (int lecturer_id, String lec_name, String lec_email, String lec_contactno) {
		
		Lecturer newLecturer = new Lecturer(lecturer_id, lec_name, lec_email, lec_contactno);
		lecturerlist.add(newLecturer);
		
		return 1;
	}

	@Override
	public int removeLecturer(int id) {
		int positionArr = id - 1;
		lecturerlist.remove(positionArr);
		return 1;
	}

	@Override
	public void displayMenu() {
		
		System.out.println("\n---MENU---");
		System.out.println("1. ADD Lecturer");
		System.out.println("2. VIEW Lecturers");
		System.out.println("3. DELETE Lecturer");
		System.out.println("4. UPDATE Lecturer");
		System.out.println("5. Exit");
		System.out.println();
	}

	@Override
	public void updateLecturerdetails(int lecturer_id) {
		ArrayList<Lecturer> lecturerlist = viewLecturers();
		for(int i=0;i<lecturerlist.size();i++) {
			Lecturer lecturer = lecturerlist.get(i);
			if(lecturer_id == lecturer.getLecturer_id()) {
    		    System.out.println("Lecturer Index: "+ lecturer.getLecturer_id());
    		    System.out.println("Lecturer Name: "+ lecturer.getLec_name());
    		    System.out.println("Lecturer Email: "+ lecturer.getLec_email());
    		    System.out.println("Lecturer Contact No: "+ lecturer.getLec_contactno());
    		    System.out.println("---------------------------------");
    		    System.out.print("Are You Sure Want To Update: ");
    		    char delete = sc.next().charAt(0);
    		    if(delete=='Y' || delete=='y') {
	  		          System.out.print("Enter the Lecturer Name: ");
			          String lec_name = sc.nextLine();
			          lec_name = sc.nextLine();
			          System.out.print("Enter the Lecturer email: ");
			          String lec_email = sc.nextLine();
			          System.out.print("Enter the contact no: ");
			          String lec_contactno = sc.nextLine();
			          
			          lecturer.setLec_name(lec_name);
					  lecturer.setLec_email(lec_email);
					  lecturer.setLec_contactno(lec_contactno);
	
    		    }
			}
		}
		
	}		
		

}
