package com.development.earthquakes.base;


import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

public class BasePresenter<T> {

    private T view;

    @CallSuper
    public void onViewAttached(@NonNull final T view) {
        if (isViewAttached()) {
            throw new IllegalStateException(
                    "View " + this.view + " is already attached. Cannot attach " + view);
        }
        this.view = view;
    }

    @CallSuper
    public void onViewDetached() {
        if (!isViewAttached()) {
            throw new IllegalStateException("View is already detached");
        }
        view = null;
    }

    public boolean isViewAttached() {
        return this.view != null;
    }

    public T getView() {
        return view;
    }
}
