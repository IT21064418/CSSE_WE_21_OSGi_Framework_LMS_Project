package lmsmainmenuconsumer;

import assesmentsubscriber.AssmConsumerActivator;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import studentmanagement_subscriber.Subscriber_Activator;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceReference assmRef;
	private ServiceReference stdRef;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		//connect to assessment consumer class
		assmRef = context.getServiceReference(AssmConsumerActivator.class.getName());
		AssmConsumerActivator assesments = (AssmConsumerActivator) bundleContext.getService(assmRef);
		
		//connect to student management consumer class
		stdRef = context.getServiceReference(Subscriber_Activator.class.getName());
		Subscriber_Activator stdManagement = (Subscriber_Activator) bundleContext.getService(stdRef);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("\n=================================");
			System.out.println("Welcome to Pakaya LMS");
			int option = 0;
			
			System.out.println("\n=================================");
			System.out.println("\n\n\nPlease select an option!\n");
			System.out.println("1. Assessment Management");
			System.out.println("2. Lecture Management ");
			System.out.println("3. Student Management ");
			System.out.println("4. Administrator");
			System.out.println("5. Quit \n\n");

			System.out.print("Select an option :");
			option = sc.nextInt();

			switch (option) {
			case 1:
				assesments.displayMenu();
				break;
			case 2:
				System.out.println("Lecture Management");
				break;
			case 3:
				stdManagement.displayMenu();
				break;
			case 4:
				System.out.println("Administrator Management");
			case 5:
				break;

			}
			
			if(option == 5) {
				
				break;
				
			}			
			
		}
		
		System.out.println("Thank you for using Pakaya LMS");
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
