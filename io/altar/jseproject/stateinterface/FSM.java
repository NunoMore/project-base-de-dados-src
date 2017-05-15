package io.altar.jseproject.stateinterface;

public class FSM { //finite state machine
    private State[] states = {new StateMainMenu(), new StateSubMenu()};
//    private int[][] transition = {{1, 2}, {1, 2, 3, 4}};
    private int current = 0;

    public void changeState(int nextState) {
        current = nextState;
        states[current].on();
    }
    
    public void on() {
    	current = 0;
    	states[current].on();
    }
}
