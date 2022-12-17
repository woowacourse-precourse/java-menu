package menu;


public class Controller {
	Service service = new Service();
	OutputView outputView = new OutputView();

	public void run() {
		outputView.startMessage();
		service.programSetting();
		service.recommendProgram();
	}
}
