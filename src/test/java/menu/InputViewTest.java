package menu;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class InputViewTest {
	InputView iv = new InputView();
	static final String ERROR_MESSAGE = "[ERROR]";
	
	@ParameterizedTest
	@ValueSource(strings = {"안녕하세요", "ㅇ,"})
	public void checkCoachNameFormat(String coachNames) {
		assertThatThrownBy(() -> iv.checkCoachNameFormat(coachNames))
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessageContaining(ERROR_MESSAGE);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"안녕,ㄱㄴㄷㄹㅁ", "ㅁ,안녕하세요,삼사오육"})
	public void checkEachCoachNameLength(String coachNames) {
		assertThatThrownBy(() -> iv.checkEachCoachNameLength(coachNames))
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessageContaining(ERROR_MESSAGE);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"토미,제임스,포코,아린,상희,다희", "토미"})
	public void checkCoachNameLength(String coachNames) {
		String[] coachName = coachNames.split(",");
		assertThatThrownBy(() -> iv.checkCoachNameLength(coachName))
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessageContaining(ERROR_MESSAGE);
	}
}
