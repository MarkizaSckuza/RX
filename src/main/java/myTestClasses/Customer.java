package myTestClasses;

import rx.Observable;
import rx.Subscriber;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Margo on 11.10.2015.
 */
public class Customer {

    private String name;
    private int age;

    private Set<Subscriber<? super Integer>> subscribers;
    private Observable<Integer> observable;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
//        subscribers = new HashSet<>();
//        observable = Observable.create(s -> subscribers.add(s));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
//        subscribers.forEach(s -> s.onNext(age));
    }

    public Observable<Integer> getObservable() {
        return observable;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
