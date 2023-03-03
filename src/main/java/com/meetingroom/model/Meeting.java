package com.meetingroom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Meeting {
    private String id;
    private String subject;
    private String description;
    private List<User> guests;
    private Slot slot;
    private MeetingRoom room;


    // We can add method which will return template and sender list to notify
}
