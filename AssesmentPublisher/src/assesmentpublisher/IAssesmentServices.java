package assesmentpublisher;

import java.util.ArrayList;

public interface IAssesmentServices {
	
	public void startService();
	public ArrayList<Assesment> viewAllAssesments();
<<<<<<< Updated upstream
	public int addAssesmnets(String assesmentDisc, String startDate,
			String deadLine, String assesmentName);
=======
	public int addAssesmnets(String assesmentDisc, String startDate, String deadLine, String assesmentName);
>>>>>>> Stashed changes
	public int removeAssesment(int index);
	public void displayMenu();
	

}
