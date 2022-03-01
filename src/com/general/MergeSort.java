package general;

import java.util.ArrayList;

public class MergeSort {
    public static void defaultMerge(ArrayList<String> result, 
                                    ArrayList<String> left, 
                                    ArrayList<String> right, 
                                    int lSize, int rSize) {
        int lArrow = 0, rArrow = 0, mArrow = 0;
        while (lArrow < lSize && rArrow < rSize) {
            int lBlock = Integer.parseInt(left.get(lArrow));
            int rBlock = Integer.parseInt(right.get(rArrow));

            if ( lBlock <= rBlock ) {
                result.set( ++mArrow, left.get(++lArrow) ); 
            } else {
                result.set( ++mArrow, right.get(++rArrow) ); 
            }
        }

        while (lArrow < lSize) {
            result.set( ++mArrow, left.get(++lArrow) ); 
        }

        while (rArrow < rSize) {
            result.set( ++mArrow, right.get(++rArrow) ); 
        }
    }

    public static void basementOfMerge(ArrayList<String> result, int lengthOfArray) {
        try {
            if (lengthOfArray < 2) { return; }
            else {
                int middleOfArray = lengthOfArray / 2;
                ArrayList<String> leftSide = new ArrayList<>();
                ArrayList<String> rightSide = new ArrayList<>();

                for (int iter = 0; iter < middleOfArray; ++iter) {
                    leftSide.add( result.get(iter) );
                }

                for (int iter = middleOfArray; iter < lengthOfArray; ++iter) {
                    rightSide.add( result.get(iter) );
                }

                basementOfMerge(leftSide, leftSide.size());
                basementOfMerge(rightSide, rightSide.size());

                defaultMerge(result, leftSide, rightSide, leftSide.size(), rightSide.size());
            }
        }

        catch (Exception e) { System.out.println( "Here we go (basementOfMerge) => " + e.getStackTrace() ); }
    }

    MergeSort(ArrayList<String> result, int lengthOfArray) {
        basementOfMerge(result, lengthOfArray);
    }
}
