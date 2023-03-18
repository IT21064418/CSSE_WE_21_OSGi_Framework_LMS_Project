package lecturesubscriber;

import lecturepublisher.ILectureServices;
import lecturepublisher.Lecture;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;


public class LecSubscriberActivator implements BundleActivator {
	
	private ServiceReference lecServiceReference;
	private ServiceRegistration lecServiceReg;
	private ILectureServices lecService;

	public void start(BundleContext context) throws Exception {
		
		lecServiceReg = context.registerService(this.getClass().getName(), this, null);
		lecServiceReference = context.getServiceReference(ILectureServices.class.getName());
		lecService = (ILectureServices) context.getService(lecServiceReference);
		
		lecService.startService();
		System.out.println("Lecture Subscriber Starting....");
		displayMenu();
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Thank you for using the Lecture service console.");
		context.ungetService(lecServiceReference);
		
	}
	
	public void displayMenu() {
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		String loopChk = "Y";
		
		try {
			
			while(loopChk.equalsIgnoreCase("Y")) {
				
				lecService.displayMenu();
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
					lecService.displayMenu();
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
				
					//execute addLecture function
					case 1:
						String lectureName, module, moduleCode, lecturer;
						int duration;
						
						String assmLoop = "Y";
						
						while(assmLoop.equalsIgnoreCase("Y")) {
							
							System.out.println("Enter the lecture name: ");
							lectureName = sc.nextLine();
							lectureName = sc.nextLine();
							System.out.print("Enter the module: ");
							module = sc.nextLine();
							System.out.println("Enter the module code: ");
							moduleCode = sc.nextLine();
							System.out.println("Enter the name of the lecturer: ");
							lecturer = sc.nextLine();
							System.out.println("Enter the lecture duration(in mins): ");
							duration = sc.nextInt();
							
							int status = lecService.addLecture(lectureName, module, moduleCode, lecturer, duration);
							
							if(status == 1) {
								
								System.out.println("Lecture added successfully");
								
							}
							else {
								
								System.out.println("Cannot add Lecture. Try again.");
								
							}
							
							System.out.print("Do you want add another Lecture(Y/N): ");
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
					
					//execute viewLectures function
					case 2:					
						ArrayList<Lecture> lectures = lecService.viewAllLectures();
						
						for (Lecture lecture : lectures) {
							
							System.out.println("Lecture Name: "+ lecture.getLectureName());
							System.out.println("Module: "+ lecture.getModule());
							System.out.println("Module Code: "+ lecture.getModuleCode());
							System.out.println("lecturer: "+ lecture.getLecturer());
							System.out.println("Lecture Duration: "+ lecture.getDuration());
							System.out.println("---------------------------------");
							
						}
						
						break;
					
					//executing removeLecture function
					case 3:
						ArrayList<Lecture> lecturesList = lecService.viewAllLectures();
						int count = 0;
						
						for (Lecture lecture : lecturesList) {
							
							System.out.println("AssesmentIndex: "+ (count+1));
							System.out.println("Lecture Name: "+ lecture.getLectureName());
							System.out.println("Module: "+ lecture.getModule());
							System.out.println("Module Code: "+ lecture.getModuleCode());
							System.out.println("lecturer: "+ lecture.getLecturer());
							System.out.println("Lecture Duration: "+ lecture.getDuration());
							System.out.println("---------------------------------");
							count++;
							
						}
						
						System.out.println("Enter the Lecture Index to delete: ");
						int index = sc.nextInt();
						int delStatus = lecService.removeLecture(index);
						
						if(delStatus == 1) {
							
							System.out.println("Lecture deleted succesfully.");
							
						}
						else {
							
							System.out.println("Cannot delete Lecture. Try again.");
							
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

}
