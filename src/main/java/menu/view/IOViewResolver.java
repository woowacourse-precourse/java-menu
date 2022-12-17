package menu.view;

import menu.dto.input.ReadNamesDto;
import menu.dto.input.ReadUnavailableMenuDto;
import menu.dto.output.PrintCriticalExceptionDto;
import menu.dto.output.PrintExceptionDto;
import menu.view.exception.NotFoundViewException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class IOViewResolver {
    private final Map<Class<?>, Supplier<Object>> inputViewMap = new HashMap<>();
    private final Map<Class<?>, Consumer<Object>> outputViewMap = new HashMap<>();

    public IOViewResolver(InputView inputView, OutputView outputView) {
        initInputViewMappings(inputView);
        initOutputViewMappings(outputView);
    }

    private void initInputViewMappings(InputView inputView) {
        inputViewMap.put(ReadNamesDto.class, inputView::readNames);
        inputViewMap.put(ReadUnavailableMenuDto.class, inputView::readUnavailableMenu);

    }

    private void initOutputViewMappings(OutputView outputView) {
//        outputViewMap.put(PrintVendingMachineCoinDto.class, dto -> outputView.printVendingMachineCoin((PrintVendingMachineCoinDto) dto));
        outputViewMap.put(PrintExceptionDto.class, dto -> outputView.printException((PrintExceptionDto) dto));
        outputViewMap.put(PrintCriticalExceptionDto.class, dto -> outputView.printCriticalException((PrintCriticalExceptionDto) dto));
    }

    public <T> T inputViewResolve(final Class<T> type) {
        try {
            return type.cast(inputViewMap.get(type).get());
        } catch (NullPointerException e) {
            throw new NotFoundViewException();
        }
    }

    public void outputViewResolve(final Object dto) {
        try {
            outputViewMap.get(dto.getClass()).accept(dto);
        } catch (NullPointerException e) {
            throw new NotFoundViewException();
        }
    }
}