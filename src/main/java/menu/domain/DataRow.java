package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataRow {

    private final String header;
    private final List<String> values;
    private final List<String> row;


    public DataRow(String header, List<String> values) {
        this.header = header;
        this.values = Collections.unmodifiableList(values);

        this.row = new ArrayList<>(List.of(header));
        this.row.addAll(values);
    }

    public String getHeader() {
        return header;
    }

    public List<String> getRow() {
        return Collections.unmodifiableList(this.row);
    }
}
