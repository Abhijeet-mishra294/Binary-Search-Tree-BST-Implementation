# Binary Search Tree (BST) Implementation in Java

A robust, modular implementation of a Binary Search Tree (BST) data structure in Java from scratch. This project demonstrates core data structure concepts including recursive node manipulation, tree traversal algorithms, and memory management.

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Time Complexity](#time-complexity)
- [Project Structure](#project-structure)

## 📖 Overview
This project provides a raw implementation of a Binary Search Tree without relying on Java's built-in collection framework (like `TreeMap` or `TreeSet`). It serves as an educational tool to understand how hierarchical data structures function under the hood.

A **Binary Search Tree** is a node-based binary tree data structure which has the following properties:
- The left subtree of a node contains only nodes with keys lesser than the node’s key.
- The right subtree of a node contains only nodes with keys greater than the node’s key.
- The left and right subtree each must also be a binary search tree.

## ✨ Features
This implementation includes the following core functionalities:

1.  **Insertion**: Recursively places new nodes in the correct position to maintain BST properties.
2.  **Deletion**: Handles three specific cases:
    - Deleting a leaf node.
    - Deleting a node with one child.
    - Deleting a node with two children (using In-Order Successor).
3.  **Search**: Efficiently searches for a value in $O(\log n)$ time (average).
4.  **Traversals**:
    - **In-Order**: Visits nodes in ascending sorted order (Left, Root, Right).
    - **Pre-Order**: Useful for deep copies of the tree (Root, Left, Right).
    - **Post-Order**: Useful for deleting the tree (Left, Right, Root).

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher.

### Installation
1. Clone the repository:
   
   ```bash
   git clone [https://github.com/your-username/BST-Implementation.git](https://github.com/your-username/BST-Implementation.git)

3. Navigate to the project directory:

       cd BST-Implementation

## 💻 Usage 

compiling
Compile the Java files using javac:   

    javac BSTImplementation.java

Running
Run the main class:

       java BSTImplementation

Example Output

       Inserting: 50, 30, 20, 40, 70, 60, 80
      ---------------------------
      In-Order:   20 30 40 50 60 70 80 
      Pre-Order:  50 30 20 40 70 60 80 
      Post-Order: 20 40 30 60 80 70 50 
      ---------------------------
      Searching for 40: Found
      ...

##  📊 Time Complexity

       Operation    Average Case    Worst Case (Skewed Tree)
       Search         O(logn)            O(n)
       Insert         O(logn)            O(n)
       Delete         O(logn)            O(n)
       Traversal      O(n)               O(n)

Note: The worst case occurs when the tree becomes a skewed line (e.g., inserting sorted data 1, 2, 3, 4, 5).       

##   📂 Project Structure

      BST-Implementation/
      ├── src/
      │   ├── TreeNode.java           # The Node object definition
      │   ├── BinarySearchTree.java   # Logic for Insert, Delete, Search, Traversals
      │   └── BSTImplementation.java  # Main driver class for testing
      └── README.md

### Author: [Abhijeet Mishra]
