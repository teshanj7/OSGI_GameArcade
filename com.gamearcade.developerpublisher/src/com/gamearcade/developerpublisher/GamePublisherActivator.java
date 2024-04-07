package com.gamearcade.developerpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class GamePublisherActivator implements BundleActivator {

	@SuppressWarnings("rawtypes")
	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Game publisher started...\n");
		
		IDeveloperPublisher gamePublisher = new DeveloperPublisherImpl();
		publishServiceRegistration = context.registerService(IDeveloperPublisher.class.getName(), gamePublisher, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Game publisher stopped...\n");
		publishServiceRegistration.unregister();
	}

}
