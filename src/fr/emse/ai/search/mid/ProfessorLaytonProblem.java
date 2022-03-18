package fr.emse.ai.search.mid;

import fr.emse.ai.search.core.Node;
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

    public int heuristique(Node node){
        SimpleState state = (SimpleState) node.getState();
        return (3- state.missionariesRight)+(3- state.cannibalRight);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<Object>();
        int cannibalLeft = ((SimpleState)state).cannibalLeft;
        int cannibalRight = ((SimpleState)state).cannibalRight;
        int missionariesLeft = ((SimpleState)state).missionariesLeft;
        int missionariesRight = ((SimpleState)state).missionariesRight;
        boolean boatOnLeftSide = ((SimpleState)state).boatOnLeftSide;
/*
        System.out.print(cannibalLeft);
        System.out.print("__");
        System.out.print(missionariesLeft);
        System.out.print("__");
        System.out.print(cannibalRight);
        System.out.print("__");
        System.out.print(missionariesRight);
        System.out.print("__");
        System.out.println(boatOnLeftSide);
*/
        if(boatOnLeftSide){
            if(cannibalLeft >= 2 && (cannibalRight+2<=missionariesRight || missionariesRight==0) && (cannibalLeft-2<=missionariesLeft || missionariesLeft==0)) {actions.add("take 2 cannibals Left to Right");}
            if(cannibalLeft >= 1 && (cannibalRight+1<=missionariesRight || missionariesRight==0) && (cannibalLeft-1<=missionariesLeft || missionariesLeft==0)) {actions.add("take 1 cannibals Left to Right");}
            if(missionariesLeft >= 2 && (cannibalRight<=missionariesRight+2) && (cannibalLeft<=missionariesLeft-2 || missionariesLeft == 2)) {actions.add("take 2 missionaries Left to Right");}
            if(missionariesLeft >= 1 && (cannibalRight<=missionariesRight+1) && (cannibalLeft<=missionariesLeft-1 || missionariesLeft == 1)) {actions.add("take 1 missionaries Left to Right");}
            if(cannibalLeft >=1 && missionariesLeft>=1 && (cannibalRight<=missionariesRight)) {actions.add("take 1 each Left to Right");}
        } else {
            if(cannibalRight >= 2 && (cannibalLeft+2<=missionariesLeft || missionariesLeft==0) && (cannibalRight-2<=missionariesRight || missionariesRight==0)) {actions.add("take 2 cannibals Right to Left");}
            if(cannibalRight >= 1 && (cannibalLeft+1<=missionariesLeft || missionariesLeft==0) && (cannibalRight-1<=missionariesRight || missionariesRight==0)) {actions.add("take 1 cannibals Right to Left");}
            if(missionariesRight >= 2 && (cannibalLeft<=missionariesLeft+2) && (cannibalRight<=missionariesRight-2 || missionariesRight == 2)) {actions.add("take 2 missionaries Right to Left");}
            if(missionariesRight >= 1 && (cannibalLeft<=missionariesLeft+1) && (cannibalRight<=missionariesRight-1 || missionariesRight == 1)) {actions.add("take 1 missionaries Right to Left");}
            if(cannibalRight >=1 && missionariesRight>=1 && (cannibalLeft<=missionariesLeft)) {actions.add("take 1 each Right to Left");}
        }
        //System.out.println(actions);
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
        if (action.equals("take 2 missionaries Left to Right")) return new SimpleState(cannibalLeft, cannibalRight, missionariesLeft-2, missionariesRight+2, !boatOnLeftSide);
        if (action.equals("take 1 missionaries Left to Right")) return new SimpleState(cannibalLeft, cannibalRight, missionariesLeft-1, missionariesRight+1, !boatOnLeftSide);
        if (action.equals("take 2 cannibals Right to Left")) return new SimpleState(cannibalLeft+2, cannibalRight-2, missionariesLeft, missionariesRight, !boatOnLeftSide);
        if (action.equals("take 1 cannibals Right to Left")) return new SimpleState(cannibalLeft+1, cannibalRight-1, missionariesLeft, missionariesRight, !boatOnLeftSide);
        if (action.equals("take 1 each Right to Left")) return new SimpleState(cannibalLeft+1, cannibalRight-1, missionariesLeft+1, missionariesRight-1, !boatOnLeftSide);
        if (action.equals("take 2 missionaries Right to Left")) return new SimpleState(cannibalLeft, cannibalRight, missionariesLeft+2, missionariesRight-2, !boatOnLeftSide);
        if (action.equals("take 1 missionaries Right to Left")) return new SimpleState(cannibalLeft, cannibalRight, missionariesLeft+1, missionariesRight-1, !boatOnLeftSide);
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }

}
