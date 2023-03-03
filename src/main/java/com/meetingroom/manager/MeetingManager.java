package com.meetingroom.manager;

import com.meetingroom.model.Meeting;
import com.meetingroom.model.MeetingRoom;
import com.meetingroom.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;
import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor
public class MeetingManager {
    private Map<String, Meeting> meetingMap;
    private RoomManager roomManager;
    private NotificationService notificationService;

    public Meeting createMeeting(Meeting meeting) {
        Optional<MeetingRoom> optionalMeetingRoom = roomManager.getMeetingRooms().stream()
                .filter(room -> room.checkAvailability(meeting.getSlot()))
                .findAny();
        if (optionalMeetingRoom.isPresent()) {
            meetingMap.put(meeting.getId(), meeting);
            optionalMeetingRoom.get().bookAMeeting(meeting);
            notificationService.sendNotification(meeting.getGuests());
            return meeting;
        }
        else {
            System.out.println("No room available");
            return null;
        }
    }
}
