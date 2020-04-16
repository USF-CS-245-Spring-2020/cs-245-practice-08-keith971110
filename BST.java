public class BST<T extends Comparable> {
    private BSTNode<T> root;

    public boolean find(T item){
        return find(root, item);
    }
    protected boolean find(BSTNode<T> node, T item){
        if(node == null){
            return false;
        }
        if(item.compareTo(node.value)==0){
            return true;
        }
        else if(item.compareTo(node.value)<0){
            return find(node.left, item);
        }
        else{
            return find(node.right,item);
        }

    }
    public void insert(T item){
        root = insert(root, item);
    }

    protected BSTNode<T> insert(BSTNode<T>node, T item){
        if(node == null){
            return new BSTNode<T>(item);
        }
        if(item.compareTo(node.value)<0){
            node.left=insert(node.left,item);
        }
        else{
            node.right=insert(node.right,item);
        }
        return node;
    }
    public void delete(T item){
        root = delete(root,item);
    }
    protected BSTNode<T> delete(BSTNode<T>node,T item){
        if(node == null){
            return null;
        }
        if(item.compareTo(node.value)>0){
            node.right = delete(node.right, item);
            return  node;
        }
        else if(item.compareTo(node.value)<0){
            node.left=delete(node.left, item);
            return node;
        }
        else{
            if(node.left==null){
                return node.right;
            }
            else if(node.right==null){
                return node.left;
            }
            else{
                if(node.right.left==null){
                    node.value=node.right.value;
                    node.right=node.right.right;
                }
                else{
                    node.value=removeSmallest(node.right);
                }
            }
            return node;
        }
    }
    protected T removeSmallest(BSTNode<T> node){
        if(node.left.left==null){
            T small=node.left.value;
            node.left=node.left.right;
            return small;
        }
        else{
            return removeSmallest(node.left);
        }
    }
    public void print(){
        p(root);
    }
    public void p(BSTNode<T>node){
        if(node!=null){
            p(node.left);
            System.out.print(node.value);
            p(node.right);
        }
    }
}
