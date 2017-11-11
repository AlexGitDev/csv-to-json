package test;

import com.dmwh.transformer.csvtojson.CsvToJson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class CsvToJson_Test {
    private static final File CSV_FILE  = new File("src/test/resources/client_file.csv");
    //
    CsvToJson transformer;

    @Before
    public void setUp() throws Exception {
        transformer = new CsvToJson();
    }

    @After
    public void tearDown() throws Exception {
        //
    }

    @Test
    public void transform_Test() throws Throwable {
        byte[] data = Files.readAllBytes(CSV_FILE.toPath());
        //
        byte[] result = transformer.transform(data);
        System.out.println(new JSONArray(new String(result)).toString(4));
        assertNotNull("Transformation failed",result);
    }
}
