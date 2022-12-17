package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class GenerateRandomNumber {
    private List<String> randomNumbers;

    public GenerateRandomNumber() {
        randomNumbers = new ArrayList<>();
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 5);
    }

    public List<String> getRandomNumbers()
    {
        return randomNumbers;
    }
    public void setRandomNumbers(){
        while (randomNumbers.size() < 5)
        {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 5));
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
            checkNumbers(randomNumber);
        }
    }
    public void checkNumbers(String randomNumber){
        int count = (int) randomNumbers.stream().filter(w->w.contains(randomNumber)).count();
        if (randomNumbers.size() == 4)
        {
            return;
        }
        if(count >= 2)
        {
            return;
        }
    }
}
