package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LocalizationServiceTests {
    @MethodSource
    @ParameterizedTest
    public void testLocale(Country country, String expected) {
        //arrange
        LocalizationService localizationService = new LocalizationServiceImpl();

        //act
        String result = localizationService.locale(country);

        //assert
        Assertions.assertEquals(expected, result);
    }

    public Stream<Arguments> testLocale() {
        return Stream.of(
                Arguments.of(Country.RUSSIA, "Добро пожаловать"),
                Arguments.of(Country.USA, "Welcome"),
                Arguments.of(Country.BRAZIL, "Welcome"),
                Arguments.of(Country.GERMANY, "Welcome")
        );
    }
}
