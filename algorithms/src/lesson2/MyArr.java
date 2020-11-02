package lesson2;

import java.util.Arrays;

public class MyArr<E extends Object & Comparable<? super E>> {
    private E[] arr;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArr(int size) {
        this.size = 0;
        this.arr =  (E[]) new Object[size];
    }

    public void display() {
        System.out.print("[ ");
        for(int i = 0; i < this.size; i++) {
            System.out.print(this.arr[i] + " ");
        }

        System.out.print("]");
        System.out.println();
    }

    public void delete(E value) {
        delete(indexOf(value));
    }

    public void delete(int index) {
        if (index > 0 && index < size) {
            if (this.size - 1 - index >= 0) {
                System.arraycopy(this.arr, index + 1, this.arr, index, this.size - 1 - index);
            }
            arr[--size] = null;
        }
    }

    public void insert(E value) {
        if (value != null && arr.length != size) {
            this.arr[this.size] = value;
            this.size++;
        } else {
            System.out.println("Превышен размер массива");
        }
    }

    public boolean contains(E value) {
        return indexOf(value) != -1;
    }
    public int indexOf(E value) {
        if (value == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public void sortBubble(){
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    change(j, j + 1);
                }
            }
        }
    }

    private void change(int index1, int index2){
        E tmp = this.arr[index1];
        this.arr[index1] = this.arr[index2];
        this.arr[index2] = tmp;
    }

    public void sortSelect(){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size - 1; i++) {
            int mark = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j].compareTo(arr[mark]) < 0) {
                    mark = j;
                }
            }
            change(mark, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("sortInsert работал - " + (endTime - startTime) + "мс");
    }

    public void sortInsert(){
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < size; i++) {
            E temp = arr[i];
            int in = i;
            while (in > 0 && arr[in - 1].compareTo(temp) >= 0) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("sortSelect работал - " + (endTime - startTime) + "мс");
    }

    public MyArr<E> copy() {
        MyArr<E> copyArr = new MyArr<>(size);
        copyArr.size = size;
        copyArr.arr = Arrays.copyOf(arr, arr.length);
        return copyArr;
    }
}
