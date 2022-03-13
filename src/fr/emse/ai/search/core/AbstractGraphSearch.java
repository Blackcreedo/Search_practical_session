package fr.emse.ai.search.core;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractGraphSearch {

    Collection<Node> frontier;

    public Node solve(Problem problem) {
        // initialize fringe
        System.out.println("Solving...");
        ArrayList<Object> visitedNodes = new ArrayList<Object>();
        frontier = initFrontier();
        frontier.addAll(expand(new Node(problem.getInitialState()), problem, visitedNodes));
        System.out.println("Starting frontier is " + frontier);
        boolean done = false;
        Node solution = null;
        while (!done) {
            if (frontier.isEmpty()) {
                System.out.println("No more nodes in frontier => FAILURE");
                done = true;
            } else {
                Node node = chooseLeafNode(frontier, problem);
                System.out.println("Inspecting node " + node);
                if (problem.isGoal(node.getState())) {
                    System.out.println("Goal node reached => SUCCESS");
                    solution = node;
                    done = true;
                } else {
                    frontier.addAll(expand(node, problem, visitedNodes));
                    System.out.printf("Expanding node, frontier is " + frontier);
                }
            }
        }
        return solution;
    }

    public Collection<Node> expand(Node node, Problem problem, ArrayList<Object> visitedNodes) {
        Collection<Node> nodes = new ArrayList<Node>();
        Collection<Object> actions = problem.getActions(node.getState());
        for (Object action : actions) {
            Object next = problem.getNextState(node.getState(), action);
            Node newNode = new Node(next, node, action, problem.getStepCost(node.getState(), action, next));
            if(!visitedNodes.contains(newNode.getState())){
                nodes.add(newNode);
                visitedNodes.add(newNode.getState());
            }
        }
        return nodes;
    }

    public abstract Collection<Node> initFrontier();

    public abstract Node chooseLeafNode(Collection<Node> frontier, Problem problem);
}
