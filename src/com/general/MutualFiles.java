package general;

import java.util.ArrayList;
import java.io.Reader;
import java.io.FileReader;

public class MutualFiles {
    private ArrayList<String> mutual = new ArrayList<>();

    private void WriteIntoArray(String... files) {
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
        WriteIntoArray(files);
    }

    public void ShowUp() {
        System.out.println(mutual);
    }
}
