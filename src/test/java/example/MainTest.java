package example;

import lombok.extern.slf4j.*;

import org.junit.*;

import java.io.*;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

@Slf4j
public class MainTest {

    @Test
    public void foo() throws IOException {

//         Using InputStream
        String path = "src/test/resources/input.txt";
        File input = new File(path);
        try (InputStream in = new FileInputStream(input)) {
            int columns = 9;
            int rows = 7;
            char field[][] = new char[rows][columns];
            int content = in.read();

            // this code can be optimized
            // reading files into the two-dimensional array
            for (int row = 0; content != -1 && row < 7; row++) {
                switch (content) {
                    case 10:
                    case 13:
                        content = in.read();
                        row--;
                        break;
                    default:
                        for (int column = 0; column < columns; column++) {
                            field[row][column] = (char) content;
                            content = in.read();
                     }
              }
          }
           // printing the field out
           System.out.println(Arrays.deepToString(field));
       } catch (Exception e) {
          e.printStackTrace();
       }


        //  Using BufferedReader
//        String fileName = "src/test/resources/input.txt";
//        BufferedReader reader = new BufferedReader(new FileReader(fileName));
//        String line = null;
//        StringBuilder stringBuilder = new StringBuilder();
//        String ls = System.getProperty("line.separator");
//        while ((line = reader.readLine()) != null) {
//            stringBuilder.append(line);
//            stringBuilder.append(ls);
//        }
//
//        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
////        System.out.println(stringBuilder.toString());
//
//        String[] Fielder = (stringBuilder.toString()).split(" ");
//        System.out.println(Arrays.toString(Fielder));
//        String[] FielderDouble = Fielder[0].split("\n");
//        System.out.println(Arrays.toString(FielderDouble));


    }
}

