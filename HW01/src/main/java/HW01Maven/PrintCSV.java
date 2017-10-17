package HW01Maven;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.*;

class PrintCSV {
    private static final String TEXTFILE = "roles.csv";

    PrintCSV() throws IOException {
        printRoles();
    }

    private void printRoles() throws IOException {

        try {
            BufferedReader in = new BufferedReader(new FileReader(TEXTFILE));
            for (CSVRecord record : CSVFormat.DEFAULT.parse(in)) {
                for (String field : record) {
                    System.out.println("\"" + field + "\", ");
                }
            }
        } catch (IOException ex) {
            Reader in = new StringReader("file,not,found");
            for (CSVRecord record : CSVFormat.DEFAULT.parse(in)) {

                for (String field : record) {
                    System.out.println("\"" + field + "\", ");
                }
            }
        }
    }
}