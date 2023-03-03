package com.meetingroom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Calendar {
    private List<Slot> slots;
    public boolean isAvailable(Slot slot) {
        return slots.stream()
                .allMatch(slott -> slott.checkNonOverlappingSlot(slot));
    }

    public Calendar() {
        this.slots = new ArrayList<>();
    }

    public void bookASlot(Slot slot) {
        slots.add(slot);
    }
}
