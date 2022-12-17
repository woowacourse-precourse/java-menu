package menu;

import java.util.List;

public class Controller {
    MessageView messageView = new MessageView();
    InputView inputView = new InputView();
    public void run(){
        messageView.serviceStartMessage();
        coachName();
    }
    public void coachName(){
        messageView.coachNameMessage();
        List<String> name = inputView.coachNameInput();
    }
}
