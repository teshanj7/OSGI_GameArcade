package com.gamearcade.middleservicepublisher;

import com.gamearcade.developerpublisher.DeveloperPublisherImpl;
import com.gamearcade.developerpublisher.IDeveloperPublisher;
import com.gamearcade.eventpublisher.EventPublisherImpl;
import com.gamearcade.eventpublisher.IEventPublisher;
import com.gamearcade.gamepublisher.GamePublisherImpl;
import com.gamearcade.gamepublisher.IGamePublisher;
import com.gamearcade.instructionpublisher.IInstruction;
import com.gamearcade.instructionpublisher.IInstructionImpl;

import java.util.Scanner;

public class IMiddleServiceImpl implements IMiddleService {

	  IEventPublisher eventPublisher;
	  IInstruction instructinPublisher;
	  IGamePublisher gamePublisher;
	  IDeveloperPublisher developerPublisher;
	  private static IMiddleServiceImpl instance;
	
	//constructor
	private IMiddleServiceImpl() {
		eventPublisher = new EventPublisherImpl();
		instructinPublisher = new IInstructionImpl();
		gamePublisher = new GamePublisherImpl();
		developerPublisher = new DeveloperPublisherImpl();
	}
	
	public static IMiddleServiceImpl getMidService() {
		
		if(instance == null) {
			instance = new IMiddleServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void chooseConsumer() {
		int choice;
        boolean ex = true;
        Scanner scanner = new Scanner(System.in);
        do {
        	System.out.println("-----------------------------------------------------------------");
            System.out.println("             ~ Welcome to Game Arcade System ~ ");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Enter your choice to continue:");
            System.out.println("1. Admin");
            System.out.println("2. Event Organizer");
            System.out.println("3. Player");
            System.out.println("4. Developer");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                	this.selectAdminOpt();
                    break;
                case 2:
                    this.selectEventOrganizerOpt();
                    break;
                case 3: 
                	this.selectPlayerOpt();
                	break;
                case 4: 
                	this.selectDevloperOpt();
                	break;
                case 5: 
                	System.out.println("Exiting...Thank you!\n");
                	ex = false;
                	break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (ex);
		
	}
	
	@Override
	public void selectAdminOpt() {
		
		int choice;
        boolean ex = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Dear Admin,\nPlease enter your choice to continue:");
            System.out.println("1. Play a game");
            System.out.println("2. Manage Instruction");
            System.out.println("3. View GameDetails");
            System.out.println("4. View Event Details");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                	gamePublisher.selectGame();
                    break;
                case 2:
                	instructinPublisher.chooseAnOption("admin");
                    break;
                case 3:
                	developerPublisher.selectGameOption("admin");
                    break;
                case 4:
                	eventPublisher.selectOption("admin");
                    break;
                case 5: 
                	System.out.println("Exiting...\n");
                	ex = false;
                	break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (ex);
		
		
		
	}

	@Override
	public void selectPlayerOpt() {
		int choice;
        boolean ex = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Dear Player,\nPlease enter your choice to continue:");
            System.out.println("1. Play a game");
            System.out.println("2. View Instructions");
            System.out.println("3. View GameDetails");
            System.out.println("4. View Event Details");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                	gamePublisher.selectGame();
                    break;
                case 2:
                	instructinPublisher.displayInstructions();
                    break;
                case 3:
                	developerPublisher.viewAllGames();
                    break;
                case 4:
                	eventPublisher.viewAllEvents();
                    break;
                case 5: 
                	System.out.println("Exiting...\n");
                	ex = false;
                	break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (ex);
		
	}

	@Override
	public void selectEventOrganizerOpt() {
		
		eventPublisher.selectOption("eventOrganizer");
		
	}

	

	@Override
	public void selectDevloperOpt() {
		
		developerPublisher.selectGameOption("Developer");
		
	}

		
}
