package leetcode;//https://leetcode.com/problems/maximum-average-subtree/

class lc_MaximumAverageSubtree {

    double maxAvg = 0;

    public double maximumAverageSubtree(TreeNode root) {

        helper(root);

        return maxAvg;
    }

    public double[] helper(TreeNode node) {

        if(node == null) {

            return new double[]{0, 0};
        }

        double[] leftChild = helper(node.left);
        double[] rightChild = helper(node.right);

        double sum = leftChild[0] + rightChild[0] + node.val;
        double count = leftChild[1] + rightChild[1] + 1;
        double avg = sum / count;

        maxAvg = Math.max(maxAvg, avg);

        return new double[]{sum, count};
    }
}