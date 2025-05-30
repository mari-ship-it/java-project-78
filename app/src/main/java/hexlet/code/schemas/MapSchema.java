package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        addValidation("required", map -> map.size() >= 0);
        return this;

    }

    public MapSchema sizeof(int length) {
        addValidation("sizeof", map -> map.size() == length);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {

        addValidation("shape", map -> {
            return schemas.entrySet().stream().allMatch(entry ->
                    entry.getValue().isValid((T) map.get(entry.getKey())));
        });
        return this;
    }
}
