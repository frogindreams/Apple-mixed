package general;

import java.util.ArrayList;

public class MergeSort {
    private static boolean isRMode;
    public ArrayList<String> result = new ArrayList<>();

    public void defaultMerge(int length) {
        System.out.println("def");

        
    }

    public void reverseMerge(int length) {
        System.out.println("rev");
    }

    public void basementOfMerge(ArrayList<String> result, int lengthOfArray) {
        try {
            if (isRMode) {
                reverseMerge(lengthOfArray);
            } else {
                defaultMerge(lengthOfArray);
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
