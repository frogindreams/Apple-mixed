package general;

import java.util.ArrayList;

public class MergeSort {
    private static boolean isRMode;
    public ArrayList<String> result = new ArrayList<>();

    public void merge(ArrayList<String> m, ArrayList<String> l, ArrayList<String> r, int left, int right) {
        try {
            int iLeft = 0, iRight = 0, iMain = 0;
            while ((iLeft < left) && (iRight < right)) {
                int leftPart = Integer.parseInt(l.get(iLeft));
                int rightPart = Integer.parseInt(r.get(iRight));

                if ( leftPart <= rightPart ) {
                    m.set( iMain++, l.get(iLeft++) );
                } else {
                    m.set( iMain++, r.get(iRight++) );
                }
            }

            while (iLeft < left) {
                m.set( iMain++, l.get(iLeft++) );
            }

            while (iRight < right) {
                m.set( iMain++, r.get(iRight++) );
            }
        }

        catch (Exception e) { System.out.println( "Here we go (merge) => " + e.getStackTrace() ); }
    }

    public void defaultMerge(ArrayList<String> result, int length) {
        if (length < 2) { return; }
        else {
            int middle = length / 2;
            ArrayList<String> leftSide = new ArrayList<>();
            ArrayList<String> rightSide = new ArrayList<>();

            for (int iter = 0; iter < middle; ++iter) {
                leftSide.add( result.get(iter) );
            }

            for (int iter = middle; iter < length; ++iter) {
                rightSide.add( result.get(iter) );
            }

            defaultMerge(leftSide, middle);
            defaultMerge(rightSide, length - middle);

            merge(result, leftSide, rightSide, middle, length - middle);
        }
    }

    public void reverseMerge(ArrayList<String> result, int length) {
        System.out.println("rev");
    }

    public void basementOfMerge(ArrayList<String> result, int lengthOfArray) {
        try {
            if (isRMode) {
                reverseMerge(result, lengthOfArray);
            } else {
                defaultMerge(result, lengthOfArray);
            }
        }

        catch (Exception e) { System.out.println( "there it is (basementOfMerge) => " + e.getStackTrace() ); }
    }

    MergeSort(ArrayList<String> result, int lengthOfArray, boolean isRMode) {
        this.isRMode = isRMode;
        this.result = result;
        basementOfMerge(result, lengthOfArray);
    }
}
