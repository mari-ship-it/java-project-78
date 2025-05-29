package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;

public class NumberSchemaTest {

    NumberSchema schema;

    @BeforeEach
    public void beforeEach() {
        Validator validator = new Validator();
        schema = validator.number();
    }
}
