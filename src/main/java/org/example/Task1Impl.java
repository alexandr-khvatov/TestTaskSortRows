package org.example;

import java.util.Comparator;
import java.util.List;

/**
 * <h1>Задание №1</h1>
 * Реализуйте интерфейс {@link IStringRowsListSorter}.
 *
 * <p>Мы будем обращать внимание в первую очередь на структуру кода и владение стандартными средствами java.</p>
 */
public class Task1Impl implements IStringRowsListSorter {

    // ваша реализация должна работать, как singleton. даже при использовании из нескольких потоков.
    public static final IStringRowsListSorter INSTANCE = new Task1Impl(RowsComparator.emptyFirst(new FeatureListComparator()));

    private final RowsComparator comparator;

    private Task1Impl(RowsComparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(final List<String[]> rows, final int columnIndex) {
        rows.sort(Comparator.comparing(x -> x[columnIndex], Comparator.nullsFirst(comparator)));
    }
}
