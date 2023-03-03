package com.meetingroom;

import com.meetingroom.manager.MeetingManager;
import com.meetingroom.manager.RoomManager;
import com.meetingroom.model.Meeting;
import com.meetingroom.model.MeetingRoom;
import com.meetingroom.model.Slot;
import com.meetingroom.model.User;
import com.meetingroom.service.NotificationService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MeetingSchedular {

    public static void main(String[] args) {
        List<MeetingRoom> meetingRooms = IntStream.range(0, 3)
                .mapToObj(i -> new MeetingRoom())
                .collect(Collectors.toList());
        MeetingManager manager = new MeetingManager(new HashMap<>(), new RoomManager(meetingRooms), new NotificationService());

        User u1 = new User("Ram", "gmail.com");
        User u2 = new User("Shyam", "gmail.com");

        Meeting meeting = new Meeting(UUID.randomUUID().toString(), "Catchup", "NA", Arrays.asList(u1, u2),
                new Slot(1, 10), null);

        for (int i = 0; i < 4; i++) {
            Meeting meeting1 = manager.createMeeting(meeting);
            if (meeting1 != null) {
                System.out.println(meeting1.getRoom().getId());
            }
        }

    }
}
