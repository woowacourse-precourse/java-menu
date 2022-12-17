package menu.domain.enums;

import static menu.domain.enums.Menu.BAGUETTE;
import static menu.domain.enums.Menu.BANMI;
import static menu.domain.enums.Menu.BIBIMBAP;
import static menu.domain.enums.Menu.BULGOGI;
import static menu.domain.enums.Menu.BUNCHA;
import static menu.domain.enums.Menu.DOENJANG_STEW;
import static menu.domain.enums.Menu.DONGPAYUK;
import static menu.domain.enums.Menu.FRENCH_TOAST;
import static menu.domain.enums.Menu.GIMBAP;
import static menu.domain.enums.Menu.GRATIN;
import static menu.domain.enums.Menu.GYUDON;
import static menu.domain.enums.Menu.HIGHRICE;
import static menu.domain.enums.Menu.JAJANGMYEON;
import static menu.domain.enums.Menu.JJAMPPONG;
import static menu.domain.enums.Menu.KALGUKSU;
import static menu.domain.enums.Menu.KAOPOD;
import static menu.domain.enums.Menu.KATSU_DONG;
import static menu.domain.enums.Menu.KIMCHI_STEW;
import static menu.domain.enums.Menu.KISHU;
import static menu.domain.enums.Menu.KKANPUNGGI;
import static menu.domain.enums.Menu.LASAGNA;
import static menu.domain.enums.Menu.MAPA_TOFU;
import static menu.domain.enums.Menu.MISOSORU;
import static menu.domain.enums.Menu.NASIGORENG;
import static menu.domain.enums.Menu.NYOKI;
import static menu.domain.enums.Menu.OKONOMIYAKI;
import static menu.domain.enums.Menu.ONIGIRI;
import static menu.domain.enums.Menu.PADTHAI;
import static menu.domain.enums.Menu.PANINI;
import static menu.domain.enums.Menu.PINEAPPLE_FRIED_RICE;
import static menu.domain.enums.Menu.PIZZA;
import static menu.domain.enums.Menu.RAMEN;
import static menu.domain.enums.Menu.RED_PEPPER_JAPCHAE;
import static menu.domain.enums.Menu.RICE_NOODLES;
import static menu.domain.enums.Menu.SPAGHETTI;
import static menu.domain.enums.Menu.SSAMBAP;
import static menu.domain.enums.Menu.STIRFRIED_PORK;
import static menu.domain.enums.Menu.STIR_FRIED_NOODLES;
import static menu.domain.enums.Menu.SUSHI;
import static menu.domain.enums.Menu.TANGSUYUK;
import static menu.domain.enums.Menu.TOMATO_EGG_STIR_FRIED;
import static menu.domain.enums.Menu.TOMYUMKUNG;
import static menu.domain.enums.Menu.TTEOKBOKKI;
import static menu.domain.enums.Menu.UDON;
import static menu.domain.enums.Menu.VIETNAMESE_SPRING_ROLLS;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Category {
    JAPANESE(1, "일식", List.of(GYUDON, UDON, MISOSORU, SUSHI, KATSU_DONG, ONIGIRI, HIGHRICE, RAMEN, OKONOMIYAKI)),
    KOREAN(2, "한식", List.of(GIMBAP, KIMCHI_STEW, SSAMBAP, DOENJANG_STEW, BIBIMBAP, KALGUKSU, BULGOGI, TTEOKBOKKI,
            STIRFRIED_PORK)),
    CHINESE(3, "중식", List.of(KKANPUNGGI, STIR_FRIED_NOODLES, DONGPAYUK, JAJANGMYEON, JJAMPPONG, MAPA_TOFU, TANGSUYUK,
            TOMATO_EGG_STIR_FRIED, RED_PEPPER_JAPCHAE)),
    ASIAN(4, "아시안", List.of(PADTHAI, KAOPOD, NASIGORENG, PINEAPPLE_FRIED_RICE, RICE_NOODLES, TOMYUMKUNG, BANMI,
            VIETNAMESE_SPRING_ROLLS, BUNCHA)),
    WESTERN(5, "양식", List.of(LASAGNA, GRATIN, NYOKI, KISHU, FRENCH_TOAST, BAGUETTE, SPAGHETTI, PIZZA, PANINI));

    private final int number;
    private final String name;
    private final List<Menu> menus;

    Category(final int number, final String name, final List<Menu> menus) {
        this.number = number;
        this.name = name;
        this.menus = menus;
    }

    public static Category get(final int day) {
        return Arrays.stream(values())
                .filter(category -> category.number == day)
                .findFirst()
                .get();
    }

    public boolean contains(final int day) {
        return number == day;
    }

    public List<Menu> getMenuList() {
        return Collections.unmodifiableList(menus);
    }
}
