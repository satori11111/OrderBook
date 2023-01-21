import lombok.SneakyThrows;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws Exception {
//        FileInputStream file=new FileInputStream("C:\\Users\\Roman\\Desktop\\oop\\OrderBook\\input.txt");
//
//       InputStreamReader inputStreamReader=new InputStreamReader(file);
//       BufferedReader reader=new BufferedReader(inputStreamReader);
//
//       reader.lines();
//
//    FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\Roman\\Desktop\\oop\\OrderBook\\output.txt");
//
//    OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
//    BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
//     var list= reader.lines().map(s -> s.toString()).collect(Collectors.toList());
//    list.forEach(s -> {
//        try {
//            bufferedWriter.write(s.toCharArray());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    });
//        bufferedWriter.close();
//    outputStreamWriter.close();

ReadingfromFile.readAllLines();


    }
}
