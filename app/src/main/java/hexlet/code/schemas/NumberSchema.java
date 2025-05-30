package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addValidation("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addValidation("positive", obj -> obj > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addValidation("range", obj -> obj >= min && obj <= max);
        return this;
    }
}
