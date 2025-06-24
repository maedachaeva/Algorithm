public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 왼쪽과 오른쪽 모두에서 p, q를 하나씩 찾았다는 뜻 → root가 공통 조상
        if (left != null && right != null) return root;
        // 왼쪽에만 있으면 왼쪽 리턴, 오른쪽에만 있으면 오른쪽 리턴 (재귀)
        return (left != null) ? left : right;
    }
}