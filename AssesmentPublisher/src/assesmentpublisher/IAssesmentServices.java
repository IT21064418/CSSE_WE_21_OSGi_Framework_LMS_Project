package assesmentpublisher;

import java.util.ArrayList;

public interface IAssesmentServices {
	
	public void startService();
	public void viewAllAssesments();
	public int addAssesmnets(String assesmentDisc, String startDate, String deadLine, String assesmentName);
	public int removeAssesment(int index);
	public void displayMenu();
	

}
