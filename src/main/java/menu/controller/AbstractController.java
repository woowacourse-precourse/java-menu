package menu.controller;

public abstract class AbstractController implements Controller {
    @Override
    public void process() {
        try {
            doProcess();
        } catch (IllegalArgumentException e) {

            process();
        }
    }

    public abstract void doProcess();
}
