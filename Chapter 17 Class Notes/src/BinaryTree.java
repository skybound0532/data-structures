/**
    A binary tree in which each node has two children.
*/
public class BinaryTree
{
    private Node root;

    /**
        Constructs an empty tree.
    */
    public BinaryTree()
    {
        this.root = null;
    } 

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public BinaryTree(Object rootData) 
    {
        this.root = new Node();
        this.root.data = rootData;
        this.root.left = null;
        this.root.right = null;
    }

    /**
        Constructs a binary tree.
        @param rootData the data for the root
        @param left the left subtree
        @param right the right subtree
    */
    public BinaryTree(Object rootData, BinaryTree left, BinaryTree right)
    {
        this(rootData);
        this.root.left = left.root;
        this.root.right = right.root;
    }
    
    static class Node
    {
        public Object data;
        public Node left;
        public Node right;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int leftSize = 0;
            int rightSize = 0;
            if (this.left != null) { leftSize = this.left.size(); }
            if (this.right != null) { rightSize = this.right.size(); }
            return 1 + leftSize + rightSize;
        }
    }

    /**
        Returns the height of the subtree whose root is the given node.
        @param n a node or null
        @return the height of the subtree, or 0 if n is null
    */
    private static int height(Node n)
    {
        if (n == null) { return 0; }
        else
        {
            return 1 + Math.max(BinaryTree.height(n.left), BinaryTree.height(n.right));
        }
    }

    /**
        Returns the height of this tree.
        @return the height
    */
    public int height()
    {
        return height(this.root);
    }

    /**
        Checks whether this tree is empty.
        @return true if this tree is empty
    */
    public boolean isEmpty()
    {
        return this.root == null;
    }

    /**
        Gets the data at the root of this tree.
        @return the root data
    */
    public Object data()
    {
        return this.root.data;
    }
    
    /**
        Gets the left subtree of this tree.
        @return the left child of the root
    */
    public BinaryTree left() 
    { 
        BinaryTree subtree = new BinaryTree();

        subtree.root = this.root.left;
        
        return subtree;
    }

    /**
        Gets the right subtree of this tree.
        @return the right child of the root
    */
    public BinaryTree right() 
    { 
        BinaryTree subtree = new BinaryTree();

        subtree.root = this.root.right;
        
        return subtree;
    }
}
