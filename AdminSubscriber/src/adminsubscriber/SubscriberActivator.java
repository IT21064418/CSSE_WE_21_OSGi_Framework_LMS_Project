package adminsubscriber;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import adminpublisher.Lecturer;
import adminpublisher.Publisher;
import adminpublisher.PublisherImpl;

public class SubscriberActivator implements BundleActivator {

	private ServiceReference serviceReference;
	private ServiceRegistration adminServiceReg;
	private Publisher lecturerservice;

	Scanner sc = new Scanner(System.in);
	
	public void start(BundleContext context) throws Exception {
		
		adminServiceReg = context.registerService(this.getClass().getName(), this, null);
		serviceReference = context.getServiceReference(Publisher.class.getName());
		lecturerservice = (Publisher) context.getService(serviceReference);
		
		System.out.println("Administrator system loaded");
		lecturerservice.startService();
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Administrator system ended.");
		context.ungetService(serviceReference);
	}
	
	public void displayMenu(){
		
		try {

			char menuinput = 'X';
			do {

				lecturerservice.displayMenu();

				int choice, indexNo, lecturer_id;
				String lec_name, lec_email, lec_contactno;

				System.out.print("SELECT THE NO:");
				choice = sc.nextInt();
				char input = 'X';
				do {

					if (choice == 1) {

						ArrayList<Lecturer> lecturerlist = lecturerservice.viewLecturers();
						for (int i = 0; i < lecturerlist.size(); i++) {
							System.out.print("Enter the Index No:");
							indexNo = sc.nextInt();
							Lecturer lecturer = lecturerlist.get(i);
							if (indexNo == lecturer.getLecturer_id()) {
								System.out.println("Index No Already Exists");
							} else {
								System.out.print("Enter the Lecturer Name:");
								lec_name = sc.nextLine();
								lec_name = sc.nextLine();
								System.out.print("Enter the email:");
								lec_email = sc.next();
								System.out.print("Enter the contact no:");
								lec_contactno = sc.next();

								lecturerservice.addLecturers(indexNo, lec_name, lec_email, lec_contactno);
								System.out.println("Successfully Completed");
								System.out.println("---------------------------------");

								System.out.print("DO YOU WISH TO CONTINUE:");
								input = sc.next().charAt(0);
								if (input == 'N' || input == 'n') {
									System.out.print("DO YOU WISH GO TO MAIN MENU:");
									menuinput = sc.next().charAt(0);
									if (menuinput == 'y'|| menuinput == 'Y') {
										break;
									}
								}
							}
						}

					} else if (choice == 2) {
						ArrayList<Lecturer> lecturerlist = lecturerservice.viewLecturers();
						for (int i = 0; i < lecturerlist.size(); i++) {
							Lecturer lecturer = lecturerlist.get(i);
							System.out.println("Lecturer Index: " + lecturer.getLecturer_id());
							System.out.println("Lecturer Name: " + lecturer.getLec_name());
							System.out.println("Lecturer Email: " + lecturer.getLec_email());
							System.out.println("Lecturer Contact No: " + lecturer.getLec_contactno());
							System.out.println("---------------------------------");
						}
						System.out.print("DO YOU WISH GO TO MAIN MENU:");
						menuinput = sc.next().charAt(0);
						System.out.println("---------------------------------");
					} else if (choice == 3) {
						System.out.println("Enter the Lecturer Index number to delete: ");
						int index = sc.nextInt();
						ArrayList<Lecturer> lecturerlist = lecturerservice.viewLecturers();
						for (int i = 0; i < lecturerlist.size(); i++) {

							Lecturer lecturer = lecturerlist.get(i);
							if (index == lecturer.getLecturer_id()) {
								System.out.println("Lecturer Index: " + lecturer.getLecturer_id());
								System.out.println("Lecturer Name: " + lecturer.getLec_name());
								System.out.println("Lecturer Email: " + lecturer.getLec_email());
								System.out.println("Lecturer Contact No: " + lecturer.getLec_contactno());
								System.out.println("---------------------------------");
								System.out.print("Are You Sure Want To Delete:");
								char delete = sc.next().charAt(0);
								if (delete == 'Y' || delete == 'y') {
									lecturerservice.removeLecturer(index);
									System.out.println("Successfully Completed");
								}
							}
						}
						System.out.print("DO YOU WISH TO CONTINUE:");
						input = sc.next().charAt(0);
						System.out.print("DO YOU WISH GO TO MAIN MENU:");
						menuinput = sc.next().charAt(0);
						System.out.println("---------------------------------");
					} else if (choice == 4) {
						System.out.print("Enter the Lecturer Index number to update:");
						indexNo = sc.nextInt();
						lecturerservice.updateLecturerdetails(indexNo);
						System.out.print("DO YOU WISH TO CONTINUE:");
						input = sc.next().charAt(0);
						System.out.print("DO YOU WISH GO TO MAIN MENU:");
						menuinput = sc.next().charAt(0);
						System.out.println("---------------------------------");
						if (menuinput == 'y'|| menuinput == 'Y') {
							break;
						}

					} else if (choice == 5) {
						System.out.println("Thank You For Using Our LMS System");
						
					} else {
						System.out.println("Invalid Selection Please Input");
						System.out.print("DO YOU WISH GO TO MAIN MENU:");
						menuinput = sc.next().charAt(0);
						System.out.println("---------------------------------");
					}
				} while (input == 'Y' || input == 'y');
			} while (menuinput == 'Y' || menuinput == 'y');

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
