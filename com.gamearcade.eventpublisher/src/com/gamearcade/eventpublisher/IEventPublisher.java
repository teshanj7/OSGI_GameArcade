package com.gamearcade.eventpublisher;

public interface IEventPublisher {
	public void selectOption(String consumer);
    public void addNewEvent();
    public void viewAllEvents();
    public void searchEventById();
    public void deleteEventById();
    public void updateEvent();
}
