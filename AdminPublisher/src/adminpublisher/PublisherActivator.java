package adminpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class PublisherActivator implements BundleActivator {

	private ServiceRegistration publishServiceRegistration;
	private Publisher publisher;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Publisher Start...\n");
		Publisher publisher = new PublisherImpl();
		publishServiceRegistration = context.registerService(Publisher.class.getName(),publisher, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Publisher Stop...\n");
		publishServiceRegistration.unregister();
	}

}
