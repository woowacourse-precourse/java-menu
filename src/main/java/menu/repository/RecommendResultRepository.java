package menu.repository;

import menu.model.Menu;
import menu.model.RecommendResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class RecommendResultRepository {
    private static RecommendResultRepository recommendResultRepository;
    private final List<RecommendResult> recommendResults;

    private RecommendResultRepository() {
        this.recommendResults = new ArrayList<>();
    }

    // 싱글톤 패턴 적용 -> 데이터를 메모리상에 저장하기 위해 사용
    public static RecommendResultRepository getInstance() {
        if(recommendResultRepository == null) {
            synchronized(MenuRepository.class)
            {
                recommendResultRepository = new RecommendResultRepository();
            }
        }
        return recommendResultRepository;
    }

    public void addResults() {

    }

    public List<RecommendResult> getResult() {
        return recommendResults;
    }
}
