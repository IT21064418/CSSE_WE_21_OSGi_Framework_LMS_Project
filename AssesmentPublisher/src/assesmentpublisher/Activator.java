package assesmentpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration assesmentServiceRegistration;
	private IAssesmentServices iAssesmentServices;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Assesment publisher starting...");
		iAssesmentServices = new AssesmentServiceImpl();
		assesmentServiceRegistration = context.registerService(IAssesmentServices.class.getName(),iAssesmentServices, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Assesment Publisher Stop");
		assesmentServiceRegistration.unregister();
		
	}

}
