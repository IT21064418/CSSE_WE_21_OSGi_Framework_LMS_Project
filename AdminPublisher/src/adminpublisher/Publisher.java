package adminpublisher;

import java.util.ArrayList;

public interface Publisher {
	public void startService();
	public ArrayList<Lecturer> viewLecturers();
	public int addLecturers(int lecturer_id, String lec_name, String lec_email, String lec_contactno);
	public int removeLecturer(int lecturer_id);
	public void updateLecturerdetails(int lecturer_id);
	public void displayMenu();
	
	
}
