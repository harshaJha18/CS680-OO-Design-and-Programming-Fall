package edu.umb.cs680.hw14;

class StateBearer {

    private State state;
    private static StateBearer instance;

    private StateBearer() {
        state = DrawerClosedNotPlaying.getInstance();
    }
    
    protected static StateBearer getInstance() {
        if (instance==null) {
            instance = new StateBearer();
        }
        return instance;
    }

    protected State getState() {
        return state;
    }

    protected void lightDisplay() {
        System.out.println(state.getDisplay());
    }

    protected void changeState(State newState) {
        state = newState;
    }
    
}
