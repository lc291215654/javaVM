package MyCode06;

public class C05_AVLTree {

    public AVLNode root;

    protected int size;

    public AVLNode search(int element) {
        AVLNode node = root;
        while (node != null && node.value != null && node.value != element) {
            if (element < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public AVLNode insert(int element) {
        if (root == null) {
            root = createAVLNode(element, null, null, null);
            size++;
            return root;
        }
        AVLNode ins = null;
        AVLNode temp = root;
        while (temp != null && temp.value != null) {
            ins = temp;
            if (element < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        AVLNode newNode = createAVLNode(element, ins, null, null);
        if (ins.value > newNode.value) {
            ins.left = newNode;
        } else {
            ins.right = newNode;
        }

        size++;
        return newNode;
    }

    /**
     * Put one node from tree (newNode) to the place of another (nodeToReplace).
     *
     * @param nodeToReplace Node which is replaced by newNode and removed from tree.
     * @param newNode       New node.
     * @return New replaced node.
     */
    private AVLNode transplant(AVLNode nodeToReplace, AVLNode newNode) {
        if (nodeToReplace.parent == null) {
            this.root = newNode;
        } else if (nodeToReplace == nodeToReplace.parent.left) {
            nodeToReplace.parent.left = newNode;
        } else {
            nodeToReplace.parent.right = newNode;
        }
        if (newNode != null) {
            newNode.parent = nodeToReplace.parent;
        }
        return newNode;
    }

    protected AVLNode getMinimum(AVLNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    protected AVLNode getMaximum(AVLNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    protected AVLNode delete(AVLNode deleteNode) {
        if (deleteNode != null) {
            AVLNode nodeToReturn = null;
            if (deleteNode != null) {
                if (deleteNode.left == null) {
                    nodeToReturn = transplant(deleteNode, deleteNode.right);
                } else if (deleteNode.right == null) {
                    nodeToReturn = transplant(deleteNode, deleteNode.left);
                } else {
                    AVLNode successorNode = getMinimum(deleteNode.right);
                    if (successorNode.parent != deleteNode) {
                        transplant(successorNode, successorNode.right);
                        successorNode.right = deleteNode.right;
                        successorNode.right.parent = successorNode;
                    }
                    transplant(deleteNode, successorNode);
                    successorNode.left = deleteNode.left;
                    successorNode.left.parent = successorNode;
                    nodeToReturn = successorNode;
                }
                size--;
            }

            return nodeToReturn;
        }
        return null;
    }


    public AVLNode delete(int element) {
        AVLNode deleteAVLNode = search(element);
        if (deleteAVLNode != null) {
            AVLNode successorAVLNode = delete(deleteAVLNode);
            if (successorAVLNode != null) {
                // if replaced from getMinimum(deleteAVLNode.right) then come back there and update heights
                AVLNode minimum = successorAVLNode.right != null ? (AVLNode) getMinimum(successorAVLNode.right) : (AVLNode) successorAVLNode;
                recomputeHeight(minimum);
                rebalance((AVLNode) minimum);
            } else {
                recomputeHeight((AVLNode) deleteAVLNode.parent);
                rebalance((AVLNode) deleteAVLNode.parent);
            }
            return successorAVLNode;
        }
        return null;
    }

    protected AVLNode createAVLNode(int value, AVLNode parent, AVLNode left, AVLNode right) {
        return new AVLNode(value, parent, left, right);
    }

    /**
     * Go up from inserted node, and update height and balance informations if needed.
     * If some node balance reaches 2 or -2 that means that subtree must be rebalanced.
     *
     * @param node Inserted AVLNode.
     */
    private void rebalance(AVLNode node) {
        while (node != null) {
            AVLNode parent = node.parent;
            int leftHeight = (node.left == null) ? -1 : node.left.height;
            int rightHeight = (node.right == null) ? -1 : node.right.height;
            int nodeBalance = rightHeight - leftHeight;
            // rebalance (-2 means left subtree outgrow, 2 means right subtree)
            if (nodeBalance == 2) {
                if (node.right.right != null) {
                    node = avlRotateLeft(node);
                    break;
                } else {
                    node = doubleRotateRightLeft(node);
                    break;
                }
            } else if (nodeBalance == -2) {
                if (node.left.left != null) {
                    node = avlRotateRight(node);
                    break;
                } else {
                    node = doubleRotateLeftRight(node);
                    break;
                }
            } else {
                updateHeight(node);
            }
            node = parent;
        }
    }

    /**
     * Rotates to left side.
     */
    private AVLNode avlRotateLeft(AVLNode node) {
        AVLNode temp = rotateLeft(node);
        updateHeight(temp.left);
        updateHeight(temp);
        return temp;
    }

    /**
     * Rotates to right side.
     */
    private AVLNode avlRotateRight(AVLNode node) {
        AVLNode temp = rotateRight(node);
        updateHeight(temp.right);
        updateHeight(temp);
        return temp;
    }

    /**
     * Take right child and rotate it to the right side first and then rotate
     * node to the left side.
     */
    protected AVLNode doubleRotateRightLeft(AVLNode node) {
        node.right = avlRotateRight(node.right);
        return avlRotateLeft(node);
    }

    /**
     * Take right child and rotate it to the right side first and then rotate
     * node to the left side.
     */
    protected AVLNode doubleRotateLeftRight(AVLNode node) {
        node.left = avlRotateLeft(node.left);
        return avlRotateRight(node);
    }

    /**
     * Recomputes height information from the node and up for all of parents. It needs to be done after delete.
     */
    private void recomputeHeight(AVLNode node) {
        while (node != null) {
            node.height = maxHeight(node.left, node.right) + 1;
            node = node.parent;
        }
    }

    /**
     * Returns higher height of 2 nodes.
     */
    private int maxHeight(AVLNode node1, AVLNode node2) {
        if (node1 != null && node2 != null) {
            return node1.height > node2.height ? node1.height : node2.height;
        } else if (node1 == null) {
            return node2 != null ? node2.height : -1;
        } else if (node2 == null) {
            return node1 != null ? node1.height : -1;
        }
        return -1;
    }

    /**
     * Updates height and balance of the node.
     *
     * @param node AVLNode for which height and balance must be updated.
     */
    private static final void updateHeight(AVLNode node) {
        int leftHeight = (node.left == null) ? -1 : ((AVLNode) node.left).height;
        int rightHeight = (node.right == null) ? -1 : ((AVLNode) node.right).height;
        node.height = 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Rotate to the left.
     *
     * @param node AVLNode on which to rotate.
     * @return AVLNode that is in place of provided node after rotation.
     */
    protected AVLNode rotateLeft(AVLNode node) {
        AVLNode temp = node.right;
        temp.parent = node.parent;

        node.right = temp.left;
        if (node.right != null) {
            node.right.parent = node;
        }

        temp.left = node;
        node.parent = temp;

        // temp took over node's place so now its parent should point to temp
        if (temp.parent != null) {
            if (node == temp.parent.left) {
                temp.parent.left = temp;
            } else {
                temp.parent.right = temp;
            }
        } else {
            root = temp;
        }

        return temp;
    }

    /**
     * Rotate to the right.
     *
     * @param node AVLNode on which to rotate.
     * @return AVLNode that is in place of provided node after rotation.
     */
    protected AVLNode rotateRight(AVLNode node) {
        AVLNode temp = node.left;
        temp.parent = node.parent;

        node.left = temp.right;
        if (node.left != null) {
            node.left.parent = node;
        }

        temp.right = node;
        node.parent = temp;

        // temp took over node's place so now its parent should point to temp
        if (temp.parent != null) {
            if (node == temp.parent.left) {
                temp.parent.left = temp;
            } else {
                temp.parent.right = temp;
            }
        } else {
            root = temp;
        }

        return temp;
    }

    class AVLNode {
        public int height;

        public AVLNode(Integer value, AVLNode parent, AVLNode left, AVLNode right) {
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Integer value;
        public AVLNode parent;
        public AVLNode left;
        public AVLNode right;

        public boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((value == null) ? 0 : value.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            AVLNode other = (AVLNode) obj;
            if (value == null) {
                if (other.value != null)
                    return false;
            } else if (!value.equals(other.value))
                return false;
            return true;
        }
    }

}
