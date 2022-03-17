package fr.emse.ai.search.mid;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class ProfessorLaytonProblem implements Problem {

    SimpleState initialState = new SimpleState(3,0,3,0, true);
    SimpleState finalState = new SimpleState(0,3,0,3, false);

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
        int cannibalRight = ((SimpleState)state).cannibalRight;
        int missionariesLeft = ((SimpleState)state).missionariesLeft;
        int missionariesRight = ((SimpleState)state).missionariesRight;
        boolean boatOnLeftSide = ((SimpleState)state).boatOnLeftSide;

        if(boatOnLeftSide){
            if(cannibalLeft>=2){
                actions.add("take 2 cannibals Left to Right");
                actions.add("take 1 cannibals Left to Right");
                if(missionariesLeft>=1){
                    actions.add("take 1 each Left to Right");
                }
            }

            if(missionariesLeft >=2){
                actions.add("take 2 missionaries Left to Right");
                actions.add("take 1 missionaries Left to Right");
            }
        } else {
            if(cannibalRight>=2){
                actions.add("take 2 cannibals Right to Left");
                actions.add("take 1 cannibals Right to Left");
                if(missionariesRight>=1){
                    actions.add("take 1 each Right to Left");
                }
            }

            if(missionariesRight >=2){
                actions.add("take 2 missionaries Right to Left");
                actions.add("take 1 missionaries Right to Left");
            }
        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        int cannibalLeft = ((SimpleState)state).cannibalLeft;
        int cannibalRight = ((SimpleState)state).cannibalRight;
        int missionariesLeft = ((SimpleState)state).missionariesLeft;
        int missionariesRight = ((SimpleState)state).missionariesRight;
        boolean boatOnLeftSide = ((SimpleState)state).boatOnLeftSide;
        if (action.equals("take 2 cannibals Left to Right")) return new SimpleState(cannibalLeft-2, cannibalRight+2, missionariesLeft, missionariesRight, !boatOnLeftSide);
        if (action.equals("take 1 cannibals Left to Right")) return new SimpleState(cannibalLeft-1, cannibalRight+1, missionariesLeft, missionariesRight, !boatOnLeftSide);
        if (action.equals("take 1 each Left to Right")) return new SimpleState(cannibalLeft-1, cannibalRight+1, missionariesLeft-1, missionariesRight+1, !boatOnLeftSide);
        if (action.equals("take 2 missionaries Left to Right") && (cannibalLeft<missionariesLeft-2)) return new SimpleState(cannibalLeft, cannibalRight, missionariesLeft-2, missionariesRight+2, !boatOnLeftSide);
        if (action.equals("take 1 missionaries Left to Right") && (cannibalLeft<missionariesLeft-1)) return new SimpleState(cannibalLeft, cannibalRight, missionariesLeft-1, missionariesRight+1, !boatOnLeftSide);
        if (action.equals("take 2 cannibals Right to Left")) return new SimpleState(cannibalLeft+2, cannibalRight-2, missionariesLeft, missionariesRight, !boatOnLeftSide);
        if (action.equals("take 1 cannibals Right to Left")) return new SimpleState(cannibalLeft+1, cannibalRight-1, missionariesLeft, missionariesRight, !boatOnLeftSide);
        if (action.equals("take 1 each Right to Left")) return new SimpleState(cannibalLeft+1, cannibalRight-1, missionariesLeft+1, missionariesRight-1, !boatOnLeftSide);
        if (action.equals("take 2 missionaries Right to Left") && (cannibalRight<missionariesRight-2)) return new SimpleState(cannibalLeft, cannibalRight, missionariesLeft+2, missionariesRight-2, !boatOnLeftSide);
        if (action.equals("take 1 missionaries Right to Left") && (cannibalRight<missionariesRight-1)) return new SimpleState(cannibalLeft, cannibalRight, missionariesLeft+1, missionariesRight-1, !boatOnLeftSide);
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
