package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GeoServiceTests {
    @MethodSource
    @ParameterizedTest
    public void testByIp(String ip, Location expected) {
        //arrange
        GeoService geoService = new GeoServiceImpl();

        //act
        Location result = geoService.byIp(ip);

        //assert
        Assertions.assertEquals(expected, result);
    }

    public Stream<Arguments> testByIp() {
        return Stream.of(
                Arguments.of("127.0.0.1", new Location(null, null, null, 0)),
                Arguments.of("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Arguments.of("172.10.132.12", new Location("Moscow", Country.RUSSIA, null, 0)),
                Arguments.of("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32)),
                Arguments.of("96.144.83.150", new Location("New York", Country.USA, null, 0)),
                Arguments.of("123334", null)
        );
    }
}
