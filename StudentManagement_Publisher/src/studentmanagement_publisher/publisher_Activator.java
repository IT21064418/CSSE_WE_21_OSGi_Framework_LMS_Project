package studentmanagement_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class publisher_Activator implements BundleActivator {

	private ServiceRegistration studentmanagementservice_registration;
	private IStudentManagement_Services iStudentManagement_Services;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("STUDENT MANAGEMENT SYSTEM LOADING.......");
		publisher_Activator.context = bundleContext;
		
		iStudentManagement_Services = new StudentManagement_ServiceImpl();
		studentmanagementservice_registration = context.registerService(IStudentManagement_Services.class.getName(),iStudentManagement_Services, null);
	}

	public void stop(BundleContext context) throws Exception {
		
		publisher_Activator.context = null;
		
		System.out.println("STUDENT MANAGEMENT SYSTEM SHUTINGDOWN.......");
		studentmanagementservice_registration.unregister();
		
	}

}
