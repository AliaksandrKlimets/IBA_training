package com.training.iba.start;

import com.training.iba.entity.PersonalInfo;
import com.training.iba.entity.User;
import com.training.iba.entity.exception.CanNotAddParticipantException;
import com.training.iba.entity.event.Concert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Concert concert = new Concert();
        String[] userItems;
        try{
            List<String> lines = Files.readAllLines(Paths.get("src/users.txt"), StandardCharsets.UTF_8);
            for(String line: lines){
                userItems = line.split(",");
                concert.addParticipant(new User(User.Role.valueOf(userItems[0].toUpperCase()),
                        userItems[1], userItems[2],
                        new PersonalInfo(Integer.parseInt(userItems[3]), userItems[4],
                                userItems[5], userItems[6])));
            }
        } catch (CanNotAddParticipantException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (User user : concert.getListOfParticipants()) {
            System.out.println(user);
        }

    }
}
