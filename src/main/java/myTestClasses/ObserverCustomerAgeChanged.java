package myTestClasses;

import rx.Observable;
import rx.Observer;

/**
 * Created by Margo on 13.10.2015.
 */
public class ObserverCustomerAgeChanged<Integer> implements Observer<Integer> {

    Observable<Integer> observable;

    public ObserverCustomerAgeChanged(Observable<Integer> observable) {
        this.observable = observable;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(Integer age) {
        observable.buffer(3,1).subscribe(buffer -> {
            System.out.println(Thread.currentThread().getName() + "::: " + buffer.get(0));
                    int i1 = buffer.indexOf(10);
                    int i2 = buffer.indexOf(20);
                    if (i1 != -1 && i1 < i2) {
                        System.out.println("Catch it!");
                    }
                });
    }
}
