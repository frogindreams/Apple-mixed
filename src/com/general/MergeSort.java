package general;

import java.util.ArrayList;

public class MergeSort {
    public static void defaultMerge(ArrayList<String> result, 
                                    ArrayList<String> left, 
                                    ArrayList<String> right, 
                                    int leftArrow, int rightArrow) {
        int leftDot = 0, rightDot = 0, dot = 0;

        while (leftDot < leftArrow && rightDot < rightArrow) {
            if ( (left.get(leftDot)) <= (right.get(rightDot)) ) {
                result.set( ++dot, left.get(++leftDot) );
            } else { 
                result.set( ++dot, right.get(++rightDot) ); 
            }
        }

        while (leftDot < leftArrow) {
            result.set( ++dot, left.get(++leftDot) );
        }

        while (rightDot < rightArrow) {
            result.set( ++dot, right.get(++rightDot) );
        }
    }

    public void sort(ArrayList<String> result, int lengthOfArray) {
        if (lengthOfArray < 2) { return; }
        else {
            int middleOfArray = lengthOfArray / 2;
            ArrayList<String> leftSide = new ArrayList<>();
            ArrayList<String> rightSide = new ArrayList<>();

            for (int iter = 0; iter < middleOfArray; ++iter) {
                leftSide.add( result.get(iter) );
            }

            for (int iter = middleOfArray; iter < lengthOfArray; ++iter ) {
                rightSide.add( result.get(iter) );
            }

            defaultSort(leftSide, middleOfArray);
            defaultSort(rightSide, lengthOfArray);

            defaultMerge(result, leftSide, rightSide, middleOfArray, lengthOfArray - middleOfArray);
        }
    }
}
