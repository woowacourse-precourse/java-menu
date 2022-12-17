package menu.IO;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    final int minNamelength = 2;
    final int maxNamelength = 4;
    public List<String> readCoachNames(){
        String names = Console.readLine();
        StringTokenizer tokenizer=new StringTokenizer(names, ",");

        List<String> coachNames = new ArrayList<>();
        while(tokenizer.hasMoreTokens()){
            String coachName = tokenizer.nextToken();
            if(!(minNamelength<=coachName.length()&&coachName.length()<=maxNamelength))
                throw new IllegalArgumentException("[ERROR] 사용자 이름은 2~4글자여야 합니다.");
            coachNames.add(coachName);
        }

        return coachNames;
    }
}
