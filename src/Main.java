import com.raiden.homework.pattern.proxy.Agency;
import com.raiden.homework.pattern.proxy.DynamicProxy;
import com.raiden.homework.pattern.proxy.LianJia;

public class Main {

    public static void main(String[] args) {
        Agency agency = (Agency) new DynamicProxy().proxy(LianJia.class);
        agency.filter();
    }
}
