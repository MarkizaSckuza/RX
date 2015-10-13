package myTestClasses;


import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * Created by Margo on 11.10.2015.
 */
public class Test {

    public static void main(String[] args) {

        Customer customer = new Customer("Margo", 1);

        Observable<Integer> observable2 = Observable
                .create(subscriber -> {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String line;
                    try {
                        while ((line = reader.readLine()) != null) {
                            int t = Integer.parseInt(line);
                            customer.setAge(t);
                                subscriber.onNext(Integer.parseInt(line));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
                .map(age -> customer.getAge());

        Observable<Integer> observable = Observable
                .interval(0, 1, TimeUnit.MICROSECONDS)
                .map(age -> customer.getAge());


        ObserverCustomerAgeChanged observerCustomer = new ObserverCustomerAgeChanged(observable);
        ObserverCustomerAgeChanged observerCustomer2 = new ObserverCustomerAgeChanged(observable2);
        observable.subscribe(observerCustomer);
        observable2.subscribe(observerCustomer2);


        customer.setAge(10);
        customer.setAge(20);
        customer.setAge(11);
        customer.setAge(22);
        customer.setAge(21);
        customer.setAge(2);
        customer.setAge(13);
        customer.setAge(10);
        customer.setAge(10);

        customer.setAge(5);
        customer.setAge(20);

        try {
            TimeUnit.SECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
