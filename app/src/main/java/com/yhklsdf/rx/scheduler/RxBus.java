package com.yhklsdf.rx.scheduler;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public final class RxBus {

    private final Subject<Object> bus;

    private RxBus() {
        // toSerialized method made bus thread safe
        bus = PublishSubject.create().toSerialized();
    }

    public static RxBus getInstance() {
        return Holder.BUS;
    }

    private static class Holder {
        private static final RxBus BUS = new RxBus();
    }

    public void post(Object obj) {
        bus.onNext(obj);
    }

    public <T> Observable<T> toObservable(Class<T> tClass) {
        return bus.ofType(tClass);
    }

    public Observable<Object> toObservable() {
        return bus;
    }

    public boolean hasObservers() {
        return bus.hasObservers();
    }
}

