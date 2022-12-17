package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MemberTest {
    @DisplayName("멤버의수가 2인 보다 작은 경우 예외 발생")
    @Test
    void test1(){
        assertThatThrownBy(()->new Member(List.of("11"))).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("멤버의수가 5인 보다 큰 경우 예외 발생")
    @Test
    void test2(){
        assertThatThrownBy(()->new Member(List.of("11","22","33","44","55","66"))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("멤버의수가 올바른 경우")
    @Test
    void test3(){
       Member Member= new Member(List.of("11","22","33"));
    }


}
