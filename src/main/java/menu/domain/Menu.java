package menu.domain;public class Menu {    private final String name;    public Menu(String name) {        this.name = name;    }    @Override    public String toString() {        return this.name;    }}