package general;

import java.util.ArrayList;

public class MergeSort {
    private ArrayList<String> result = new ArrayList<>();

    public void sort() {
        System.out.println(result);
    }

    public MergeSort(ArrayList<String> result) throws Exception {
        this.result = result;
    }
}
