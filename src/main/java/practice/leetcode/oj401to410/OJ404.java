package practice.leetcode.oj401to410;

import practice.leetcode.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiaoyue26
 */
public class OJ404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left[] = dfs(root.left);
        int right[] = dfs(root.right);
        int sum = 0;
        sum += left[1];

        if (right[0] > 0) {
            sum += right[1];

        }
        return sum;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        if (root.left == null && root.right == null) {
            return new int[]{-1, root.val};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int sum = 0;
        sum += left[1];
        if (right[0] > 0) {
            sum += right[1];

        }


        return new int[]{1, sum};
    }

    public int sumOfLeftLeaves_other_dfs(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) ans += root.left.val;
            else ans += sumOfLeftLeaves(root.left);
        }
        ans += sumOfLeftLeaves(root.right);

        return ans;
    }

    public int sumOfLeftLeaves_other_stack(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    stack.push(node.left);
            }
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        OJ404 obj = new OJ404();
        TreeNode root = new TreeNode("3,9,20,#,#,15,7");
        System.out.println(obj.sumOfLeftLeaves(root));
        System.out.println(obj.sumOfLeftLeaves(new TreeNode(1)));
        root = new TreeNode("3,4,5,-7,-6,#,#,-7,#,-5,#,#,#,-4");
        System.out.println(obj.sumOfLeftLeaves(root));
    }
}
