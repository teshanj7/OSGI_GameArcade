package com.gamearcade.eventpublisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventPublisherImpl implements IEventPublisher{
	
	protected List<EventModel> events;
	
    public EventPublisherImpl() {
        super();
        events = new ArrayList<EventModel>();
      
        EventModel e1 = new EventModel("E001","Gaming office open","Opening Event","2024/03/21","Hilton","3 hours");
        EventModel e2 = new EventModel("E002","Gaming Launch","Launching Event","2024/04/02","Cinnoman","4 hours");
        
        events.add(e1);
        events.add(e2);
        
    }

	@Override
	public void selectOption(String consumer) {
		@SuppressWarnings("resource")
		Scanner ex = new Scanner(System.in);

		boolean run = true;
		do {
			if(consumer.equals("admin")) {
				System.out.println("Select your choice(1-3) :");
				System.out.println("1 - View all Events");
				System.out.println("2 - Search event by Id");
				System.out.println("3 - Exit");

				int response = ex.nextInt();
				switch (response) {

				case 1:
					this.viewAllEvents();
					break;
				case 2:
					this.searchEventById();
					break;
				case 3:
					System.out.println("Exiting...Thank you!\n");
					run = false;
					break;
				default:
					System.out.print("Wrong option");
				
				}
			}
			else {
				// options for Event Publisher
				System.out.println("Select your choice(1-6) :");
				System.out.println("1 - Add a new event");
				System.out.println("2 - View all events");
				System.out.println("3 - Search event by Id");
				System.out.println("4 - Update event");
				System.out.println("5 - Delete event by Id");
				System.out.println("6 - Exit");

				int response = ex.nextInt();
				switch (response) {

				case 1:
					this.addNewEvent();
					break;
				case 2:
					this.viewAllEvents();
					break;
				case 3:
					this.searchEventById();
					break;
				case 4:
					this.updateEvent();
					break;
				case 5:
					this.deleteEventById();
					break;
				case 6:
					System.out.println("Exiting...Thank you!\n");
					run = false;
					break;
				default:
					System.out.print("Wrong option");
			}
			}
			
		} while (run == true);
	}

	@Override
	public void addNewEvent() {
		
		char isContinue = 'y';
		while(isContinue == 'y') {
	        @SuppressWarnings("resource")
			Scanner add = new Scanner(System.in);
	        System.out.println("===========Add New Event=============");
	       
	        EventModel newEvent = new EventModel();
	        
	        System.out.print("Enter event ID: ");
	        newEvent.setEventId(add.nextLine());
	        
	        System.out.print("Enter event name: ");
	        newEvent.setEventName(add.nextLine());
	        
	        System.out.print("--All Events Categories--\n");
	        this.displayAllEventCategories();
	        System.out.print("Enter event type: ");
	        newEvent.setEventType(add.nextLine());
	        
	        System.out.print("Enter event date(DD/MM/YYY): ");
	        newEvent.setEventDate(add.nextLine());
	        
	        System.out.print("Enter event location: ");
	        newEvent.setEventLocation(add.nextLine());
	        
	        System.out.print("Enter event duration: ");
	        newEvent.setEventDuration(add.nextLine());
	    
	        events.add(newEvent);
	        System.out.println("'"+newEvent.getEventName()+"' "+"added successfully!");
	        
	        System.out.println("--------------------------------------------");
	        System.out.println("Do you want to add another event? (Y/N) ");
	        isContinue = (add.next().charAt(0));
	        if(isContinue == 'y' || isContinue == 'Y') {
				isContinue = 'y';
			}
			else if(isContinue == 'n' || isContinue == 'N') {
				System.out.println("Exit..");
				break;
			}else {
				while(true) {
					System.out.println("Invalid input!");
					System.out.println("( Please enter Y or N )");
					isContinue = (add.next().charAt(0));
					if(isContinue == 'y' || isContinue == 'Y' || isContinue == 'n' || isContinue == 'N') {
						break;
					}
				}
			}
		}
	}

	@Override
	public void viewAllEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }
		System.out.println();
		System.out.println("==============View All Events================");
        for (EventModel event : events) {
            System.out.println(event.toString());
            System.out.println();
        }
	}

	@Override
	public void searchEventById() {
		
        @SuppressWarnings("resource")
		Scanner add = new Scanner(System.in);
		System.out.println();
		System.out.println("==============View Event===============");
		
	    System.out.println("----Current Event IDs----");
	    for (EventModel event : events) {
	        System.out.println(event.getEventId());
	    }
        System.out.print("Enter event ID to search: ");
        String eventId = add.next();
        
        System.out.println("\n");
        boolean found = false;
        for (EventModel event : events) {
           if (event.getEventId().equalsIgnoreCase(eventId)) {
        	   System.out.println("==============");
               System.out.println("Event found");
               System.out.println("==============");
               System.out.println(event.toString());
               System.out.println("\n");
               found = true;
               break;
            }
        }
        if (!found) {
            System.out.println("Event not found.");
        }
	}

	@Override
	public void deleteEventById() {
		
        @SuppressWarnings("resource")
		Scanner add = new Scanner(System.in);
		System.out.println();
		System.out.println("==============Delete Event===============");
		
	    System.out.println("----Current Event IDs----");
	    for (EventModel event : events) {
	        System.out.println(event.getEventId());
	    }
	    
        System.out.print("Enter event ID to delete: ");
        String eventId = add.next();
        
        System.out.print("Are you sure you want to cancel this event? (Y/N)");
        String answer = add.next();
        if(answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') {
            boolean found = false;
            for (int i = 0; i < events.size(); i++) {
                if (events.get(i).getEventId().equalsIgnoreCase(eventId)) {
                	System.out.println("Event deleted successfully.");
                    events.remove(i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Event not found.");
            }
        } else if(answer.charAt(0) == 'n' || answer.charAt(0) == 'N') {
			System.out.println("Event was not cancelled...\n");
			return;
        } else {
			System.out.println("invalid input!");
			return;
        }

	}

	@Override
	public void updateEvent() {
	    String id;
	    int opt;
	    boolean done = false;
	    System.out.println();
	    System.out.println("============== Update Event ==============");
	    
	    System.out.println("----Current Event IDs----");
	    for (EventModel event : events) {
	        System.out.println(event.getEventId());
	    }
	    
	    System.out.print("Enter event Id to update: ");
	    @SuppressWarnings("resource")
	    Scanner add = new Scanner(System.in);
	    id = add.next();

	    for (int x = 0; x < events.size(); x++) {
	        if (events.get(x).getEventId().equalsIgnoreCase(id)) {
	            while (true) {
	                System.out.println();
	                System.out.println("Select an option to update: ");
	                System.out.println("1 - Update Event Name");
	                System.out.println("2 - Update Event Type");
	                System.out.println("3 - Update Event Date (DD/MM/YY)");
	                System.out.println("4 - Update Event Location");
	                System.out.println("5 - Update Event Duration");
	                System.out.println("6 - Exit");
	                opt = add.nextInt();
	                add.nextLine();
	                
	                if (opt == 1) {
	                    System.out.print("Enter Event name: ");
	                    id = add.nextLine();
	                    if (id.equals("")) {
	                        System.out.println("Name cannot be empty");
	                    } 
	                    else {
	                        events.get(x).setEventName(id);
	                        System.out.println("=== Event Name Updated Successfully ===");
	                        break;
	                    }
	                } else if (opt == 2) {
	                    System.out.print("--All Events Categories--\n");
	                    this.displayAllEventCategories();
	                    System.out.print("Enter Event Type: ");
	                    id = add.nextLine();
	                    if (id.equals("")) {
	                        System.out.println("Event Type cannot be empty");
	                    } 
	                    else {
	                        events.get(x).setEventType(id);
	                        System.out.println("=== Event Type Updated Successfully ===");
	                        break;
	                    }
	                    
	                } else if (opt == 3) {
	                    System.out.print("Enter event date(DD/MM/YYY): ");
	                    id = add.nextLine();
	                    if (id.equals("")) {
	                        System.out.println("Date cannot be empty");
	                    } 
	                    else {
	                        events.get(x).setEventDate(id);
	                        System.out.println("=== Event Date Updated Successfully ===");
	                        break;
	                    } 
	                } else if (opt == 4) {
	                    System.out.print("Enter event Location: ");
	                    id = add.nextLine();
	                    if (id.equals("")) {
	                        System.out.println("Location cannot be empty");
	                    } 
	                    else {
	                        events.get(x).setEventLocation(id);
	                        System.out.println("=== Event Location Updated Successfully ===");
	                        break;
	                    }
	                } else if (opt == 5) {
	                    System.out.print("Enter event Duration: ");
	                    id = add.nextLine();
	                    if (id.equals("")) {
	                        System.out.println("Duration cannot be empty");
	                    } 
	                    else {
	                        events.get(x).setEventDuration(id);
	                        System.out.println("=== Event Duration Updated Successfully ===");
	                        break;
	                    }
	                } else if (opt == 6) {
	    	            System.out.println("Exit..");
	    	            done = true;
	    	            break;
	                }
	            }
	            System.out.println("Exit..");
	            done = true;
	            break;
	        }
	    }
	    if (!done) {
	        System.out.println("Event Not Found");
	    }
	}
	
	public void displayAllEventCategories() {
		System.out.println("\t(1)- Opening Event");
		System.out.println("\t(2)- Launching Event");
		System.out.println("\t(3)- LAN Party");	
	}

}
