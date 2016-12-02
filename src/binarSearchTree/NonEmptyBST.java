package binarSearchTree;

/**
 * Created by Dell on 02-11-2016.
 */
public class NonEmptyBST<D extends Comparable> implements Tree<D> {
    D data;
    Tree<D> left;
    Tree<D> right;

    public NonEmptyBST(D element){
        data = element;
        left = new NonEmptyBST<D>();
        right = new NonEmptyBST<D>();
    }

    public NonEmptyBST(D element, Tree<D> leftTree, Tree<D> rightTree) {
        data = element;
        left = leftTree;
        right = rightTree;
    }


    public NonEmptyBST(){
    }

    public boolean isEmpty(){
        return false;
    }

    public int cardinality(){
        return 1 + left.cardinality() + right.cardinality();
    }

    @Override
    public boolean member(D element) {
        if (this.data==element) {
            return true;
        }
        else {
            if (element.compareTo(data) < 0) {
                return left.member(element);
            }

            else  {
                return right.member(element);

            }
        }
    }

    public NonEmptyBST<D> add(D element){
        // data is root here
        if (data == element) {
            return this;
        } else{
            if (element.compareTo(data) < 0) {
                return new NonEmptyBST(data, left.add(element), right);
            } else{
                return new NonEmptyBST(data, left, right.add(element));
            }
        }
    }
}
