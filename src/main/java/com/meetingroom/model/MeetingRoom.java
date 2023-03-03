package com.meetingroom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class MeetingRoom {
    private Calendar calendar;
    private String id;
    private List<Meeting> meetings;
    private Integer capacity;

    public MeetingRoom() {
        this.id = UUID.randomUUID().toString();
        this.meetings = new ArrayList<>();
        this.calendar= new Calendar();
    }
    public boolean checkAvailability(Slot slot) {
        return calendar.isAvailable(slot);
    }

    public Meeting bookAMeeting(Meeting meeting) {
        meeting.setRoom(this);
        calendar.bookASlot(meeting.getSlot());
        meetings.add(meeting);
        return meeting;
    }
}
