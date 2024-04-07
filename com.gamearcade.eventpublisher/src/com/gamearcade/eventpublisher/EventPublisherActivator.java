package com.gamearcade.eventpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class EventPublisherActivator implements BundleActivator {
	
	@SuppressWarnings("rawtypes")
	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Event publisher started...\n");
		IEventPublisher eventPublisher = new EventPublisherImpl();
        publishServiceRegistration = context.registerService(
                IEventPublisher.class.getName(), eventPublisher, null);

	}

	public void stop(BundleContext context) throws Exception {
        System.out.println("Event publisher stopped...\n");
        publishServiceRegistration.unregister();
	}

}
