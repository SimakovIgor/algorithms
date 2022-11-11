package problems;

import java.util.HashMap;
import java.util.TreeSet;

public class Tree {


    /**
     * // Две вершины считаются эквивалентными, если поддеревья этих
     * // вершин содержат одинаковое множество (т.е. без учета частот) букв.
     * //Найти пару таких вершин
     * <p>
     * //       A
     * //     /   \
     * //   [C]    [B]
     * //   / \   / \
     * //   A D   A  D
     * //  /          \
     * // B            C
     *
     * @param head head
     * @return int
     */
    public static int[] findEqualSubTrees(TreeNode head) {
        HashMap<TreeNode, TreeSet<Character>> map = new HashMap<>();
        find(head, map);

        return new int[2];
    }

    public static void find(TreeNode head, HashMap<TreeNode, TreeSet<Character>> map) {
        if (head == null) return;

        if (head.left == null && head.right == null) {
            if (map.containsKey(head)) {
                map.get(head).add(head.val);
            } else {
                TreeSet<Character> characters = new TreeSet<>();
                characters.add(head.val);
                map.put(head, characters);
            }
            return;
        }

        find(head.left, map);
        find(head.right, map);
    }

//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) return 0;
//
//        if (root.left != null && root.left.left == null && root.left.right == null) {
//            return root.left.val + sumOfLeftLeaves(root.right);
//        }
//
//        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
//    }
}


class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(char val) {
        this.val = val;
    }

    TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


