package adminpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class PublisherActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration publishServiceRegistration;
	private Publisher publisher;
	
	static BundleContext getContext() {
		return context;
	}
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Adminstrator services starting.....");
		PublisherActivator.context = context;
		
		Publisher publisher = new PublisherImpl();
		publishServiceRegistration = context.registerService(Publisher.class.getName(),publisher, null);
	
	}

	public void stop(BundleContext context) throws Exception {
		
		PublisherActivator.context = null;
		System.out.println("Administartor services ending.....");
		publishServiceRegistration.unregister();
		
	}

}
