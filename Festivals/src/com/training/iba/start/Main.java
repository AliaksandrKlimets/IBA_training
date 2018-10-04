package com.training.iba.start;

import com.training.iba.entity.PersonalInfo;
import com.training.iba.entity.User;
import com.training.iba.entity.event.CanNotAddParticipantException;
import com.training.iba.entity.event.Concert;

public class Main {

    public static void main(String[] args) {
        Concert concert = new Concert();
        try {
            concert.addParticipant(new User(User.Role.USER, "alex", "1751aaa",
                    new PersonalInfo(21, "Alex", "Klimets", "2276762")));
        }catch (CanNotAddParticipantException e){
            System.out.println(e.getMessage());
        }
    }
}
