package fr.emse.ai.search.mid;

import java.util.ArrayList;
import java.util.Objects;

public class SimpleState {

    public int cannibalLeft;
    public int cannibalRight;
    public int missionariesLeft;
    public int missionariesRight;
    public boolean boatOnLeftSide;

    public SimpleState(int cannibalLeft, int cannibalRight, int missionariesLeft, int missionariesRight, boolean boatOnLeftSide) {
        this.cannibalLeft = cannibalLeft;
        this.cannibalRight = cannibalRight;
        this.missionariesLeft = missionariesLeft;
        this.missionariesRight = missionariesRight;
        this.boatOnLeftSide = boatOnLeftSide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleState that = (SimpleState) o;
        return cannibalLeft == that.cannibalLeft && cannibalRight == that.cannibalRight && missionariesLeft == that.missionariesLeft && missionariesRight == that.missionariesRight && boatOnLeftSide == that.boatOnLeftSide;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cannibalLeft, cannibalRight, missionariesLeft, missionariesRight, boatOnLeftSide);
    }

    @Override
    public String toString() {
        return "SimpleState{" +
                "cannibalLeft=" + cannibalLeft +
                ", cannibalRight=" + cannibalRight +
                ", missionariesLeft=" + missionariesLeft +
                ", missionariesRight=" + missionariesRight +
                ", boatOnLeftSide=" + boatOnLeftSide +
                '}';
    }
}
