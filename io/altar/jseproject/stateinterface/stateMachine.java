package io.altar.jseproject.stateinterface;


public class stateMachine { 
    private static StateMenu[] states = {new stateMainMenu(), new stateMenuProducts(), new stateMenuShelfs()};
//    private int[][] transition = {{1, 2, 3}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
    private static int current = 0;
    
    public static void changeState(int nextState){
    	current = nextState;
    	states[current].on();
    }

    public static void on() {
    	current = 0;
    	states[current].on();
    }

    public static void off(){
        System.out.println("Good bye!");
    }
}
