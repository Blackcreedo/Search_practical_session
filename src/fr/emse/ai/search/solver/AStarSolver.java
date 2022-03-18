package fr.emse.ai.search.solver;

import fr.emse.ai.search.core.AbstractTreeSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class AStarSolver extends AbstractTreeSearch {
    @Override
    public Collection<Node> initFrontier() {
        return new LinkedList<Node>();
    }

    @Override
    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        ArrayList<Integer> cost = new ArrayList<Integer>();
        for(Node node : frontier){
           cost.add(problem.heuristique(node));
        }
        System.out.println(cost);
        int minIndex = cost.indexOf(Collections.min(cost));
        Node node = (Node)frontier.toArray()[minIndex];
        frontier.remove(node);
        return node;
    }
}
