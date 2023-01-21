import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Setter
public class OrderLines {

private int price;
    private int size;
    private Type type;

    @Override
    public String toString() {
        return "OrderLines{" +
                "price=" + price +
                ", size=" + size +
                ", type=" + type +
                '}';
    }
}
