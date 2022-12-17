package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataRow {

    private final String header;
    private final List<String> values;


    public DataRow(String header, List<String> values) {
        this.header = header;
        this.values = Collections.unmodifiableList(values);
    }

    public String getHeader() {
        return header;
    }

    public List<String> getValues() {
        return Collections.unmodifiableList(values);
    }
}
