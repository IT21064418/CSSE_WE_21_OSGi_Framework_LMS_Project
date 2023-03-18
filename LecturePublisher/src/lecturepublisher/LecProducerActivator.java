package lecturepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class LecProducerActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration lecServiceRegistration;
	private ILectureServices iLectureServices;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Lecture publisher Starting");
		LecProducerActivator.context = bundleContext;
		
		iLectureServices = new LectureServiceImpl();
		lecServiceRegistration = bundleContext.registerService(ILectureServices.class.getName(), iLectureServices, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		LecProducerActivator.context = null;
		
		System.out.println("Lecture Publisher Stop");
		lecServiceRegistration.unregister();
		
	}

}
