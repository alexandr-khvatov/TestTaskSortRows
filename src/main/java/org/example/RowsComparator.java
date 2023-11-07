package org.example;

import java.util.Comparator;
import java.util.List;

public final class RowsComparator implements Comparator<String> {

    private final Comparator<List<Feature>> real;

    private RowsComparator(Comparator<List<Feature>> real) {
        this.real = real;
    }

    public static RowsComparator emptyFirst(Comparator<List<Feature>> real) {
        return new RowsComparator(real);
    }

    @Override
    public int compare(String first, String second) {
        if (first.isEmpty()) {
            return second.isEmpty() ? 0 : -1;
        } else if (second.isEmpty()) {
            return 1;
        } else {
            return (real == null) ? 0 : real.compare(FeatureExtractor.extract(first), FeatureExtractor.extract(second));
        }
    }
}
