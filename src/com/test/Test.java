package test;

import general.*;

class Test {
    public static void main(String[] args) throws Exception {
        MutualFiles obj = new MutualFiles("packNumberOne.txt", "packNumberTwo.txt");
        obj.AppleMix();
    }
}
