//package constant;
//
//import java.util.Arrays;
//
//public enum Food {
//    // 일식
//    GYUDONG("1", Category.JAPAN_FOOD),
//    UDONG("1", Category.JAPAN_FOOD),
//    MISOSIRRO("1", Category.JAPAN_FOOD),
//    SUSHI("1", Category.JAPAN_FOOD),
//    GATSDONG("1", Category.JAPAN_FOOD),
//    ONIGIRI("1", Category.JAPAN_FOOD),
//    ONIGIRI("1", Category.JAPAN_FOOD),
//    HIRICE("1", Category.JAPAN_FOOD),
//    RAMEN("1", Category.JAPAN_FOOD),
//    OKONOMIYAKI("1", Category.JAPAN_FOOD),
//
//    // 한식
//    GIMBAB("1", Category.JAPAN_FOOD),
//    KIMCHI_JJIGAE("1", Category.JAPAN_FOOD),
//    SSAMBAB("1", Category.JAPAN_FOOD),
//    BIBIMBAB("1", Category.JAPAN_FOOD),
//    KOREAN_NOODLE("1", Category.JAPAN_FOOD),
//    BULGOGI("1", Category.JAPAN_FOOD),
//    DDOEBOKKI("1", Category.JAPAN_FOOD),
//    JAEYUK_BOGGUEM("1", Category.JAPAN_FOOD),
//
//
//    public static Food, Category
//
//    getMenuByName(String input) {
//        return Arrays.stream(Menu.values())
//                .filter(command -> command.menuCommand.equals(input))
//                .findAny()
//                .orElseThrow(() -> new IllegalArgumentException("정확한 메뉴 번호를 입력하세요."));
//    }
//}
