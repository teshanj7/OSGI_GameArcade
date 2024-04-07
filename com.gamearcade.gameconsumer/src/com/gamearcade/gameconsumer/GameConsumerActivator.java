package com.gamearcade.gameconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.gamearcade.gamepublisher.IGamePublisher;

public class GameConsumerActivator implements BundleActivator {

    ServiceReference serviceReference;

    public void start(BundleContext context) throws Exception {
        System.out.println("Game consumer started...\n ");

        // Retrieve the service reference for IGamePublisher
        serviceReference = context.getServiceReference(IGamePublisher.class.getName());

        // Check if the service reference is not null
        if (serviceReference != null) {
            // Get the service object
            IGamePublisher gamePublisher = context.getService(serviceReference);

            if (gamePublisher != null) {
                gamePublisher.selectGame();
            } else {
                System.out.println("Failed to obtain the game publisher service.");
            }
        } else {
            System.out.println("IGamePublisher service reference not found.");
        }
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Game consumer stopped...\n ");
        context.ungetService(serviceReference);
    }

}
