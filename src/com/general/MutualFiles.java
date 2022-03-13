package general;

import java.util.ArrayList;
import java.io.Reader;
import java.io.FileReader;
import java.io.Writer;
import java.io.FileWriter;

import general.MergeSort;

public class MutualFiles {
    public ArrayList<String> mutual = new ArrayList<>();
    private String nameForOutput;
    public boolean isRMode = false;
    MergeSort obj;


    private ArrayList<String> getArrayOfFiles(String[] quarrels) {
        ArrayList<String> files = new ArrayList<>();
        int isFirst = 0;
        
        for (int iter = 0; iter < quarrels.length; ++iter) {
            if (quarrels[iter].length() != 2) {
                ++isFirst;
                if (isFirst > 1) { files.add(quarrels[iter]); }
                else { nameForOutput = quarrels[iter]; }
            } else {
                if (quarrels[iter].equals("-r")) { isRMode = true; }
            }
        }

        return files;
    }

    private void RecordIntoArray(String... arguments) {
        ArrayList<String> files = getArrayOfFiles(arguments);

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
                System.out.println( "Here we go (RecordIntoArray) => " + e.getStackTrace() );
            }
        }
    }

    public MutualFiles(String... files) {
        RecordIntoArray(files);
    }

    public void ShowUp() {
        if (obj == null) { System.out.println(mutual); }
        else { System.out.println( "obj.result => " + obj.result); }
    }

    public void BlowUp() {
        try {
            Writer output = new FileWriter("files/" + nameForOutput);
            if (obj == null) {
                for (int iter = 0; iter < mutual.size(); ++iter) { 
                    output.write(mutual.get(iter));
                    output.write("\n");
                }
            } else {
                for (int iter = 0; iter < (obj.result).size(); ++iter) { 
                    output.write((obj.result).get(iter));
                    output.write("\n");
                }
            }

            output.close();
        }

        catch (Exception e) {
            System.out.println( "Here we go (BlowUp) => " + e.getStackTrace() );
        }
    }

    public void AppleMix() {
        obj = new MergeSort(mutual, mutual.size(), isRMode);        
    }
}
