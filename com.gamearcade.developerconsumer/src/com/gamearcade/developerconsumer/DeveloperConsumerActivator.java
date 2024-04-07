package com.gamearcade.developerconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.gamearcade.developerpublisher.IDeveloperPublisher;
import com.gamearcade.middleservicepublisher.IMiddleService;


public class DeveloperConsumerActivator implements BundleActivator {

	@SuppressWarnings("rawtypes")
	ServiceReference gamePublisherServiceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Developer consumer started...\n");
		gamePublisherServiceReference = context.getServiceReference(IMiddleService.class
				.getName());
		IMiddleService middleService = (IMiddleService) context.getService(gamePublisherServiceReference);
		
		middleService.selectEventOrganizerOpt();
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Developer consumer stopped...\n");
		context.ungetService(gamePublisherServiceReference);
	}

}
