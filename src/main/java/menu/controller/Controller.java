package menu.controller;

import menu.domain.MenuRecommendation;
import menu.domain.Status;
import menu.dto.input.ReadNamesDto;
import menu.dto.output.PrintExceptionDto;
import menu.view.IOViewResolver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class Controller {
    private final IOViewResolver ioViewResolver;
    private final Map<Status, Supplier<Status>> statusMap;
    private MenuRecommendation menuRecommendation;


    public Controller(IOViewResolver ioViewResolver) {
        this.ioViewResolver = ioViewResolver;
        this.statusMap = new EnumMap<>(Status.class);
        initStatusMap();
    }

    private void initStatusMap() {
        statusMap.put(Status.READ_NAMES, this::readNames);
    }

    public Status run(Status status) {
        try {
            return statusMap.get(status).get();
        } catch (IllegalArgumentException exception) {
            ioViewResolver.outputViewResolve(new PrintExceptionDto(exception));
            return status;
        }
    }

    private Status readNames() {
        ReadNamesDto readNamesDto = ioViewResolver.inputViewResolve(ReadNamesDto.class);
        menuRecommendation = new MenuRecommendation(readNamesDto.getUserInput());
        return null;
    }
}
