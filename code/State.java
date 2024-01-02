/*
Description:
This code defines a State class that represents a state in the game.
It has instance variables position and state, which store the position
and state of the game board respectively. The class provides getters
and setters for accessing and modifying the state, and it also overrides
the toString() method to provide a string representation of the state object,
including its position and the state array.

Students:
- Ameera Attiah S21107316
- Leen Sharab S21107195
- Sarah Alshumayri S20106125
*/
package com.example.project;

import java.util.Arrays;

public class State {
    private int position;
    private String[] state;

    public State(int position, String[] state) {
        this.position = position;
        this.state = state;
    }

    public int getPosition() {
        return position;
    }

    public String[] getState() {
        return state;
    }

    public String getStateIndex(int i) {
        return state[i];
    }

    public void setState(String[] state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "State{" +
                "position=" + position +
                ", state=" + Arrays.toString(state) +
                '}';
    }
}
