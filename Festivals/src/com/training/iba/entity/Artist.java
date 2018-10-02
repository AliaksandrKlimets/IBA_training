package com.training.iba.entity;

import java.util.Objects;

public class Artist {
    private String kindOfArtist;
    private PersonalInfo info;

    public Artist(String kindOfArtist, PersonalInfo info) {
        this.kindOfArtist = kindOfArtist;
        this.info = info;
    }

    public Artist(){}

    public PersonalInfo getInfo() {
        return info;
    }

    public void setInfo(PersonalInfo info) {
        this.info = info;
    }

    public String getKindOfArtist() {
        return kindOfArtist;
    }

    public void setKindOfArtist(String kindOfArtist) {
        this.kindOfArtist = kindOfArtist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(info, artist.info) &&
                Objects.equals(kindOfArtist, artist.kindOfArtist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, kindOfArtist);
    }

    @Override
    public String toString() {
        return "Artist[" +
                "info= " + info +
                ", kindOfArtist= " + kindOfArtist +"]";
    }
}
