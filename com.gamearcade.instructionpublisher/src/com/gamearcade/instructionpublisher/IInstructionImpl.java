package com.gamearcade.instructionpublisher;

import java.util.ArrayList;
import java.util.Scanner;

public class IInstructionImpl implements IInstruction {
	
	Scanner scn = new Scanner(System.in);
	 
	ArrayList<InstructionModel> instructionList;

	public IInstructionImpl() {
		super();
		instructionList = new ArrayList<InstructionModel>();
		
		InstructionModel IM1 = new InstructionModel("E001","Player Instruction","Test Player Instruction",1);
		InstructionModel IM2 = new InstructionModel("E002","Event Organizer Instruction","Test Event Organizer Instruction",2);
		InstructionModel IM3 = new InstructionModel("E003","Developer Instruction","Test Developer Instruction",1);
        
		instructionList.add(IM1);
		instructionList.add(IM2);
		instructionList.add(IM3);
	}

	@Override
	public void chooseAnOption(String consumer) {

		boolean run=true;
		do {
			if(consumer.equals("Admin")) {
				System.out.println("Select your choice(1-2) :");
				System.out.println("1 - View Instructions");
				System.out.println("2 - Exit");
				
			    int response = scn.nextInt();		
					switch(response) {
			
					case 1:
						this.displayInstructions();
						break;
					case 2:
						System.out.println("Exiting...Thank you!\n");
						run=false;
						break; 
					default:
						System.out.println("------------------------");
						System.out.println("    Invalid input");
						System.out.println("------------------------");
					}
			} else {
				// options for Admin
				System.out.println("Select your choice(1-5) :");
				System.out.println("1 - Add a Instruction");
				System.out.println("2 - View Instructions");
				System.out.println("3 - Update Instruction details ");
				System.out.println("4 - Delete Instruction details");
				System.out.println("5 - Exit");
				
			    int response = scn.nextInt();		
					switch(response) {
			
					case 1:
						this.addInstructions();
						break;
					case 2:
						this.displayInstructions();
						break;
					case 3:
						this.updateInstruction();
						break;
					case 4:
						this.deleteInstruction();
						break;
					case 5:
						System.out.println("Exiting...Thank you!\n");
						run=false;
						break; 
					default:
						System.out.println("------------------------");
						System.out.println("    Invalid input");
						System.out.println("------------------------");
					}
				
			}
			
		}while(run == true);
	}

	@Override
	public void addInstructions() {
		char loopContinue ;
		
		// Regex patterns for validation
        String idPattern = ".{4,}"; // ID should have at least 4 characters
        String insPattern = "^\\s*$"; // Instruction should not be empty (non-whitespace characters)
        String priorityPattern = "\\d+"; // Priority should be a number
		
		do {
			InstructionModel insMod = new InstructionModel();
			//selecting the instrument type
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Select the instruction type to add a new Instruction(1-4)");
			System.out.println("--------------------------------------------------------------------");
			
			//Displaying instrument types
			System.out.println("1 - Player Instruction");
			System.out.println("2 - Event Organizer Instruction");
			System.out.println("3 - Developer Instruction");
			System.out.println("4 - Other");
			
			int instruction = scn.nextInt();
			scn.nextLine();
			switch(instruction) {
		
				//switch cases to check and assign the instrument type
				case 1:
					insMod.setType("Player Instruction");
					break;
				case 2:
					insMod.setType("Event Organizer Instruction");
					break;
				case 3:
					insMod.setType("Developer Instruction");
					break;
				case 4:
					insMod.setType("Other");
					break; 
				default:
					System.out.println("Error: Invalid type Selection.");
			}
		if(instruction<=4 || instruction >=1) {
			
			//Getting the instruction details
			System.out.println("Enter Instruction ID (at least 4 characters): ");
	        String ID = scn.nextLine();
	        while (!ID.matches(idPattern)) {
	            System.out.println("Invalid ID. Please enter at least 4 characters.");
	            ID = scn.nextLine();
	        }
	        insMod.setID(ID);

	        System.out.println("Enter instruction (cannot be empty): ");
	        String ins = scn.nextLine();
	        while (ins.matches(insPattern)) {
	            System.out.println("Invalid instruction. Please enter a non-empty instruction.");
	            ins = scn.nextLine();
	        }
	        insMod.setInstruction(ins);

	        System.out.println("Enter Priority (a number): ");
	        String priorityStr = scn.nextLine();
	        while (!priorityStr.matches(priorityPattern)) {
	            System.out.println("Invalid priority. Please enter a number.");  
	            priorityStr = scn.nextLine(); // Prompt again for input
	        }
	        int priorityInt = Integer.parseInt(priorityStr); // Convert priority to an integer
	        insMod.setPriority(priorityInt);
		}
		
		try {
			instructionList.add(insMod);
			System.out.println("------All the instructions are successfully added to the system!---------");
		}
		catch(Exception e){
			e.printStackTrace();		
		}
		System.out.println("\n Do you have another Instruction to add (Y/N) ?");
		String response = scn.next();
		
		//condition to stop the loop
		if(response.charAt(0)=='n'||response.charAt(0)=='N')
			break;
		loopContinue = response.charAt(0);
		}while(loopContinue=='Y'||loopContinue=='y');
		System.out.println("Thank you! \n\n");
		
	}

	@Override
	public void displayInstructions() {
		System.out.println("---------------------------------------------------------");
		System.out.println("****Retrieving all the Instruction details****");
		System.out.println("---------------------------------------------------------");
		for(InstructionModel insMod:instructionList) {
			this.displayInstructionDetails(insMod);
		}
		
	}
	
	public void displayInstructionDetails(InstructionModel inst) {
		
		System.out.println("");
		System.out.println("Instruction ID : "+inst.getID());
		System.out.println("Instruction Type : "+inst.getType());
		System.out.println("Instruction : "+inst.getInstruction());
		System.out.println("Priority : "+inst.getPriority());
		System.out.println("-------------------------------");
		
	}

	@Override
	public void updateInstruction() {
		
		char loopContinue ;
		
		System.out.println("\n\n----------------------------------------------------------------------------------------------------------------");	
		System.out.println("******Given Below are all the Instructions which was added to the Game Arcade which can be updated******");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		
		for(InstructionModel insMod:instructionList) {
			this.displayInstructionDetails(insMod);
		}
		do {
		System.out.println("Enter the ID of the instruction that you want to update");
		String updateID=scn.next();
		
		System.out.println("Enter the section number you want to update(1-3)");
		//System.out.println("1 - Instruction ID"); Requirement -: Cannot be Updated
		System.out.println("1 - Instruction Type");
		System.out.println("2 - Instruction");
		System.out.println("3 - Priority");
	
		int updateSection = scn.nextInt();
		scn.nextLine();
		
		for(InstructionModel insMod:instructionList) {
			
			//comparing model number
			if(insMod.getID().equals(updateID)) {			
				switch(updateSection) {
		
//				case 1:
//					System.out.println("Enter new instruction ID");
//					insMod.setID(scn.nextLine());
//					break;	
				
				case 1:
					System.out.println("Enter new instruction type. Below are the Instruction types,\n");
					System.out.println("Player Instruction");
					System.out.println("Event Organizer Instruction");
					System.out.println("Developer Instruction");
					System.out.println("Other \n");
					insMod.setType(scn.nextLine());
					break;
				case 2:
					System.out.println("Enter new Instruction.");
					insMod.setInstruction(scn.nextLine());
					break;
				case 3:
					System.out.println("Enter Priority");
					int priorityInt = Integer.parseInt(scn.nextLine()); // Convert priority to an integer
			        insMod.setPriority(priorityInt);
					break; 
				default:
					System.out.println("Error: Invalid Menu Selection.");
				}
			}
		}
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("----  Given below are all the instructions after udpdate   -----");
		System.out.println("---------------------------------------------------------------------------");
		for(InstructionModel insMod:instructionList) {
		this.displayInstructionDetails(insMod);
		}
		System.out.println("\n Do you have another Instruction to update (Y/N) ?");
		String response = scn.next();
		
		if(response.charAt(0)=='n'||response.charAt(0)=='N')
			break;
		loopContinue = response.charAt(0);
		}while(loopContinue=='Y'||loopContinue=='y');
		System.out.println("Thank you!");
		
	}

	@Override
	public void deleteInstruction() {
		
		char loopContinue ;
		
		System.out.println("\n\n----------------------------------------------------------------------------------");
		System.out.println("******Given below are all the Instructions which you can delete******");
		System.out.println("----------------------------------------------------------------------------------");
		
		for(InstructionModel insMod:instructionList) {
			this.displayInstructionDetails(insMod);
		}
		
		do {
		System.out.println("Enter the ID of the instructiont you want to remove");
		String remvIns=scn.next();
		int itemId =0;
		
		for(InstructionModel insMod:instructionList) {
			itemId++;
			
			//condition to compare model number
			if(insMod.getID().equals(remvIns)) {
				instructionList.remove(itemId-1);
				System.out.println("Instruction with ID: "+insMod.getID()+" removed successfully");
				break;
			}
		 }
		System.out.println("\n\n----------------------------------------------------------------");
		System.out.println("       Other instructions in the music store after deletion      ");
		System.out.println("-----------------------------------------------------------------");
		for(InstructionModel insMod:instructionList) {
			this.displayInstructionDetails(insMod);
		}
		 
		System.out.println("\n Do you have another musical instrument to delete (Y/N) ?");
		String response = scn.next();
		
		if(response.charAt(0)=='n'||response.charAt(0)=='N')
			break;
		loopContinue = response.charAt(0);
		}while(loopContinue=='Y'||loopContinue=='y');
		System.out.println("Thank you!");
		
	}
	
	

}
