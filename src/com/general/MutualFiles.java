package general;

import java.io.Reader;
import java.io.FileReader;

public class MutualFiles {
    private char[] mutual = new char[100];

    public MutualFiles(String... files) {
        try {
            for (String file : files) {
                Reader currentFile = new FileReader("files/" + file);

                System.out.println("File's state: " + currentFile.ready());
                if ( currentFile.ready() ) {
                    currentFile.read(mutual);
                    currentFile.close();
                } else {
                    /*
                     * here's I need to come up something
                     */
                }
            }
        }

        catch (Exception e) {
            System.out.println( "Here we go => " + e.getStackTrace() );
        }
    }

    public void ShowUp() {
        System.out.println(mutual);
    }
}
