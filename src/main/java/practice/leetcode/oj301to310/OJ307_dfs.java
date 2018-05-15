package practice.leetcode.oj301to310;

/**
 * Created by xiaoyue26 on 18/2/23.
 */
public class OJ307_dfs {
    static class NumArray {

        class SegmentTreeNode {
            int start, end;
            SegmentTreeNode left, right;
            int sum;

            public SegmentTreeNode(int start, int end) {
                this.start = start;
                this.end = end;
                this.left = null;
                this.right = null;
                this.sum = 0;
            }
        }

        SegmentTreeNode root = null;

        public NumArray(int[] nums) {
            root = buildTree(nums, 0, nums.length - 1);
        }

        private SegmentTreeNode buildTree(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            } else {
                SegmentTreeNode res = new SegmentTreeNode(start, end);
                if (start == end) {
                    res.sum = nums[start];
                } else {
                    int mid = start + (end - start) / 2;
                    res.left = buildTree(nums, start, mid);
                    res.right = buildTree(nums, mid + 1, end);

                    res.sum = 0;
                    if (res.left != null) {
                        res.sum += res.left.sum;
                    }
                    if (res.right != null) {
                        res.sum += res.right.sum;
                    }
                }
                return res;
            }
        }

        void update(int i, int val) {
            update(root, i, val);
        }

        void update(SegmentTreeNode root, int pos, int val) {
            if (root.start == root.end) {
                root.sum = val;
            } else {
                int mid = root.start + (root.end - root.start) / 2;
                if (pos <= mid) {
                    update(root.left, pos, val);
                } else {
                    update(root.right, pos, val);
                }
                root.sum = 0;
                if (root.left != null) {
                    root.sum += root.left.sum;
                }
                if (root.right != null) {
                    root.sum += root.right.sum;
                }
            }
        }

        public int sumRange(int i, int j) {
            return sumRange(root, i, j);
        }

        public int sumRange(SegmentTreeNode root, int start, int end) {
            if(root==null){
                return 0;
            }
            if (root.end == end && root.start == start) {
                return root.sum;
            } else {
                int mid = root.start + (root.end - root.start) / 2;
                if (end <= mid) {
                    return sumRange(root.left, start, end);
                } else if (start >= mid + 1) {
                    return sumRange(root.right, start, end);
                } else {
                    return sumRange(root.right, mid + 1, end) + sumRange(root.left, start, mid);
                }
            }
        }
    }

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{
                1, 3, 5
        });

        System.out.println(obj.sumRange(0, 2));// 9
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));// 8
    }
}
