package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import menu.utils.ErrorMessage;

public class Coaches {

	private final List<Coach> coaches;

	public Coaches(String coachNames) {
		List<String> names = validateNumberOfCoaches(coachNames);
		this.coaches = names.stream()
			.map(Coach::new)
			.collect(Collectors.toList());
	}

	public List<Coach> getCoaches() {
		return coaches;
	}

	private List<String> validateNumberOfCoaches(String coachNames) {
		String[] names = coachNames.split(",");
		if (names.length < 2 || names.length > 5) {
			throw new IllegalArgumentException(ErrorMessage.RANGE.getMessage());
		}
		return new ArrayList<>(List.of(names));
	}
}
