package studentmanagement_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class publisher_Activator implements BundleActivator {

	private ServiceRegistration studentmanagementservice_registration;
	private IStudentManagement_Services iStudentManagement_Services;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("STUDENT MANAGEMENT SYSTEM LOADING.......");
		iStudentManagement_Services = new StudentManagement_ServiceImpl();
		studentmanagementservice_registration = context.registerService(IStudentManagement_Services.class.getName(),iStudentManagement_Services, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("STUDENT MANAGEMENT SYSTEM SHUTINGDOWN.......");
		studentmanagementservice_registration.unregister();
	}

}
