package com.training.iba.entity.event;

public class CanNotAddParticipantException extends Exception {

    CanNotAddParticipantException(String message){
        super(message);
    }
}
