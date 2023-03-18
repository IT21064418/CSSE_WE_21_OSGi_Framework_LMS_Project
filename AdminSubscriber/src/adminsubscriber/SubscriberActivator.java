package adminsubscriber;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import adminpublisher.Lecturer;
import adminpublisher.Publisher;
import adminpublisher.PublisherImpl;

public class SubscriberActivator implements BundleActivator {

	private ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("LECTURER MANAGEMENT SYSTEM LOADED........\n");

		try {
			serviceReference = context.getServiceReference(Publisher.class.getName());
			Publisher lecturerservice = (Publisher) context.getService(serviceReference);

			lecturerservice.startService();
			char menuinput = 'X';
			do {

				lecturerservice.displayMenu();

				int choice, indexNo, lecturer_id;
				String lecturer_name, lecturer_email, lecturer_contactno;

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
								lecturer_name = sc.next();
								System.out.print("Enter the email:");
								lecturer_email = sc.next();
								sc.nextLine();
								System.out.print("Enter the contact no:");
								lecturer_contactno = sc.next();

								lecturerservice.addLecturers(indexNo, lecturer_name, lecturer_email,
										lecturer_contactno);
								System.out.println("Successfully Completed");
								System.out.println("---------------------------------");

								System.out.print("DO YOU WISH TO CONTINUE:");
								input = sc.next().charAt(0);
								if (input == 'N' || input == 'n') {
									System.out.print("DO YOU WISH GO TO MAIN MENU:");
									menuinput = sc.next().charAt(0);
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
						System.out.println("Enter the Student Index to delete: ");
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
						System.out.print("Enter the Index No:");
						indexNo = sc.nextInt();
						lecturerservice.updateLecturerdetails(indexNo);
						System.out.print("DO YOU WISH TO CONTINUE:");
						input = sc.next().charAt(0);
						System.out.print("DO YOU WISH GO TO MAIN MENU:");
						menuinput = sc.next().charAt(0);
						System.out.println("---------------------------------");

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

	public void stop(BundleContext context) throws Exception {
		System.out.println("LECTURER SERVICE ENDED");
		context.ungetService(serviceReference);
	}

}
