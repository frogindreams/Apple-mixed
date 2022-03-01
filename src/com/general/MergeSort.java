package general;

import java.util.ArrayList;

public class MergeSort {
    public static void defaultMerge(ArrayList<String> result,
                                    ArrayList<String> left,
                                    ArrayList<String> right,
                                    int left, int right) {
        System.out.println("it's working");
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

        catch (Exception e) { System.out.println( "Here we go (basementOfMerge) => " + e.getStackTrace() ) }
    }

    MergeSort(ArrayList<String> result, int lengthOfArray) {
        basementOfMerge(result, lengthOfArray);
    }
}
