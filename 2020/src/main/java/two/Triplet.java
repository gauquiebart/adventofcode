package two;

import shared.ValueObject;

public class Triplet<T> extends ValueObject {

    private final T a;
    private final T b;
    private final T c;

    private Triplet(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static <T> Triplet<T> of(T a, T b, T c){
        return new Triplet<>(a, b, c);
    }

    T a() {
        return a;
    }

    T b() {
        return b;
    }

    T c() {
        return c;
    }

}
