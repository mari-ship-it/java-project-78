package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {

    private final Map<String, Predicate<T>> validations = new HashMap<>();

    protected void addValidation(String name, Predicate<T> validation) {
        validations.put(name, validation);
    }

    public boolean isValid(T obj) {

        if (validations.containsKey("required") && obj == null) {
            return false;
        }
        if (obj == null) {
            return true;
        }
        return validations.values().stream().allMatch(entry -> entry.test(obj));
    }
}
