import kotlin.reflect.jvm.internal.impl.util.Check;

public class ADTBag<T> implements BagInterface<T>{

    private T[] bag;
    private int currentSize;
    private static final int DEFAULT_SIZE = 50;
    private int MAX_SIZE;
    private boolean checkInitialize = false;

    public ADTBag() {
        T[] tempBag = (T[])new Object[DEFAULT_SIZE];

        MAX_SIZE = DEFAULT_SIZE;
        bag = tempBag;
        currentSize = 0;
        MAX_SIZE = DEFAULT_SIZE;
        checkInitialize = true;
    }

    public ADTBag(int _size) {
        @SuppressWarnings("Unchecked")
                T[] tempBag = (T[])new Object[_size];
        bag = tempBag;
        currentSize = 0;
        MAX_SIZE = _size;
        checkInitialize = true;


    }

    private boolean isArrayFull() {
        // -1 부터 시작하므로, cur 의 값이 max_size 보다 1 작을때, 꽉 찬 배열이다.
        // 0부터 시작하는걸로 바꿧다.
        if(currentSize == MAX_SIZE  ) return true;
        else if (currentSize >= 0 && currentSize < MAX_SIZE ) return false;
        else {
            System.out.printf("currentSize Error. check currentSize and MAX_SIZE");
            return false;
        }
    }

    public boolean CheckInitialization() {
        if(checkInitialize) return true;
        else return false;
    }


    public int getCurrentSize()
    {
        return currentSize;
    }


    public boolean isEmpty(){
        if(getCurrentSize() == 0) return true;
        else return false;
    };

    public boolean add(T _data)
    {
        boolean result = true;

        // 배열이 꽉 차있다면
        if(isArrayFull())
        {
            result = false;
        } else {
            bag[currentSize++] = _data;

        }
        return result;
    };

    //마지막 값을 제거
    //명시적으로 구현해봄.
    public T removeLastOne() {
        CheckInitialization();
        T result = null;
        if(currentSize > 0) {
            // 끝에 있는 값을 임시로 저장
            result = bag[currentSize -1];
            // bag 배열의 마지막 값을 NULL 로 지정
            bag[currentSize-1] = null;
            // 사이즈 줄이기
            currentSize--;
            // Max size는 줄이지 않아도 됨
            //
            }
        // 제거한 값을 리턴 ( Pop 의 느낌)
        return result;
    };

    // 특정 위치의 값을 제거
    // 특정 위치의 값을 제거하고, 맨 마지막 원소를 그 자리에 채운다.
    // Bag 이기 때문에 가능함.
    // 맨 마지막 원소를 제거하는것도 가능함.
    private T removeEntry (int _delIndex)
    {
        T result = null;
        if(!isEmpty() && (_delIndex >= 0)){
            result = bag[_delIndex];
            bag[_delIndex] = bag[currentSize -1];
            bag[currentSize -1] = null;
            currentSize--;

        }
        return result;
    };

//
//    public T remove()
//    {
//        CheckInitialization();
//        T result = removeEntry(currentSize-1);
//        return result;
//    }

    public T remove(T _data)
    {
        CheckInitialization();
        T result = null;
        for(int index = 0 ; index < currentSize ; index++)
        {
            if(bag[index].equals(_data))
            {
                result = bag[index];
                removeEntry(index);
            }
        }

        return result;
    }





    public void clear(){
        // 비어있지 않으면, 계속 반복한다.
        while (!isEmpty())
        {
            removeLastOne();
        }
    };


    public int getFrequencyOF(T _data)
    {
        CheckInitialization();
        int counter = 0;

        for(int index = 0 ; index < currentSize ; index ++)
        {
            if(_data.equals(bag[index]))
            {
                counter++;
            }
        }

        return counter;
    };

    public boolean contains(T _data)
    {
        CheckInitialization();
        boolean result = false;
        for(int index = 0 ; index < currentSize ; index ++)
        {
            if(_data.equals(bag[index])) result = true;
            else result = false;
        }

        return result;

    };

    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[currentSize];
        for (int index = 0; index < currentSize; index++) {
            result[index] = bag[index];
        }
        return result;

    };




}
