package com.example.android.inclassassignment08_rocioc;

/**
 * Created by ccteuser on 3/27/17.
 */

public class Family {

    private String lastName;
    private int numberOfMembers;
    private boolean comingToTheParty;

    public Family(String lastName, int numberOfMembers, boolean comingToTheParty) {
        this.lastName = lastName;
        this.numberOfMembers = numberOfMembers;
        this.comingToTheParty = comingToTheParty;
    }

    public Family() {

    }

    public String getLastName() {
        return lastName;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public boolean isComingToTheParty() {
        return comingToTheParty;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public void setComingToTheParty(boolean comingToTheParty) {
        this.comingToTheParty = comingToTheParty;
    }

    @Override
    public String toString() {
        return "Family: " + lastName +
                "\nNumber of Members: " + numberOfMembers +
                "\nComing to the party? " + comingToTheParty + "\n";
    }
}
