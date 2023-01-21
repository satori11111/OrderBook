import java.util.ArrayList;
import java.util.List;

public class OrderBookImpl {
    private static List<OrderLines> orderBook=new ArrayList<>();

    public static List<OrderLines> getOrderBook() {
        return orderBook;
    }

    public  void addOrUpdate(OrderLines newLine){
        if(orderBook.size()==0){
            orderBook.add(newLine);
        }
       else {
        for (int i=0;i<orderBook.size();i++) {
            var oldLine=orderBook.get(i);

            if (oldLine.getPrice()==(newLine.getPrice()) && oldLine.getType()==newLine.getType()) {
                int newSize = oldLine.getSize() + newLine.getSize();
                orderBook.set(i,new OrderLines(oldLine.getPrice(),newSize,oldLine.getType()));

            } else if (oldLine.getPrice()==(newLine.getPrice()) && !oldLine.getType().equals(newLine.getType())) {
                int newSize = oldLine.getSize() - newLine.getSize();
                if (newSize < 0) {
                    orderBook.set(i,new OrderLines(oldLine.getPrice(),Math.abs(newSize),newLine.getType()));
                } else if (newSize == 0) {
                    orderBook.set(i,new OrderLines(oldLine.getPrice(),newSize,Type.A));


                }
            } else {
                orderBook.add(newLine);
            }
         }
        }
    }



}
