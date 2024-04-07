package com.gamearcade.middleservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class MiddleServicePublsherActivator implements BundleActivator {

	ServiceRegistration middleServicePublisherRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Middle service publisher started...\n");
		IMiddleService middleService = IMiddleServiceImpl.getMidService();
		middleServicePublisherRegistration = context.registerService(
				IMiddleService.class.getName(), middleService, null);

	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Middle service publisher stopped...");
		middleServicePublisherRegistration.unregister();
	}

}
