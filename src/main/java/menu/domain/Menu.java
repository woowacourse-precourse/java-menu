package menu.domain;

public class Menu {

	private String name;

	public Menu(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean equals(Menu menu) {
		return this.name == menu.getName();
	}
}
