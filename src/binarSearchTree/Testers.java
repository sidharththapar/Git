package binarSearchTree;

import java.util.Random;

/**
 * Created by Dell on 19-11-2016.
 */
public class Testers
{
    // random integers are generated
    public static int rndInt(int min, int max){
        Random rand=new Random();
        return rand.nextInt((max-min) + 1) + min;
        //max = 15, max = 5
        // 15-5 = 10 + 1
        // 11 --> 0 to 10
        // + 5 to this random number
    }

    //random binary Search trees are generated
    //    count tells number of nodes in new tree
    public static Tree rndTree(int count){
        if(count == 0 ){
            return new EmptyBST();
        }else{
            return rndTree(count-1).add(rndInt(0,50));
        }
    }





    // x + (x+2) = x + x + 2;


    public static void checkIsEmpty(Tree t) throws Exception {
        //check if t is an instance of EmptyBST && t.isEmpty = true
        if(t instanceof EmptyBST){
            if (!t.isEmpty()){
                throw new Exception("Oops! the tree is an EmptyBST but it is not empty.");
            }
        }

        //check if t is an instance of NonEmptyBST && isEmpty = false
        if(t instanceof NonEmptyBST){
            if (t.isEmpty()){
                throw new Exception("Oops! the tree is NonEmptyBST but it is empty.");
            }
        }
    }

    public static void checkAddMemberCardinality(Tree t, int x) throws Exception{
        int nT = (t.add(x)).cardinality();
        // 1. Either, something was added and the cardinality increased by one.
        if(nT == (t.cardinality() + 1) ) {
            if (t.member(x)) {
                throw new Exception("The cardinality increased by 1, but the thing"
                        + "that was added was already a member of the tree.");
            }
            else{
                throw new Exception("Great! The cardinality increased and the new " +
                        "thing was not there in the hashset");
            }
        }

        // 2. OR the thing that was added was already there in the hashset and
        //    therefore not really added, so the cardinality stayed the same
        else if (nT == t.cardinality()) {
            if (!t.member(x)) {
                throw new Exception("The cardinality did not increase by 1, but" +
                        " we added a new item");
            } else {
                throw new Exception("Great! The cardinality didnot increase since the" +
                        " new " + "thing was there in the Tree");
            }
        }

        else{
            throw new Exception("Something is wrong with our program.");
        }
    }
}
