package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
	List<String> coachsName = new ArrayList<>();

	public void setCoachsName(List<String> coachsName) {
		this.coachsName = coachsName;
	}

	public String getCoachsName(int index) {
		return coachsName.get(index);
	}
}
