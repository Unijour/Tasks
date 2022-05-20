import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        FileReader readerTests = new FileReader("tests.json");
        FileReader readerValues = new FileReader("values.json");

        TestsJSON tests = objectMapper.readValue(readerTests, TestsJSON.class);
        ValuesJSON values = objectMapper.readValue(readerValues, ValuesJSON.class);

        FillingValues(tests.getTests(), values.getValues());

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("report.json"), tests);

        readerTests.close();
        readerValues.close();
    }

    public static void FillingValues(ArrayList<Tests> tests, ArrayList<Values> values) {

        for (int i=0; i<tests.size(); i++) {
            for (int j=0; j<values.size(); j++) {
                if (tests.get(i).getId() == values.get(j).getId()) {
                    tests.get(i).setValue(values.get(j).getValue());
                }
            }
            if (tests.get(i).getValues() != null) {
                FillingValues(tests.get(i).getValues(), values);
            }
        }

    }
}
