package studentmanagement_publisher;

import java.util.ArrayList;

public interface IStudentManagement_Services {
	public void startService();
	public ArrayList<Student> viewStudents();
	public int Addstudents(int std_id, String std_name, String std_degreeprogram, int std_year);
	public int removestudent(int std_id);
	public void updatestudentdetails(int std_id);
	public void displayMenu();
}
