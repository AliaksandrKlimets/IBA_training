package com.training.iba.entity.event;

import com.training.iba.entity.Artist;
import com.training.iba.entity.User;

import java.util.Date;
import java.util.List;

public class Festival extends Event {
    public Festival() {
    }

    public Festival(boolean isAvailable, String eventInfo, Date date,
                    List<User> listOfParticipants, List<Artist> listOfArtists, String place, double cost) {
        super(isAvailable, eventInfo, date, listOfParticipants, listOfArtists, place, cost);
    }
}