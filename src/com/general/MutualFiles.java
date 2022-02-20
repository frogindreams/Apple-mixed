package general;

import java.util.ArrayList;
import java.io.Reader;
import java.io.FileReader;

import general.MergeSort;

public class MutualFiles {
    private ArrayList<String> mutual = new ArrayList<>();

    private void RecordIntoArray(String... files) {
        for (String file : files) {
            try (FileReader current = new FileReader("files/" + file)) {
                StringBuffer sb = new StringBuffer();
                while (current.ready()) {
                    char c = (char) current.read();
                    if (c == '\n') {
                        mutual.add(sb.toString());
                        sb = new StringBuffer();
                    } else {
                        sb.append(c);
                    }
                }

                if (sb.length() > 0) {
                    mutual.add(sb.toString());
                }
            }

            catch (Exception e) {
                System.out.println( "Here we go => " + e.getStackTrace() );
            }
        }
    }

    public MutualFiles(String... files) {
        RecordIntoArray(files);
    }

    public void ShowUp() {
        System.out.println(mutual);
    }

    public void AppleMix() throws Exception {
        MergeSort result = new MergeSort(mutual);
        result.sort();
    }
}
