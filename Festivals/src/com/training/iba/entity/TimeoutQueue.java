package com.training.iba.entity;

import com.sun.istack.internal.NotNull;

public class TimeoutQueue<T> {
    private Entry<T> header;

    public TimeoutQueue() {
        this.header = new Entry<>();
        header.value = null;
        header.prev = header;
        header.next = header;
    }

    public boolean offer(@NotNull T value) {
        if (value == null) return false;
        Entry<T> item = new Entry<>(value, header, header.prev);
        item.prev.next = item;
        item.next.prev = item;
        return true;
    }

    public boolean offer(@NotNull T value, long mills) {
        if (value == null) return false;
        Entry<T> item = new Entry<>(value, header, header.prev);
        item.timeout = mills;
        item.offerTime = System.currentTimeMillis();
        item.prev.next = item;
        item.next.prev = item;
        return true;
    }

    public int size() {
        int count = 0;
        Entry<T> temp = header.next;
        while (temp.value != null) {
            if ((System.currentTimeMillis() - temp.offerTime) <= temp.timeout) count++;
            else delete(temp);
            temp = temp.next;
        }
        return count;
    }

    public void show() {
        Entry<T> temp = header.next;
        while (temp.value != null) {
            if ((System.currentTimeMillis() - temp.offerTime) > temp.timeout) delete(temp);
            else System.out.println(temp.value);
            temp = temp.next;
        }
    }

    private void delete(Entry<T> item) {
        item.prev.next = item.next;
        item.next.prev = item.prev;
    }

    public T poll() {
        if (size() != 0) {
            T result = header.next.value;
            delete(header.next);
            return result;
        } else return null;
    }

    private static class Entry<T> {
        T value;
        long timeout;
        long offerTime;
        Entry<T> next;
        Entry<T> prev;

        Entry(T value, Entry<T> next, Entry<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        Entry() {
        }
    }
}
