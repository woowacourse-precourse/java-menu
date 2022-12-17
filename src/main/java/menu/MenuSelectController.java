package menu;

public class MenuSelectController {
    InputDriver inputDriver = new InputDriver();
    OutputDriver outputDriver = new OutputDriver();
    CoachRepo coachRepo = new CoachRepo();

    public void start() {
        outputDriver.printStartMessage();
        scanCoachName();
        setCoachCannotEatMenu();
        MenuSelectListMaker menuSelectListMaker = new MenuSelectListMaker(coachRepo);
        outputDriver.printResult(menuSelectListMaker.menuListStringReturn());
    }

    private void scanCoachName() {
        outputDriver.printScanCoachName();
        try{
            coachRepo.setCoachList(inputDriver.scanCoachName());
        }
        catch(IllegalArgumentException e){
            System.out.println();
            scanCoachName();
        }
    }

    private void setCoachCannotEatMenu() {
        for (Coach coach : coachRepo.coachList){
            setCoachCannotEatMenuForOneCoach(coach);
        }
    }

    private void setCoachCannotEatMenuForOneCoach(Coach coach) {
        outputDriver.printScanCannotEatMenuMessage(coach.name);
        try{
            coachRepo.setCoachCannotEatMenu(coach.name,inputDriver.scanCannotEatMenu());
        }
        catch (IllegalArgumentException e){
            setCoachCannotEatMenuForOneCoach(coach);
        }
    }
}
