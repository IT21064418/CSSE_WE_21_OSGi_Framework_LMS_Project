package lmsmainmenuconsumer;

import adminsubscriber.SubscriberActivator;
import assesmentsubscriber.AssmConsumerActivator;

import java.util.Scanner;
import lecturesubscriber.LecSubscriberActivator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import studentmanagement_subscriber.Subscriber_Activator;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceReference assmRef;
	private ServiceReference stdRef;
	private ServiceReference lecRef;
	private ServiceReference adminRef;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		//connect to assessment consumer
		assmRef = context.getServiceReference(AssmConsumerActivator.class.getName());
		AssmConsumerActivator assmMangement = (AssmConsumerActivator) bundleContext.getService(assmRef);
		
		//connect to student management consumer
		stdRef = context.getServiceReference(Subscriber_Activator.class.getName());
		Subscriber_Activator stdManagement = (Subscriber_Activator) bundleContext.getService(stdRef);
		
		//connect to lecture Management consumer
		lecRef = context.getServiceReference(LecSubscriberActivator.class.getName());
		LecSubscriberActivator lecManagement = (LecSubscriberActivator) bundleContext.getService(lecRef);
		
		//connect to admin management consumer
		adminRef = context.getServiceReference(SubscriberActivator.class.getName());
		SubscriberActivator adminManagement = (SubscriberActivator) bundleContext.getService(adminRef);
		
		System.out.println("Main menu Loading.....");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("\n================================================");
			System.out.println("\tWelcome to EduMart LMS");
			int option = 0;
			
			System.out.println("================================================");
			System.out.println("\n\nPlease select an option!\n");
			System.out.println("1. Assessment Management");
			System.out.println("2. Lecture Management ");
			System.out.println("3. Student Management ");
			System.out.println("4. Administrator");
			System.out.println("5. Quit \n");

			System.out.print("Select an option :");
			option = sc.nextInt();

			switch (option) {
			case 1:
				assmMangement.displayMenu();
				break;
			case 2:
				lecManagement.displayMenu();
				break;
			case 3:
				stdManagement.displayMenu();
				break;
			case 4:
				adminManagement.displayMenu();
			case 5:
				break;

			}
			
			if(option == 5) {
				
				break;
				
			}			
			
		}
		
		System.out.println("Thank you for using EduMart LMS");
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
