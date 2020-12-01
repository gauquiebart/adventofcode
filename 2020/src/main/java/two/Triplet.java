package two;

import java.util.Objects;

public class Triplet<T> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triplet<?> triplet = (Triplet<?>) o;
        return Objects.equals(a, triplet.a) &&
                Objects.equals(b, triplet.b) &&
                Objects.equals(c, triplet.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "Triplet{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
