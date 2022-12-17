package menu.ui.input.exceptions;

import menu.ui.input.Repetitor;

public class CoachList extends Repetitor {
    private static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 코치의 이름 길이는 2 ~ 4글자여야 합니다";
    private static final String COACH_NUMBER_ERROR_MESSAGE = "[ERROR] 코치의 수는 2 ~ 5명이어야 합니다";
    private static final String COMMA = ",";
    private static final int MIN_LENGTH_RANGE = 2;
    private static final int MAX_LENGTH_RANGE = 4;
    private static final int MIN_COACH_NUMBER = 2;
    private static final int MAX_COACH_NUMBER = 5;
    @Override
    protected String checkInputException(String input) throws IllegalArgumentException {
        Shared shared = new Shared();
        shared.sharedExceptionChecking(input);
        checkCoachNumber(input);
        checkAllCoach(input);

        return input;
    }

    private void checkAllCoach(String input) throws IllegalArgumentException {
        String[] coaches = input.split(COMMA);

        for (String coach : coaches) {
            checkLength(coach);
        }
    }

    private void checkLength(String coach) throws IllegalArgumentException {
        int length = coach.length();
        if (!(length >= MIN_LENGTH_RANGE && length <= MAX_LENGTH_RANGE)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void checkCoachNumber(String input) throws IllegalArgumentException {
        int coachNumber = input.split(COMMA).length;
        if (!(coachNumber >= MIN_COACH_NUMBER && coachNumber <= MAX_COACH_NUMBER)) {
            throw new IllegalArgumentException(COACH_NUMBER_ERROR_MESSAGE);
        }
    }
}
