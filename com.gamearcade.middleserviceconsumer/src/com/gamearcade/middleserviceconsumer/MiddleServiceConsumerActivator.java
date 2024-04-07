package com.gamearcade.middleserviceconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.gamearcade.middleservicepublisher.IMiddleService;

public class MiddleServiceConsumerActivator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Middle consumer started...\n");
		serviceReference = context.getServiceReference(IMiddleService.class.getName());
		IMiddleService middleservice = (IMiddleService)context.getService(serviceReference);
		
		middleservice.chooseConsumer();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Middle consumer stopped...\n");

		context.ungetService(serviceReference);
	}

}
