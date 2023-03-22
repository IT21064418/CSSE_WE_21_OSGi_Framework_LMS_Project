package assesmentsubscriber;

import assesmentpublisher.Assesment;
import assesmentpublisher.IAssesmentServices;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	private ServiceReference assesmentServiceReference;

	public void start(BundleContext context) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		String loopChk = "Y";
		
		System.out.println("Assesment subscriber starting...");
		
		try {
			
			assesmentServiceReference = context.getServiceReference(IAssesmentServices.class.getName());
			IAssesmentServices asService = (IAssesmentServices) context.getService(assesmentServiceReference);
			
			asService.startService();
			
			while(loopChk.equalsIgnoreCase("Y")) {
				
				asService.displayMenu();
				System.out.print("Enter your choice: ");
				int temp = sc.nextInt();
				
				boolean choiceChk = false;
				
				//validating choice
				if(temp >= 1 && temp <= 4) {
					
					choiceChk = true;
					
				}
				else {
					choiceChk = false;
				}
				
				while(choiceChk == false) {
					
					System.out.println("Invalid Choice. Please enter a valid number.");
					asService.displayMenu();
					System.out.print("Enter your choice: ");
					temp = sc.nextInt();
					
					if(temp >= 1 && temp <= 4) {
						
						choiceChk = true;
						
					}
					else {
						
						choiceChk = false;
						
					}
					
				}
				
				choice = temp;
				
				switch(choice) {
				
					//execute addAssesments function
					case 1:
						String assesmentDisc, startDate, deadLine, assesmentName;
						String assmLoop = "Y";
						
						while(assmLoop.equalsIgnoreCase("Y")) {
							
							System.out.println("Enter the assesmentName: ");
							assesmentName = sc.nextLine();
							sc.nextLine();
							System.out.print("Enter the assesment discription: ");
							assesmentDisc = sc.nextLine();
							System.out.println("Enter the start date(dd-mm-yyyy): ");
							startDate = sc.nextLine();
							System.out.println("Enter the deadline(dd-mm-yyyy): ");
							deadLine = sc.nextLine();
							
							int status = asService.addAssesmnets(assesmentDisc, startDate, deadLine, assesmentName);
							
							if(status == 1) {
								
								System.out.println("Assesment added successfully");
								
							}
							else {
								
								System.out.println("Cannot add assesment. Try again.");
								
							}
							
							System.out.print("Do you want add another assessment(Y/N): ");
							String tempAssm = sc.next();
							
							//initializing variables
							boolean assmCon1,assmCon2,assmCon3 = false;
							
							//validating if the input if Y or y
							if(tempAssm.equals("Y") || tempAssm.equals("y")) {
								assmCon1 = true;
							}
							else {
								assmCon1 = false;
							}
							
							//validating if the input if N or n
							if(tempAssm.equals("N") || tempAssm.equals("n")) {
								assmCon2 = true;
							}
							else {
								assmCon2 = false;
							}
							
							//Assigning necessary conditions for the while loop
							if(assmCon1 == false && assmCon2 == false) {
								assmCon3 = false;
							}
							else {
								assmCon3 = true;
							}
							
							//loop until a correct letter is entered
							while(assmCon3 == false) {
								
								System.out.println("Invalid Input. Please input a valid Letter(Y/N)");
								System.out.print("Do you need to continue (Y/N): ");
								tempAssm = sc.next();
								
								assmCon1 = tempAssm.equalsIgnoreCase("Y");
								assmCon2 = tempAssm.equalsIgnoreCase("N");
								
								if(tempAssm.equals("Y") || tempAssm.equals("y")) {
									assmCon1 = true;
								}
								else {
									assmCon1 = false;
								}
								
								if(tempAssm.equals("N") || tempAssm.equals("n")) {
									assmCon2 = true;
								}
								else {
									assmCon2 = false;
								}
								
								if(assmCon1 == false && assmCon2 == false) {
									assmCon3 = false;
								}
								else {
									assmCon3 = true;
								}
								
							}
							
							//assigning the chosen letter to the variable
							assmLoop = tempAssm;
							
						}
						
						
						break;
					
					//execute viewAssesments function
					case 2:					
						ArrayList<Assesment> assesments = asService.viewAllAssesments();
						
						for (Assesment assesment : assesments) {
							
							System.out.println("Assesment Name: "+ assesment.getAssesmentName());
							System.out.println("Assesment Description: "+ assesment.getAssesmentDisc());
							System.out.println("Start Date: "+ assesment.getStartDate());
							System.out.println("Deadline: "+ assesment.getDeadLine());
							System.out.println("---------------------------------");
							
						}
						
						break;
						
					case 3:
						ArrayList<Assesment> assesmentsList = asService.viewAllAssesments();
						int count = 0;
						
						for (Assesment assesment : assesmentsList) {
							
							System.out.println("AssesmentIndex: "+ (count+1));
							System.out.println("Assesment Name: "+ assesment.getAssesmentName());
							System.out.println("Assesment Description: "+ assesment.getAssesmentDisc());
							System.out.println("Start Date: "+ assesment.getStartDate());
							System.out.println("Deadline: "+ assesment.getDeadLine());
							System.out.println("---------------------------------");
							count++;
							
						}
						
						System.out.println("Enter the Assesment Index to delete: ");
						int index = sc.nextInt();
						int delStatus = asService.removeAssesment(index);
						
						if(delStatus == 1) {
							
							System.out.println("Assesment deleted succesfully.");
							
						}
						else {
							
							System.out.println("Cannot delete assesment. Try again.");
							
						}
						
						break;
						
					case 4:
						break;
				
				}
				
				if(choice == 4) {
					break;
				}
				
				System.out.print("Do you need to return to the menu(Y/N): ");
				String tempString = sc.next();
				
				//initializing variables
				boolean con1,con2,con3 = false;
				
				//validating if the input if Y or y
				if(tempString.equals("Y") || tempString.equals("y")) {
					con1 = true;
				}
				else {
					con1 = false;
				}
				
				//validating if the input if N or n
				if(tempString.equals("N") || tempString.equals("n")) {
					con2 = true;
				}
				else {
					con2 = false;
				}
				
				//Assigning necessary conditions for the while loop
				if(con1 == false && con2 == false) {
					con3 = false;
				}
				else {
					con3 = true;
				}
				
				//loop until a correct letter is entered
				while(con3 == false) {
					
					System.out.println("Invalid Input. Please input a valid Letter(Y/N)");
					System.out.print("Do you need to continue (Y/N): ");
					tempString = sc.next();
					
					con1 = tempString.equalsIgnoreCase("Y");
					con2 = tempString.equalsIgnoreCase("N");
					
					if(tempString.equals("Y") || tempString.equals("y")) {
						con1 = true;
					}
					else {
						con1 = false;
					}
					
					if(tempString.equals("N") || tempString.equals("n")) {
						con2 = true;
					}
					else {
						con2 = false;
					}
					
					if(con1 == false && con2 == false) {
						con3 = false;
					}
					else {
						con3 = true;
					}
					
				}
				
				//assigning the chosen letter to the variable
				loopChk = tempString;
				
			}
			
			System.out.println("ThankYou!!!");
			
		}
		catch (Exception e){
			
			System.out.println(e);
			
		}
		
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Thank you for using the Assesment service console.");
		context.ungetService(assesmentServiceReference);
		
	}

}
