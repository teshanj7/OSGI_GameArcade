package com.gamearcade.adminconsumer;

import com.gamearcade.middleservicepublisher.IMiddleService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class AdminConsumerActivator implements BundleActivator {
	
	ServiceReference serviceReference;
	
	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Admin consumer started...\n");

		serviceReference = context.getServiceReference(IMiddleService.class
				.getName());
		IMiddleService middleService = (IMiddleService) context
				.getService(serviceReference);
		
		middleService.chooseConsumer();	
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Admin consumer stopped...\n");
		context.ungetService(serviceReference);
	}

}
