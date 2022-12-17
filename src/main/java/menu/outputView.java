package menu;

import java.util.ArrayList;
import java.util.List;
import menu.domain.DataRows;

public class OutputView {
    public void printStartComment(){
        System.out.println(MessageFormat.START_COMMENT.getMessage());
    }
    public void printError(String errorMessage) {
        System.out.println(String.format(MessageFormat.ERROR_MESSAGE_FORMAT.getMessage(),errorMessage));
    }

    public void printRecommendResult(DataRows dataRows) {
        System.out.println(MessageFormat.RESULT_HEADER_COMMENT.getMessage());
        dataRows.getMenusForCouches().forEach((dataRow) -> System.out.println(getFormattedRow(dataRow.getHeader(), dataRow.getValues())));

        System.out.println();
        System.out.println(MessageFormat.RESULT_END_COMMENT.getMessage());
    }

    private String getFormattedRow(String header, List<String> values) {
        List<String> row = new ArrayList<>(List.of(header));
        row.addAll(values);

        return String.format(MessageFormat.RESULT_DATA_FORMAT.getMessage(),
                String.join(MessageFormat.DATA_PARSER.getMessage(), row));
    }


}
