package assesmentpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
<<<<<<< Updated upstream

	private ServiceRegistration assesmentServiceRegistration;
	private IAssesmentServices iAssesmentServices;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Assesment publisher starting...");
		iAssesmentServices = new AssesmentServiceImpl();
		assesmentServiceRegistration = context.registerService(IAssesmentServices.class.getName(),iAssesmentServices, null);
=======
	
	private static BundleContext context;
	private ServiceRegistration assesmentServiceRegistration;
	private IAssesmentServices iAssesmentServices;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Assesment publisher starting...");
		Activator.context = bundleContext;
		
		//look here if error
		iAssesmentServices = new AssesmentServiceImpl();
		assesmentServiceRegistration = bundleContext.registerService(IAssesmentServices.class.getName(),iAssesmentServices, null);
>>>>>>> Stashed changes
		
	}

	public void stop(BundleContext context) throws Exception {
		
<<<<<<< Updated upstream
=======
		Activator.context = null;
		
>>>>>>> Stashed changes
		System.out.println("Assesment Publisher Stop");
		assesmentServiceRegistration.unregister();
		
	}

}
