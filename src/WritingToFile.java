

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;


public class WritingToFile {
 public static void writingList(String s) throws IOException {
     FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\Roman\\Desktop\\oop\\OrderBook\\output.txt");
     OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
     BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
     bufferedWriter.write(s);

     bufferedWriter.close();
 }
    public WritingToFile() {
    }

}
