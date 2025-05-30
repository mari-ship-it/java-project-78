package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {

    NumberSchema schema;

    @BeforeEach
    void beforeEach() {
        Validator validator = new Validator();
        schema = validator.number();
    }

    @Test
    void requiredTest() {

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(-1));
        assertTrue(schema.isValid(0));
        assertTrue(schema.isValid(1));
    }

    @Test
    void positiveTest() {

        schema.positive();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(1));
        assertFalse(schema.isValid(-1));
        assertFalse(schema.isValid(0));
    }

    @Test
    void rangeTest() {

        schema.renge(5, 10);

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }

    @Test
    void setOfChecksTest() {

        schema.required().positive().renge(-1, 8);

        assertTrue(schema.isValid(1));
        assertTrue(schema.isValid(8));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(0));
        assertFalse(schema.isValid(-1));
        assertFalse(schema.isValid(9));
    }
}
