package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FeatureExtractorTest {

    @ParameterizedTest
    @EmptySource
    void extract_shouldThrowException_whenPassInputIsEmpty(String input) {
        var ex = assertThrows(IllegalArgumentException.class, () -> FeatureExtractor.extract(input));
        assertEquals("Не должно быть null или пустым!", ex.getMessage());
    }

    @ParameterizedTest
    @NullSource
    void extract_shouldThrowException_whenPassInputIsNull(String input) {
        var ex = assertThrows(IllegalArgumentException.class, () -> FeatureExtractor.extract(input));
        assertEquals("Не должно быть null или пустым!", ex.getMessage());
    }

    @ParameterizedTest()
    @MethodSource("getArgumentsForExtract")
    void extract_shouldExtractSubString_whenSuccess(String str, List<Feature> expected) {
        var actual = FeatureExtractor.extract(str);
        Assertions.assertIterableEquals(expected, actual);
    }

    static Stream<Arguments> getArgumentsForExtract() {
        return Stream.of(
                Arguments.of("1", List.of(new Feature("1", true))),
                Arguments.of("ч", List.of(new Feature("ч", false))),
                Arguments.of("1xxx111", List.of(new Feature("1", true), new Feature("xxx", false), new Feature("111", true))),
                Arguments.of("x111x", List.of(new Feature("x", false), new Feature("111", true), new Feature("x", false)))
        );
    }
}
