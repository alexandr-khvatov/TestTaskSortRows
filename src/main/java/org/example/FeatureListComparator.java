package org.example;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Позволяет сравнивать строки представленные в виде списка подстрок обернутых в Feature
 *
 * @see Feature
 */
public final class FeatureListComparator implements Comparator<List<Feature>> {
    @Override
    public int compare(List<Feature> first, List<Feature> second) {
        Iterator<Feature> firstIt = first.iterator();
        Iterator<Feature> secondIt = second.iterator();
        while (firstIt.hasNext() && secondIt.hasNext()) {
            var feature1 = firstIt.next();
            var feature2 = secondIt.next();
            var compareResult = feature1.compareTo(feature2);
            if (compareResult != 0) {
                return compareResult;
            }
        }
        return 0;
    }
}
