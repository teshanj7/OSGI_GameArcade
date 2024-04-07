package com.gamearcade.instructionpublisher;

public class InstructionModel {
	
	private String instruction,type,ID;
	private int priority;
	
	public InstructionModel() {
		
	}
	
	public InstructionModel(String ID, String type, String instruction, int priority) {
		
		this.ID = ID;
		this.instruction = instruction;
		this.type = type;
		this.priority = priority;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
}
