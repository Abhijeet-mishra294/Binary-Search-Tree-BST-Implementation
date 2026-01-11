// 1. Create a TreeNode class to represent nodes of the tree.
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// The main Binary Search Tree class
class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    // --- INSERTION ---
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive helper function to insert a new key in BST
    private TreeNode insertRec(TreeNode root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    // --- DELETION ---
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private TreeNode deleteRec(TreeNode root, int key) {
        // Base Case: If the tree is empty
        if (root == null) return root;

        // Otherwise, recur down the tree
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // --- SEARCH ---
    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(TreeNode root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null) return false;
        if (root.data == key) return true;

        // Key is smaller than root's data
        if (key < root.data)
            return searchRec(root.left, key);

        // Key is larger than root's data
        return searchRec(root.right, key);
    }

    // --- TRAVERSALS ---
    
    // In-Order Traversal (Left, Root, Right)
    public void inOrder() {
        System.out.print("In-Order:   ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    // Pre-Order Traversal (Root, Left, Right)
    public void preOrder() {
        System.out.print("Pre-Order:  ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Post-Order Traversal (Left, Right, Root)
    public void postOrder() {
        System.out.print("Post-Order: ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(TreeNode root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }
}

// Main class to run Task 3
public class BSTImplementation {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // 1. Insert nodes
        System.out.println("Inserting: 50, 30, 20, 40, 70, 60, 80");
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("---------------------------");

        // 2. Perform Traversals
        bst.inOrder();   // Expected: 20 30 40 50 60 70 80 (Sorted)
        bst.preOrder();  // Expected: 50 30 20 40 70 60 80
        bst.postOrder(); // Expected: 20 40 30 60 80 70 50

        System.out.println("---------------------------");

        // 3. Search for a node
        int searchKey = 40;
        System.out.println("Searching for " + searchKey + ": " + (bst.search(searchKey) ? "Found" : "Not Found"));
        
        System.out.println("---------------------------");

        // 4. Delete a node
        System.out.println("Deleting node 20 (Leaf node)...");
        bst.delete(20);
        bst.inOrder();

        System.out.println("Deleting node 30 (Node with one child)..."); // Actually has two children in this specific setup, let's delete 50 to test root deletion or 30
        bst.delete(30);
        bst.inOrder();

        System.out.println("Deleting node 50 (Root node with two children)...");
        bst.delete(50);
        bst.inOrder();
    }
}