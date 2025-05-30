package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {

    MapSchema schema;

    @BeforeEach
    public void beforeEach() {
        Validator validator = new Validator();
        schema = validator.map();
    }

    @Test
    public void requiredTest() {

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));

        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
    }

    @Test
    public void sizeofTest() {

        schema.sizeof(2);

        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid(new HashMap<>()));

        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertFalse(schema.isValid(data));

        data.put("key2", "value2");
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(data));
    }

    @Test
    public void setOfChecksTest() {

        schema.required().sizeof(1);

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(new HashMap<>()));

        var data = new HashMap<String, Integer>();
        data.put("key1", 1);
        assertTrue(schema.isValid(data));

        data.put("key2", 2);
        assertFalse(schema.isValid(data));
    }
}
