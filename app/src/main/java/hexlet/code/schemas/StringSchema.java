package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {

        addValidation("required", str -> str != null && !str.isEmpty());
        return this;
    }

    public StringSchema minLength(int size) {

        addValidation("minLength", str -> str == null || str.isEmpty() || str.length() >= size);
        return this;
    }

    public StringSchema contains(String substring) {

        addValidation("contains", str -> str.contains(substring) || str.isEmpty() || str == null);
        return this;
    }
}
