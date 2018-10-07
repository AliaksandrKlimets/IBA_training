package com.training.iba.entity.event;

import com.training.iba.entity.Artist;
import com.training.iba.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class Event {
    protected boolean isAvailable = true;
    protected String eventInfo;
    protected Date date;
    protected List<User> listOfParticipants;
    protected List<Artist> listOfArtists;
    protected String place;
    protected double cost;

    public Event(String eventInfo, Date date, List<User> listOfParticipants, List<Artist> listOfArtists, String place, double cost) {
        this.eventInfo = eventInfo;
        this.date = date;
        this.listOfParticipants = listOfParticipants;
        this.listOfArtists = listOfArtists;
        this.place = place;
        this.cost = cost;
    }

    public Event() {
        listOfParticipants = new ArrayList<>();
        listOfArtists = new ArrayList<>();
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<User> getListOfParticipants() {
        return listOfParticipants;
    }

    public void setListOfParticipants(List<User> listOfParticipants) {
        this.listOfParticipants = listOfParticipants;
    }

    public List<Artist> getListOfArtists() {
        return listOfArtists;
    }

    public void setListOfArtists(List<Artist> listOfArtists) {
        this.listOfArtists = listOfArtists;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void addParticipant(User participant) throws CanNotAddParticipantException {
        if (participant.getRole() == User.Role.ADMIN || !isAvailable) {
            throw new CanNotAddParticipantException("Cannot add participant to participant list");
        }
        listOfParticipants.add(participant);
    }

    @Override
    public int hashCode() {
        return (int) cost * 31 +
                place.hashCode() +
                date.hashCode() +
                eventInfo.hashCode() +
                listOfParticipants.hashCode() +
                listOfArtists.hashCode();
    }

    @Override
    public String toString() {
        return "Event[" +
                "isAvailable=" + isAvailable +
                ", eventInfo='" + eventInfo +
                ", date=" + date +
                ", listOfParticipants= " + listOfParticipants +
                ", listOfArtists= " + listOfArtists +
                ", place= " + place +
                ", cost=" + cost + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return isAvailable == event.isAvailable &&
                Double.compare(event.cost, cost) == 0 &&
                Objects.equals(eventInfo, event.eventInfo) &&
                Objects.equals(date, event.date) &&
                Objects.equals(listOfParticipants, event.listOfParticipants) &&
                Objects.equals(listOfArtists, event.listOfArtists) &&
                Objects.equals(place, event.place);
    }
}
