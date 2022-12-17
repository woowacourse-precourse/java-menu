package menu.exception;

public class CannotRecommendCategoryException extends RuntimeException {

    public CannotRecommendCategoryException() {
        super("[ERROR] 같은 카테고리가 3개 이상입니다.");
    }
}
