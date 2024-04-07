package com.gamearcade.instructionsconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.gamearcade.middleservicepublisher.IMiddleService;

public class InstructionConsumerActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Instruction consumer started...\n");
		serviceReference = context.getServiceReference(IMiddleService.class
				.getName());
		IMiddleService middleService = (IMiddleService) context.getService(serviceReference);
		
		middleService.selectAdminOpt();
	
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Instruction consumer stopped...\n");
		context.ungetService(serviceReference);
	}

}
