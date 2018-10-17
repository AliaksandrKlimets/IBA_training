package com.training.iba.entity;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalInfo {

    private int age;
    private String name;
    private String surname;
    private String phoneNumber;

    public PersonalInfo(int age, String name, String surname, String phoneNumber) {
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }
    public PersonalInfo(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException{
        if(!Pattern.compile("[A-ZА-Я][a-zа-я]{2,20}").matcher(name).
                matches()) throw new IllegalArgumentException("Name is invalid");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(!Pattern.compile("[A-ZА-Я][a-zа-я]{2,20}").matcher(name).
                matches()) throw new IllegalArgumentException("Surname is invalid");
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(!Pattern.compile("(90 | \\+375)(29|33|44|25)\\d{7}").matcher(name).
                matches()) throw new IllegalArgumentException("Phone is invalid");
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalInfo that = (PersonalInfo) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return age*31+name.hashCode()+surname.hashCode()+phoneNumber.hashCode();
    }

    @Override
    public String toString() {
        return "PersonalInfo[" +
                "age = " + age +
                ", name = " + name +
                ", surname = " + surname +
                ", phoneNumber = " + phoneNumber +"]";
    }
}
