package io.altar.jseproject.stateinterface;


public class FSM { //State machine
    private State[] states = {new stateMainMenu(), new stateMenuProducts(), new stateMenuShelfs()};
    private int[][] transition = {{1, 2, 3}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
    private int current = 0;

    private void next(int msg) {
        current = transition[current][msg];
    }

    public void menuProducts() {
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
