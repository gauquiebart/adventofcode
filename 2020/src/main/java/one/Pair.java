package one;

import shared.ValueObject;

class Pair<T> extends ValueObject {

    private final T l;
    private final T r;

    private Pair(T l, T r) {
        this.l = l;
        this.r = r;
    }

    static <T> Pair<T> of(T l, T r) {
        return new Pair(l, r);
    }

    T l() {
        return l;
    }

    T r() {
        return r;
    }

}
