package menu.repository;

import menu.model.Coach;
import menu.model.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class CoachRepository {
    private static CoachRepository coachRepository;
    private final List<Coach> coaches;

    private CoachRepository() {
        this.coaches = new ArrayList<>();
    }

    // 싱글톤 패턴 적용 -> 데이터를 메모리상에 저장하기 위해 사용
    public static CoachRepository getInstance() {
        if(coachRepository == null) {
            synchronized(CoachRepository.class)
            {
                coachRepository = new CoachRepository();
            }
        }
        return coachRepository;
    }

    /**
     * 코치 저장
     * @param name
     */
    public void addCoach(String name, List<Menu> hateMenus ) {
        this.coaches.add(new Coach(name, hateMenus));
    }

    public List<Coach> findAll() {
        return coaches;
    }
}