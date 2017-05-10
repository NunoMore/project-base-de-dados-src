package io.altar.jseproject.stateinterface;


public class stateMachine { 
    private State[] states = {new stateMainMenu(), new stateMenuProducts(), new stateMenuShelfs()};
    private int[][] transition = {{1, 2, 3}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
    private int current = 0;
    
    public void changeState(int nextState){
    	current = nextState;
    	states[current].on();
    }

    public void on() {
    	current = 0;
    	states[current].on();
    }

    public void off(){
        System.out.println("Good bye!");
    }
}
