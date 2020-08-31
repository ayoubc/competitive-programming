package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> tree;

    public Heap() {
        this.tree = new ArrayList<>();
        this.tree.add(null);
    }

    public void add(T x) {
        this.tree.add(x);
        this.bubbleUp(this.tree.size() - 1);
    }

    boolean isEmpty() {
        return this.tree.size() <= 1;
    }

    T remove() {
        if (this.isEmpty()) {
            throw new NullPointerException("Empty Tree");
        }
        T res = this.tree.get(1);
        this.tree.set(1, this.tree.get(this.tree.size()-1));
        this.tree.remove(this.tree.size() - 1);
        this.bubbleDown(1);
        return res;
    };

    T top() {
        if (this.isEmpty()) {
            throw new NullPointerException("Empty Tree");
        }
        return this.tree.get(1);
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return 2 * index;
    }

    private int rightChild(int index) {
        return 2 * index + 1;
    }

    private void bubbleUp(int index){
        while(index > 1) {
            int par = this.parent(index);
            if(this.tree.get(index).compareTo(this.tree.get(par)) > 0) {
                Collections.swap(this.tree, index, par);
                index = par;
            }
            else break;
        }
    }
    void bubbleDown(int index) {
        while (true) {
            int largest = index;
            int left = leftChild(index);
            int right = rightChild(index);
            if (left < this.tree.size() && this.tree.get(left).compareTo(this.tree.get(largest)) > 0) {
                largest = left;
            }
            if (right < this.tree.size() && this.tree.get(right).compareTo(this.tree.get(largest)) > 0) {
                largest = right;
            }
            if (largest == index) break;
            else {
                Collections.swap(this.tree, index, largest);
                index = largest;
            }
        }
    };
}
