package com.gamearcade.instructionpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class InstructionPublisherActivator implements BundleActivator {

	ServiceRegistration InstructionserviceReference;
	
	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Instruction Publisher started...\n");
		IInstruction instructionPublisher = new IInstructionImpl();
		InstructionserviceReference = context.registerService(IInstruction.class.getName(), instructionPublisher, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Instruction Publisher stopped...\n");
		InstructionserviceReference.unregister();
		
	}

}
