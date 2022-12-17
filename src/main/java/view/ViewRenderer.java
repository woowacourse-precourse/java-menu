package view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import dto.RecommendationResponseDto;

public class ViewRenderer {
    private static final String START = "[ ";
    private static final String END = " ]";
    private static final String DIVISION_LINE = " | ";
    private static final String LINE_BREAK_CHARACTER = "\n";

    public String render(RecommendationResponseDto recommendationResponseDto) {
        StringBuilder sb = new StringBuilder();
        String[] header = new String[] {"구분", "월요일", "화요일", "수요일", "목요일", "금요일"};
        sb.append(makeTable(Arrays.stream(header).collect(Collectors.toList())));
        recommendationResponseDto.getRecommendation().forEach(x -> sb.append(makeTable(x)));
        return sb.toString();
    }

    private String makeTable(List<String> item) {
        StringBuilder sb = new StringBuilder();
        sb.append(START);
        sb.append(item.get(0));
        for (int i = 1; i < item.size(); i++) {
            sb.append(DIVISION_LINE);
            sb.append(item.get(i));
        }
        sb.append(END);
        sb.append(LINE_BREAK_CHARACTER);
        return sb.toString();
    }
}
