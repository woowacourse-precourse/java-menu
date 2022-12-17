package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coaches {
	private List<String> names;

	public Coaches(List<String> names) {
		this.names = names;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
}
