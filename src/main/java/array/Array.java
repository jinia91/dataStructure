package array;

import java.util.Arrays;
import java.util.Objects;

public class Array <T> {
    private static final int DEFAULT_CAPACITY = 3;
    private static final Object[] DEFAULT_ELEMENT_DATA = {};

    private int arrayCapacity;
    private Object[] objects;
    private int size;

    public Array() {
        arrayCapacity = DEFAULT_CAPACITY;
        objects = DEFAULT_ELEMENT_DATA;
    }

    public Array(int capacity) {
        arrayCapacity = capacity;
        if (capacity > 0) {
            this.objects = new Object[capacity];
        } else if (capacity == 0) {
            this.objects = DEFAULT_ELEMENT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    public void add(T e) {
        int oldCapacity = objects.length;
        if (size == oldCapacity) {
            growCapacity(oldCapacity);
        }
        objects[size] = e;
        size++;
    }

    public void add(T e, int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        int oldCapacity = objects.length;
        if (size == oldCapacity) {
            growCapacity(oldCapacity);
        }
        System.out.println("인덱스 이후 배열 카피");
        System.arraycopy(objects, index,
                objects, index + 1,
                size - index);
        objects[index] = e;
        size++;
    }

    private void growCapacity(int oldCapacity) {
        if (oldCapacity > 0 || objects != DEFAULT_ELEMENT_DATA) {
            System.out.println("새로운 배열 생성");
            int newCapacity = oldCapacity + 1; // oom 핸들링등 생략 수도코드화
            objects = Arrays.copyOf(objects, newCapacity);
            arrayCapacity = newCapacity;
        } else {
            System.out.println("새로운 배열 생성");
            objects = new Object[Math.max(DEFAULT_CAPACITY, size)];
            arrayCapacity = objects.length;
        }
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        int newSize = size - 1;
        if (newSize > index) {
            System.out.println("당기기");
            System.arraycopy(objects, index + 1, objects, index, newSize - index);
        }
        objects[size = newSize] = null;
        arrayCapacity = objects.length;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) objects[index];
    }

    public int getSize() {
        return size;
    }

    public int getArrayCapacity() {
        return arrayCapacity;
    }
}
