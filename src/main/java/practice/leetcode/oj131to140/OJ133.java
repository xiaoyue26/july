package practice.leetcode.oj131to140;

import practice.leetcode.utils.UndirectedGraphNode;

import java.util.*;

/**
 * Created by xiaoyue26 on 17/12/26.
 */
public class OJ133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> weHave = new HashMap<>();
        return cloneGraph(node, weHave);
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node
            , Map<UndirectedGraphNode, UndirectedGraphNode> weHave) {
        if(node==null){
            return null;
        }
        if (weHave.containsKey(node)) {
            return weHave.get(node);
        }
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        weHave.put(node,res);
        for (UndirectedGraphNode n : node.neighbors) {
            UndirectedGraphNode cn = cloneGraph(n, weHave);
            res.neighbors.add(cn);
        }
        return res;
    }

    public static void main(String[] args) {
        OJ133 obj = new OJ133();
        UndirectedGraphNode node = new UndirectedGraphNode(1);
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node.neighbors.add(node2);
        node0.neighbors.add(node);
        node0.neighbors.add(node2);
        node2.neighbors.add(node2);
        UndirectedGraphNode res = obj.cloneGraph(node);
        System.out.println("there");
        System.out.println(res);
    }
}
