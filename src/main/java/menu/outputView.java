package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Day;
import menu.domain.DataRows;

public class outputView {

    public void printError(String errorMessage) {
        System.out.println(MessageFormat.ERROR_MESSAGE_FORMAT.getMessage() + errorMessage);
    }

    public void printRecommendResult(DataRows dataRows) {
        System.out.println(MessageFormat.RESULT_HEADER_COMMENT.getMessage());
        dataRows.getMenusForCouches().forEach((dataRow) -> getFormattedRow(dataRow.getHeader(), dataRow.getValues()));
        System.out.println(MessageFormat.RESULT_END_COMMENT.getMessage());

    }

    private String getFormattedRow(String header, List<String> values) {
        List<String> row = new ArrayList<>(List.of(header));
        values.forEach((value) -> row.add(value));

        return String.format(MessageFormat.RESULT_DATA_FORMAT.getMessage(),
                String.join(MessageFormat.DATA_PARSER.getMessage(), row));
    }


}
