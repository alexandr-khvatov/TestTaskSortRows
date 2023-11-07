package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Позволяет извлечь подстроки из строки
 */

public class FeatureExtractor {

    /**
     * Позволяет разбить строку на подстроки следующим образом:
     * выделяем непрерывные максимальные фрагменты строки, состоящие только из цифр,
     * и считаем набором подстрок эти фрагменты и все оставшиеся от такого разбиения фрагменты строки
     *
     * @param str строка, которую необходимо разбить на подстроки
     * @return возвращает список подстрок
     */
    public static List<Feature> extract(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Не должно быть null или пустым!");
        }

        var chars = str.toCharArray();
        var features = new ArrayList<Feature>();
        var featureLength = 0;
        String feature;
        var i = 0;
        while (i < chars.length) {
            if (Character.isDigit(chars[i])) {
                featureLength++;

                while (++i < chars.length && Character.isDigit(chars[i])) {
                    featureLength++;
                }
                feature = str.substring(i - featureLength, i);
                features.add(new Feature(feature, true));
                featureLength = 0;
            } else {
                featureLength++;

                while (++i < chars.length && !Character.isDigit(chars[i])) {
                    featureLength++;
                }
                feature = str.substring(i - featureLength, i);
                features.add(new Feature(feature, false));
                featureLength = 0;
            }
        }
        return features;
    }
}
