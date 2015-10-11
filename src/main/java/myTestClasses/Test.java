package myTestClasses;


/**
 * Created by Margo on 11.10.2015.
 */
public class Test {
    public static int count = 0;
    public static void main(String[] args) {
        Customer customer = new Customer("Margo", 1);
        customer.getObservable()
                .buffer(3, 1)
                .subscribe(buffer -> {
                    int i1 = buffer.indexOf(10);
                    int i2 = buffer.indexOf(20);
                    if (i1 != -1 && i1 < i2) {
                        System.out.println("Catch it!");
                    }
                });

        customer.setAge(10);
        customer.setAge(20);
        customer.setAge(20);

        customer.setAge(5);
        customer.setAge(20);
    }
}
