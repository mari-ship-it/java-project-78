package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        addValidation("required", map -> map.size() >= 0);
        return this;
    }

    public MapSchema sizeof(int num) {
        addValidation("sizeof", map -> map.size() == num);
        return this;
    }
}
