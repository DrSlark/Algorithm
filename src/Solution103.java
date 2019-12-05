import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        ArrayList<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.push(root);
        boolean isReverse = false;
        while (!nodes.isEmpty()) {
            isReverse = !isReverse;

            LinkedList<Integer> localList = new LinkedList<>();

            for (TreeNode node : nodes) {
                if (isReverse) {
                    localList.addFirst(node.val);
                } else {
                    localList.add(node.val);
                }
            }
            ArrayList<TreeNode> nodesArray = new ArrayList<>();
            while (!nodes.isEmpty()) {
                nodesArray.add(nodes.pollFirst());
            }
            for (TreeNode node : nodesArray) {
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }


            if (!localList.isEmpty()) {
                list.add(localList);
            }
        }
        return list;
    }
}