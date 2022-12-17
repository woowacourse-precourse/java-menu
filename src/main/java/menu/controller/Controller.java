package menu.controller;

import menu.domain.MenuRecommendation;
import menu.domain.People;
import menu.domain.Status;
import menu.dto.input.ReadNamesDto;
import menu.dto.input.ReadUnavailableMenuDto;
import menu.dto.output.PrintCriticalExceptionDto;
import menu.dto.output.PrintExceptionDto;
import menu.dto.output.PrintRecommendationsDto;
import menu.util.StandardRandomGenerator;
import menu.view.IOViewResolver;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Controller {
    private final IOViewResolver ioViewResolver;
    private final Map<Status, Supplier<Status>> statusMap;
    private MenuRecommendation menuRecommendation;


    public Controller(IOViewResolver ioViewResolver, StandardRandomGenerator generator) {
        this.ioViewResolver = ioViewResolver;
        this.statusMap = new EnumMap<>(Status.class);
        initStatusMap(generator);
    }

    private void initStatusMap(StandardRandomGenerator generator) {
        statusMap.put(Status.READ_NAMES, this::readNames);
        statusMap.put(Status.READ_UNAVAILABLE_MENU, this::readUnavailableMenu);
        statusMap.put(Status.PRINT_RESULT, () -> printResult(generator));
    }

    public Status run(Status status) {
        try {
            return statusMap.get(status).get();
        } catch (IllegalArgumentException exception) {
            ioViewResolver.outputViewResolve(new PrintExceptionDto(exception));
            return status;
        } catch (Exception exception) {
            ioViewResolver.outputViewResolve(new PrintCriticalExceptionDto(exception));
            return Status.EXIT;
        }
    }

    private Status readNames() {
        ReadNamesDto readNamesDto = ioViewResolver.inputViewResolve(ReadNamesDto.class);
        menuRecommendation = new MenuRecommendation(readNamesDto.getUserInput());
        return Status.READ_UNAVAILABLE_MENU;
    }

    private Status readUnavailableMenu() {
        ReadUnavailableMenuDto readUnavailableMenuDto = ioViewResolver.inputViewResolve(ReadUnavailableMenuDto.class);
        menuRecommendation.addUnavailableMenus(readUnavailableMenuDto.getInputs());
        return Status.PRINT_RESULT;
    }

    private Status printResult(StandardRandomGenerator generator) {
        People result = menuRecommendation.getRecommendations(generator);
        List<String> shuffledCategory = menuRecommendation.getShuffledCategories();

        ioViewResolver.outputViewResolve(new PrintRecommendationsDto(result, shuffledCategory));
        return Status.EXIT;
    }
}
