package menu.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class DataRows {

    List<DataRow> dataRows;

    public DataRows(List<DataRow> dataRows) {
        this.dataRows = dataRows;
    }

    public List<DataRow> getMenusForCouches() {
        return Collections.unmodifiableList(dataRows);
    }
}
