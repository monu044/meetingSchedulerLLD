package com.meetingroom.manager;

import com.meetingroom.model.Meeting;
import com.meetingroom.model.MeetingRoom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class RoomManager {
    private List<MeetingRoom> meetingRooms;

    private void addRooms(List<MeetingRoom> meetingRooms) {
        this.meetingRooms.addAll(meetingRooms);
    }

    private void addRoom(MeetingRoom meetingRoom) {
        this.meetingRooms.add(meetingRoom);
    }

    public List<MeetingRoom> getMeetingRooms() {
        return this.meetingRooms;
    }

}
