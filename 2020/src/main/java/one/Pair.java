package one;

import java.util.Objects;

class Pair<T> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?> pair = (Pair<?>) o;
        return Objects.equals(l, pair.l) &&
                Objects.equals(r, pair.r);
    }

    @Override
    public int hashCode() {
        return Objects.hash(l, r);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "l=" + l +
                ", r=" + r +
                '}';
    }
}
