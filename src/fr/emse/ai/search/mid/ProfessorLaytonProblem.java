package fr.emse.ai.search.mid;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class ProfessorLaytonProblem implements Problem {

    SimpleState initialState = new SimpleState(3,3,0,0, true);
    SimpleState finalState = new SimpleState(0,0,3,3, false);

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        return state.equals(finalState);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<Object>();
        int cannibalLeft = ((SimpleState)state).cannibalLeft;
        int cannibalLeft = ((SimpleState)state).cannibalLeft;
        int cannibalLeft = ((SimpleState)state).cannibalLeft;
        int cannibalLeft = ((SimpleState)state).cannibalLeft;
        int cannibalLeft = ((SimpleState)state).cannibalLeft;

        return null;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
