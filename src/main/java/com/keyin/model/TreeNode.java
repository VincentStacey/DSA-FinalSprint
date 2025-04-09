package com.keyin.model;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public void insert(int val) {
        if (val < this.value) {
            if (this.left == null) this.left = new TreeNode(val);
            else this.left.insert(val);
        } else {
            if (this.right == null) this.right = new TreeNode(val);
            else this.right.insert(val);
        }
    }

    // Getters and Setters
    public int getValue() { return value; }
    public TreeNode getLeft() { return left; }
    public TreeNode getRight() { return right; }
}
