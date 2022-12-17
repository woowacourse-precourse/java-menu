package menu.utils.constants;

public enum NumberConstants {

    DAYS_COUNT(5),
    MAX_BAN_FOOD_LIST(3),
    MAX_CREW_LIST(5),
    MIN_CREW_LIST(2);

    private final int value;

    NumberConstants(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
