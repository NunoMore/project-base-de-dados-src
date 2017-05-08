package io.altar.jseproject.stateinterface;


public class FSM { //main menu
    private State[] states = {new mainMenu(), new menuProducts(), new menuShelfs()};
    private int[][] transition = {{2,1,0}, {0,2,1}, {1,2,2}};
    private int current = 0;

    private void next(int msg) {
        current = transition[current][msg];
    }

    public void on() {
        states[current].on();
        next(0);
    }

    public void off() {
        states[current].off();
        next(1);
    }

    public void ack() {
        states[current].ack();
        next(2);
    }
}
