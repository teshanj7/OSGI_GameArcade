package com.gamearcade.eventpublisher;

public class EventModel {
    private String eventId;
    private String eventName;
    private String eventType;
    private String eventDate;
    private String eventLocation;
    private String eventDuration;
    
    public EventModel() {
    	super();
    }

	public EventModel(String eventId, String eventName, String eventType, String eventDate, String eventLocation,
			String eventDuration) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.eventLocation = eventLocation;
		this.eventDuration = eventDuration;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(String eventDuration) {
		this.eventDuration = eventDuration;
	}

	@Override
	public String toString() {
		return "eventId=" + eventId + "\neventName=" + eventName + "\neventType=" + eventType
				+ "\neventDate=" + eventDate + "\neventLocation=" + eventLocation + "\neventDuration=" + eventDuration;
	}
}
