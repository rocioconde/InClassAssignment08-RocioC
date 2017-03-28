package com.example.android.inclassassignment08_rocioc;

import java.io.Serializable;

/**
 * Created by ccteuser on 3/27/17.
 */

public class Family implements Serializable {

    private String lastName;
    private int numberOfMembers;
    private boolean comingToTheParty;

    public Family(String lastName, int numberOfMembers, boolean comingToTheParty) {
        this.lastName = lastName;
        this.numberOfMembers = numberOfMembers;
        this.comingToTheParty = comingToTheParty;
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

    @Override
    public String toString() {
        return "Family: " + lastName +
                "\nNumber of Members: " + numberOfMembers +
                "\nIs this family coming to the party? " + comingToTheParty;
    }
}
