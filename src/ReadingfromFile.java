import java.io.*;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ReadingfromFile {

    public static void readAllLines() throws IOException,Exception {
        OrderBookImpl orderBook=new OrderBookImpl();
        FileInputStream file=new FileInputStream("C:\\Users\\Roman\\Desktop\\oop\\OrderBook\\input.txt");
        InputStreamReader inputStreamReader=new InputStreamReader(file);
        BufferedReader reader=new BufferedReader(inputStreamReader);
       var listOperations= reader.lines().collect(Collectors.toList());
 for (int i=0;i<listOperations.size();i++){
       String s=listOperations.get(i);
       String[ ] arrVariables=  s.split(",");
           if(s.charAt(0)=='u') {
               int price = Integer.parseInt(arrVariables[1]);
               int size = Integer.parseInt(arrVariables[2]);
               Type type = fromStringToType(arrVariables[3]);
               OrderLines line = new OrderLines(price, size, type);

               orderBook.addOrUpdate(line);

           } else if (s.charAt(0)=='o') {

               if(arrVariables[1].equals("sell")) {
                   int size = Integer.parseInt(arrVariables[2]);
                   int min = OrderBookImpl.getOrderBook().stream().filter(orderLine -> orderLine.getType() == Type.B)
                           .map(orderLine -> orderLine.getPrice())
                           .min(Comparator.comparing(Integer::longValue)).get();
                   orderBook.addOrUpdate(new OrderLines(min, size, Type.A));

               }
               else if(arrVariables[1].equals("buy")){
                   int size = Integer.parseInt(arrVariables[2]);
                   int max = OrderBookImpl.getOrderBook().stream().filter(orderLine -> orderLine.getType() == Type.A)
                           .map(orderLine -> orderLine.getPrice())
                           .max(Comparator.comparing(Integer::longValue)).get();
                   orderBook.addOrUpdate(new OrderLines(max, size, Type.B));
               }
           }
           else if (s.charAt(0)=='q'){
                   int min= OrderBookImpl.getOrderBook().stream()
                           .filter(orderLine ->  orderLine.getType()==Type.B && orderLine.getSize()!=0)
                           .map(orderLine->orderLine.getPrice())
                           .min(Comparator.comparing(Integer::longValue)).get();
                   int size=OrderBookImpl.getOrderBook().stream()
                           .filter(orderLines -> orderLines.getPrice()==min)
                           .map(orderLines -> orderLines.getSize()).findAny().get();
                  String answer=min+","+size +"\n";
                  WritingToFile.writingList(answer);


           }
           else {
               System.out.println("error not found");
           }


 }


         reader.close();
    }

    private static Type fromStringToType(String s) throws Exception {
        Type type;
        if (s.equals("B")){
            type =Type.B;
        }
        else if(s.equals("A")){
            type=Type.A;
        }
        else {
            throw new Exception("Not Found Type");
        }
return type;
    }
}
