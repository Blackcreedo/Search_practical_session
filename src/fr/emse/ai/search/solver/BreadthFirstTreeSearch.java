package fr.emse.ai.search.solver;

import fr.emse.ai.search.core.AbstractTreeSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.Collection;
import java.util.LinkedList;

public class BreadthFirstTreeSearch extends AbstractTreeSearch {
    @Override
    public Collection<Node> initFrontier() {
        return new LinkedList<Node>();
    }

    @Override
    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        return ((LinkedList<Node>) frontier).pop();
    }
}
