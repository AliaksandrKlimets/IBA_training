package com.training.iba.entity.event;

import com.training.iba.entity.Artist;
import com.training.iba.entity.User;

import java.util.Date;
import java.util.List;

public class FoodFestival extends Event {
    public FoodFestival(String eventInfo, Date date,
                        List<User> listOfParticipants, List<Artist> listOfArtists, String place, double cost) {
        super(eventInfo, date, listOfParticipants, listOfArtists, place, cost);
    }

    public FoodFestival() {
    }


}
