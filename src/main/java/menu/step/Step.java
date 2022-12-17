package menu.step;

public interface Step {

    boolean executable();

    Step execute();
}
