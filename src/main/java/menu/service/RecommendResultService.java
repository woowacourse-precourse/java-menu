package menu.service;

import menu.model.RecommendResult;
import menu.repository.RecommendResultRepository;

import java.util.List;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class RecommendResultService {
    private final RecommendResultRepository recommendResultRepository;

    public RecommendResultService() {
        this.recommendResultRepository = RecommendResultRepository.getInstance();
    }

    public List<RecommendResult> findAll() {
        return recommendResultRepository.findAll();
    }

    public void save(RecommendResult recommendResult) {
        recommendResultRepository.save(recommendResult);
    }
}
