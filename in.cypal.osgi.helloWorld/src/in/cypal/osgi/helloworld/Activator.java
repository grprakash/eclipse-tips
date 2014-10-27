package in.cypal.osgi.helloworld;

import java.util.Dictionary;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println(getBundleName(bundleContext) + " started");
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println(getBundleName(bundleContext) + " stopped");
	}

	private String getBundleName(BundleContext bundleContext) {
		Dictionary<String, String> headers = bundleContext.getBundle().getHeaders();
		String bundleName = headers.get("Bundle-Name");
		return bundleName;
	}

}
