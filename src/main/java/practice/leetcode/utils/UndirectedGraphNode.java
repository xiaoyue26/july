package practice.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyue26 on 17/12/26.
 */
public class UndirectedGraphNode {

    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }

    public UndirectedGraphNode(String str) {
        String[] strList = str.split("#");
        for (int i = 0; i < strList.length; i++) {
            String[] vals = strList[i].split(",");
            label = Integer.valueOf(vals[0]);
            break;
        }
    }

    public static void main(String[] args) {
        UndirectedGraphNode obj = new UndirectedGraphNode(1);
        UndirectedGraphNode obj2 = new UndirectedGraphNode("0,1,2#1,2#2,2");
        System.out.println("there");
    }
}
