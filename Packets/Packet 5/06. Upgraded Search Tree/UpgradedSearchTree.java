//Christopher Petty 

import java.util.*;
import java.io.*;

public class UpgradedSearchTree {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("tree.dat"));
		String[] data = input.nextLine().split(",");
		BinarySearchTree bst = new BinarySearchTree();

		for (String str : data) {
			int key = Integer.parseInt(str);
			bst.insert(bst.root, key);
		}

		// Order methods implemented in Node class
		System.out.println("[" + bst.preOrder().strip() + "]");
		System.out.println("[" + bst.inOrder().strip() + "]");
		System.out.println("[" + bst.postOrder().strip() + "]");
	}
}

//Binary Search Tree
class BinarySearchTree {
	Node root;

	Node insert(Node node, int key) {
		if (root == null) {
			root = new Node(key);
			return node;
		}
		if (node == null) {
			node = new Node(key);
			return node;
		}
		if (node.key == key) {
			node.num++;
			return node;
		}

		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);

		return node;
	}

	public String preOrder() {
		if (root == null)
			return "";
		return root.preOrder();
	}

	public String inOrder() {
		if (root == null)
			return "";
		return root.inOrder();
	}

	public String postOrder() {
		if (root == null)
			return "";
		return root.postOrder();
	}
}

class Node {
	int num, key;
	Node left, right;

	public Node(int item) {
		key = item;
		num = 1;
		left = right = null;
	}

	public String preOrder() {
		String output = "";
		if (num == 1)
			output += key + " ";
		else
			output += key + "(" + num + ") ";

		if (left != null)
			output += left.preOrder();

		if (right != null)
			output += right.preOrder();

		return output;
	}

	public String inOrder() {
		String output = "";

		if (left != null)
			output += left.inOrder();

		if (num == 1)
			output += key + " ";
		else
			output += key + "(" + num + ") ";

		if (right != null)
			output += right.inOrder();

		return output;
	}

	public String postOrder() {
		String output = "";

		if (left != null)
			output += left.postOrder();

		if (right != null)
			output += right.postOrder();

		if (num == 1)
			output += key + " ";
		else
			output += key + "(" + num + ") ";

		return output;
	}
}