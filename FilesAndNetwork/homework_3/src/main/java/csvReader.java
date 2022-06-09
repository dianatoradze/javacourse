import au.com.bytecode.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class csvReader {

        // Using OpenCSV API

      public void csvReaderMethod(String filePath) throws FileNotFoundException, CsvValidationException {
            try {
                FileReader fileReader = new FileReader(filePath);
                CSVReader csvReader = new CSVReader(fileReader);

                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    for(String data : line) {
                        System.out.print(data + " ");
                    }
                    System.out.println();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
