package collections.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = Stream.of("Minsk", "Moscow", "Madrid", "Milan", "Rio", "Gomel").toList();
        List<String> strings = new ArrayList(list);
        List<String> sorted = strings.stream()
                .filter(city -> city.length() % 2 != 0)
                .filter(city -> city.matches("^[Mm]"))
                .toList();



    }
    /**
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    Iterator<E> iterator();
    Object[] toArray();
    <T> T[] toArray(T[] a);
    boolean add(E e);
    boolean remove(Object o);
    boolean containsAll(Collection<?> c);
    boolean addAll(Collection<? extends E> c);
    boolean addAll(int index, Collection<? extends E> c);
    boolean removeAll(Collection<?> c);
    boolean retainAll(Collection<?> c);
    default void replaceAll(UnaryOperator<E> operator);
    default void sort(Comparator<? super E> c);
    void clear();
    boolean equals(Object o);
    int hashCode();
    E get(int index);
    E set(int index, E element);
    void add(int index, E element);
    E remove(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    ListIterator<E> listIterator();
    ListIterator<E> listIterator(int index);
    List<E> subList(int fromIndex, int toIndex);
    default Spliterator<E> spliterator();
    static <E> List<E> of(E... elements);
    static <E> List<E> copyOf(Collection<? extends E> coll);
     **/
}
