package menu.domain.service;

import java.util.List;

public interface MenuStrategy {
    List<String> generate(List<String> menuNames);
}
