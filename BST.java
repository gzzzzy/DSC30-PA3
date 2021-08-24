package DSC30.PA3;
/*
 * NAME: Zhiyu Gao
 * PID: A17245309
 */

public class BST {

    // instance variables, feel free to add your own

    public int nElems;
    public BSTNode root;

    protected class BSTNode {
        public BSTNode left;
        public BSTNode right;
        public int key;
        public String data;

        public BSTNode(BSTNode left, BSTNode right, int key, String data) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.data = data;
        }

        public BSTNode(BSTNode left, BSTNode right, int key) {
            this(left, right, key, null);
        }

        public BSTNode(int key, String data) {
            this(null, null, key, data);
        }

        public String getData() {
            return data;
        }

        public int getKey() {
            return key;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void setChild(BSTNode child, boolean isLeft) {
            if (isLeft) {
                left = child;
            } else {
                right = child;
            }
        }

        public void setChild(BSTNode child) {
            left = child;
        }

        public BSTNode getChild(boolean isLeft) {
            if (isLeft) {
                return left;
            } else {
                return right;
            }
        }

        public BSTNode getChild() {
            return left;
        }

        public void addData(String data) {
            this.data = data;
        }

        public boolean removeData(String data) {
            if (this.data.equals(data)) {
                this.data = null;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Default constructor to create a new BST tree
     *
     * @param root   root of BST tree
     * @param nElems number of nodes
     */
    public BST() {
        root = null;
        nElems = 0;
    }

    /**
     * Getting the root of a BST tree instance variable
     *
     * @return root root of the BST tree instance variable
     */
    public BSTNode getRoot() {
        return root;
    }

    /**
     * Getting the number of nodes
     *
     * @return nElems the number of nodes
     */
    public int size() {
        return nElems;
    }

    /**
     * Inserts a key into the BST, along with data associated with it.
     * 
     * @param key  the key to insert
     * @param data the data to insert
     * 
     * @return boolean {@code true} if the addition was successful, or {@code false}
     *         if the node with the specified key (but not data) already exists.
     */
    public boolean add(int key, String data) {
        if (root == null) {
            root = new BSTNode(null, null, key, data);
            ++nElems;
            return true;
        }
        if (findKey(key)) {
            return false;
        }
        BSTNode insertLocation = root, parNode = root;
        boolean isLeft = false;
        while (insertLocation != null) {
            parNode = insertLocation;
            if (insertLocation.getKey() < key) {
                insertLocation = insertLocation.right;
                isLeft = false;
            } else {
                insertLocation = insertLocation.left;
                isLeft = true;
            }
        }
        if (isLeft) {
            parNode.left = new BSTNode(null, null, key, data);
        } else {
            parNode.right = new BSTNode(null, null, key, data);
        }
        ++nElems;
        return true;
    }

    /**
     * Inserts a key into the BST, along with data associated with it.
     * 
     * @param key the key to insert
     * 
     * @return boolean {@code true} if the addition was successful, or {@code false}
     *         if the node with the specified key (but not data) already exists.
     */
    public boolean add(int key) {
        if (root == null) {
            root = new BSTNode(null, null, key);
            ++nElems;
            return true;
        }
        if (findKey(key)) {
            return false;
        }
        BSTNode insertLocation = root, parNode = root;
        boolean isLeft = false;
        while (insertLocation != null) {
            parNode = insertLocation;
            if (insertLocation.getKey() < key) {
                insertLocation = insertLocation.right;
                isLeft = false;
            } else {
                insertLocation = insertLocation.left;
                isLeft = true;
            }
        }
        if (isLeft) {
            parNode.left = new BSTNode(null, null, key);
        } else {
            parNode.right = new BSTNode(null, null, key);
        }
        ++nElems;
        return true;
    }

    /**
     * determine if the BST tree is empty
     * 
     * @return boolean {@code true} if BST tree is empty or {@code false} otherwise
     */
    public boolean isEmpty() {
        return nElems == 0;
    }

    /**
     * Checks if the tree contains a node under the specified key.
     * 
     * @return boolean, {@code true} if it does, {@code false} otherwise.
     */
    public boolean findKey(int key) {
        BSTNode currNode = root;
        while (currNode != null) {
            if (currNode.getKey() == key) {
                return true;
            } else if (currNode.getKey() < key) {
                currNode = currNode.right;
            } else {
                currNode = currNode.left;
            }
        }
        return false;
    }

    /**
     * Find the data of the node under the specified key.
     * 
     * @param key the key to find
     * 
     * @throws IllegalArgumentException if the node doesn’t exist
     * 
     * @return String the data of the node under the specified key.
     */
    public String getData(int key) {
        BSTNode currNode = root;
        while (currNode != null) {
            if (currNode.getKey() == key) {
                return currNode.getData();
            } else if (currNode.getKey() < key) {
                currNode = currNode.right;
            } else {
                currNode = currNode.left;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * Adds new data to the specified key’s node, overwriting existing data.
     * 
     * @param key  the key to find
     * @param data the data to add
     * 
     * @return boolean, {@code true} if the addition was successful, or
     *         {@code false} if the node doesn’t exist.
     */
    public boolean addData(int key, String data) {
        BSTNode currNode = root;
        while (currNode != null) {
            if (currNode.getKey() == key) {
                if (currNode.removeData(data)) {
                    return true;
                } else {
                    return false;
                }
            } else if (currNode.getKey() < key) {
                currNode = currNode.right;
            } else {
                currNode = currNode.left;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * Removes the specified data from the node.
     * 
     * @param key  the key to find
     * @param data the data to remove
     * 
     * @throws IllegalArgumentException if the node doesn’t exist
     * 
     * @return boolean, {@code true} if the addition was successful, or
     *         {@code false} if the node doesn’t exist.
     */
    public boolean removeData(int key, String data) {
        BSTNode currNode = root;
        while (currNode != null) {
            if (currNode.getKey() == key) {
                currNode.removeData(data);
                return true;
            } else if (currNode.getKey() < key) {
                currNode = currNode.right;
            } else {
                currNode = currNode.left;
            }
        }
        return false;
    }

    /**
     * Locate the node under specified key.
     * 
     * @param key the key to find
     * 
     * @return BSTNode, the node under the key, {@code null} if the node doesn't
     *         exist
     */
    public BSTNode nodeLocator(int key) {
        BSTNode currNode = root;
        while (currNode != null) {
            if (currNode.getKey() == key) {
                return currNode;
            } else if (currNode.getKey() < key) {
                currNode = currNode.right;
            } else {
                currNode = currNode.left;
            }
        }
        return null;
    }

    /**
     * Removes the node under a given key. If the node is removed successfully, it
     * should be replaced by the largest child in the left branch. If there are no
     * children in the left branch, replace the removed node with the next child in
     * the right branch.
     * 
     * @param key the key to find the node
     * 
     * @return boolean, {@code true} if the removal was a success, {@code false} if
     *         the key wasn’t found.
     */
    public boolean removeNode(int key) {
        BSTNode removeNode = nodeLocator(key);
        if (removeNode == null)
            return false;
        if (removeNode.left == null && removeNode.right == null) {
            if (root.key == removeNode.key) {
                root = null;
                return true;
            }
            BSTNode p = getParent(removeNode);
            if (p.left == removeNode) {
                p.left = null;
            } else {
                p.right = null;
            }
        } else if ((removeNode.left != null && removeNode.right == null)
                || (removeNode.left == null && removeNode.right != null)) {
            BSTNode p = getParent(removeNode);
            if (removeNode.left != null) {
                if (root.key == removeNode.key) {
                    root = root.left;
                    return true;
                }
                BSTNode pre = getPrNode(removeNode);
                getParent(pre).right = null;
                if (p.left == removeNode) {
                    p.left = pre;
                } else {
                    p.right = pre;
                }
            } else {
                if (root.key == removeNode.key) {
                    root = root.right;
                    return true;
                }
                if (p.left == removeNode) {
                    p.left = removeNode.right;
                } else {
                    p.right = removeNode.right;
                }
            }
        } else {
            BSTNode pre = getPrNode(removeNode);
            BSTNode p = getParent(removeNode);
            if (p == null) {
                if (pre == removeNode.left) {
                    pre.right = removeNode.right;
                } else {
                    getParent(pre).right = null;
                    pre.left = removeNode.left;
                    pre.right = removeNode.right;
                }
                root = pre;
            } else {
                getParent(pre).right = null;
                if (p.left == removeNode) {
                    p.left = pre;
                } else {
                    p.right = pre;
                }
                pre.right = removeNode.right;
            }
        }
        --nElems;
        return true;
    }

    /**
     * Find the minimum node of the BST tree.
     * 
     * @param root the root of the tree or subtree
     * 
     * @return BSTNode, the node under the key, {@code null} if the root doesn't
     *         exist
     */
    public BSTNode treeMinimum(BSTNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * Find the maximum node of the BST tree.
     * 
     * @param root the root of the tree or subtree
     * 
     * @return BSTNode, the node under the key, {@code null} if the root doesn't
     *         exist
     */
    public BSTNode treeMaximum(BSTNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    /**
     * Find the parent given specified node.
     * 
     * @param node
     * 
     * @return BSTNode, the node under the key, {@code null} if the parent doesn't
     *         exist
     */
    public BSTNode getParent(BSTNode node) {
        if (node == root)
            return null;
        BSTNode parNode = null, currNode = root;
        while (currNode != null) {
            if (currNode.getKey() == node.getKey()) {
                return parNode;
            } else if (currNode.getKey() < node.getKey()) {
                parNode = currNode;
                currNode = currNode.right;
            } else {
                parNode = currNode;
                currNode = currNode.left;
            }
        }
        return null;
    }

    /**
     * Find the successor node given specified node based on in-order traversing.
     * 
     * @param node
     * 
     * @return BSTNode, the node under the key, {@code null} if the node itself is
     *         the maximum
     */
    public BSTNode getSucceNode(BSTNode node) {
        if (node.right != null) {
            return treeMinimum(node.right);
        } else {
            BSTNode p = getParent(node);
            while (p != null && node == p.right) {
                node = p;
                p = getParent(node);
            }
            return p;
        }
    }

    /**
     * Find the predecessor node given specified node based on in-order traversing.
     * 
     * @param node
     * 
     * @return BSTNode, the node under the key, {@code null} if the node itself is
     *         the minumum
     */
    public BSTNode getPrNode(BSTNode node) {
        if (node.left != null) {
            return treeMaximum(node.left);
        } else {
            BSTNode p = getParent(node);
            while (p != null && node == p.left) {
                node = p;
                p = getParent(node);
            }
            return p;
        }
    }

    /**
     * Count the leaves of the BST tree.
     * 
     * @param root root of a tree or subtree
     * 
     * @return int, the leaves the BST tree has
     */
    public int leafCount(BSTNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right == null) {
            return leafCount(root.left);
        } else if (root.left == null && root.right != null) {
            return leafCount(root.right);
        } else {
            return leafCount(root.left) + leafCount(root.right);
        }
    }

    /**
     * In-order traversing. format: "%d "
     * 
     * @param root root of a tree or subtree.
     */
    public void inOrderTraverse(BSTNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.printf("%d ", root.getKey());
            inOrderTraverse(root.right);
        }
    }
}
