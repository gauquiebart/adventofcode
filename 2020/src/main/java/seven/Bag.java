package seven;

import shared.ValueObject;

public class Bag extends ValueObject {

    private final String description;

    private Bag(String description) {
        this.description = description;
    }

    public static Bag of(String description) {
        return new Bag(description);
    }

}
