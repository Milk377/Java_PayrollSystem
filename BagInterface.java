public interface BagInterface<T> {


    public int getCurrentSize();
    public boolean isEmpty();
    public boolean add(T newEntry);
    public T removeLastOne();
    public T remove (T anEntry);
    public void clear();
    public int getFrequencyOF(T anEntry);
    public boolean contains(T anEntry);
    public T[] toArray();

}
