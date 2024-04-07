package com.gamearcade.gamepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class GamePublisherActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Game publisher started...\n");
		IGamePublisher gamePublisher = new GamePublisherImpl();
		publishServiceRegistration = context.registerService(
				IGamePublisher.class.getName(), gamePublisher, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Game publisher stopped...\n");
		publishServiceRegistration.unregister();
	}

}
