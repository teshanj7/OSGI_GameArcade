package com.gamearcade.eventconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.gamearcade.eventpublisher.IEventPublisher;
import com.gamearcade.middleservicepublisher.IMiddleService;

public class EventConsumerActivator implements BundleActivator {
	
	@SuppressWarnings("rawtypes")
	ServiceReference eventPublisherServiceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Event consumer started...\n");

		eventPublisherServiceReference = context.getServiceReference(IMiddleService.class
				.getName());
		IMiddleService middleService = (IMiddleService) context.getService(eventPublisherServiceReference);
		
		middleService.selectEventOrganizerOpt();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Event consumer stopped...\n");
		context.ungetService(eventPublisherServiceReference);
	}

}
