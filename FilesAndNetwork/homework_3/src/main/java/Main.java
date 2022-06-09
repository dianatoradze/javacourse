import au.com.bytecode.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static final String PATH = "files/movementList.csv";

    public static void main(String[] args)  {

       Movements bill = new Movements(PATH);

       bill.print();

    }

}

