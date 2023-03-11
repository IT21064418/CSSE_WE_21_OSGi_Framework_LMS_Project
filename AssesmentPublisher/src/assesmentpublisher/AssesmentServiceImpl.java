package assesmentpublisher;

import java.util.ArrayList;

public class AssesmentServiceImpl implements IAssesmentServices{

	private ArrayList<Assesment> assesmentsList = new ArrayList<Assesment>();
	
	@Override
	public void startService() {
		
		System.out.println("Assesment services Starting...");
		
		Assesment assesment1 = new Assesment("write a blog on industry best practises of MERN",
				"7-02-2023", "14-02-2023", "MERN best practises blog");
		Assesment assesment2 = new Assesment("develop a web application using MERN stack",
				"23-02-2023", "23-04-2023", "MERN Web Application");
		Assesment assesment3 = new Assesment("develop an simple programme using OSGI plugin Architecture",
				"12-02-2023", "26-02-2023", "OSGI Programme");
		
		assesmentsList.add(assesment1);
		assesmentsList.add(assesment2);
		assesmentsList.add(assesment3);
		
	}

	@Override
	public ArrayList<Assesment> viewAllAssesments() {
		
		return assesmentsList;
		
	}

	@Override
	public int addAssesmnets(String assesmentDisc, String startDate, String deadLine,
			String assesmentName) {
		
		Assesment newAssesment = new Assesment(assesmentDisc, startDate, deadLine, assesmentName);
		assesmentsList.add(newAssesment);
		
		return 1;
		
	}

	@Override
	public int removeAssesment(int index) {
		
		int arrPosition = index - 1;
		assesmentsList.remove(arrPosition);
		return 1;
		
	}

	@Override
	public void displayMenu() {
		
		System.out.println("Welcome to assesment management menue");
		System.out.println("1. Add Assesments");
		System.out.println("2. View Assesments");
		System.out.println("3. Remove Assesments");
		System.out.println("4. Quit");
		System.out.println();
		
	}

}
