package fr.emse.ai.search.simple;

import fr.emse.ai.search.mid.ProfessorLaytonProblem;
import fr.emse.ai.search.solver.BreadthFirstGraphSearch;
import fr.emse.ai.search.solver.BreadthFirstTreeSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;
import fr.emse.ai.search.solver.DepthFirstTreeSearch;

public class SimpleTest {

    public static void main(String[] args) {
        SimpleOrientedGraphProblem p1 = new SimpleOrientedGraphProblem();
        SimpleGraphProblem p2 = new SimpleGraphProblem();
        ProfessorLaytonProblem p3 = new ProfessorLaytonProblem();
        System.out.println("Solution to problem using depth first : ");
        //System.out.println(new DepthFirstTreeSearch().solve(p1).pathToString());
        //System.out.println(new BreadthFirstTreeSearch().solve(p1).pathToString());
        //System.out.println(new DepthFirstTreeSearch().solve(p2).pathToString()); //Infinite Loop
        //System.out.println(new BreadthFirstTreeSearch().solve(p2).pathToString());
        //System.out.println(new DepthFirstGraphSearch().solve(p2).pathToString());
        //System.out.println(new BreadthFirstGraphSearch().solve(p2).pathToString());
        System.out.println(new BreadthFirstGraphSearch().solve(p3).pathToString());
        System.out.println(new DepthFirstGraphSearch().solve(p3).pathToString());
    }
}
