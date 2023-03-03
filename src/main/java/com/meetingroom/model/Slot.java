package com.meetingroom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Slot {
    private Integer startTime;
    private Integer endTime;

    public boolean checkNonOverlappingSlot(Slot other) {
        if (other.startTime >= this.endTime) {
            return true;
        } else {
            return other.endTime <= this.startTime;
        }
    }
}
