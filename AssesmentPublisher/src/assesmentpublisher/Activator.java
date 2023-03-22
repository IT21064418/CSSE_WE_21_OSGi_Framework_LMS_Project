package assesmentpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	private static BundleContext context;
	private ServiceRegistration assesmentServiceRegistration;
	private IAssesmentServices iAssesmentServices;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Assesment management services starting.....");
		Activator.context = bundleContext;

		iAssesmentServices = new AssesmentServiceImpl();
		assesmentServiceRegistration = bundleContext.registerService(IAssesmentServices.class.getName(),iAssesmentServices, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		Activator.context = null;
		
		System.out.println("Assesment management services ending.....");
		assesmentServiceRegistration.unregister();
		
	}

}
