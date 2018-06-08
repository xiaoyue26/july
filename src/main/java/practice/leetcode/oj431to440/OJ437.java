package practice.leetcode.oj431to440;

import practice.leetcode.utils.TreeNode;

/**
 * @author xiaoyue26
 */
public class OJ437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int[] count = new int[1];
        count[0] = 0;
        int sumStack[] = new int[1000];
        int top[] = new int[1];
        top[0] = 0;
        dfs(root, count, sum, sumStack, top);
        return count[0];
    }

    private void dfs(TreeNode root, int[] count
            , int sum, int[] sumStack, int[] top) {
        if (root == null) {
            return;
        }
        if (top[0] == 0) {
            sumStack[0] = root.val;
        } else {
            sumStack[top[0]] = sumStack[top[0] - 1] + root.val;
        }

        if (sum == sumStack[top[0]]) {
            count[0]++;
        }
        for (int i = 0; i < top[0]; i++) {
            if (sum == sumStack[top[0]] - sumStack[i]) {
                count[0]++;
            }
        }
        top[0]++;

        dfs(root.left, count, sum, sumStack, top);
        dfs(root.right, count, sum, sumStack, top);
        top[0]--;
    }

    public static void main(String[] args) {
        OJ437 obj = new OJ437();
        System.out.println(obj.pathSum(new TreeNode(
                "10,5,-3,3,2,#,11,3,-1,#,1"
        ), 8));
    }
}
