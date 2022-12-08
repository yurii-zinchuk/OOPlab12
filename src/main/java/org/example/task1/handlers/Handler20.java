package org.example.task1.handlers;

public class Handler20 extends Handler{
    @Override
    public void process(int price) {
        if (price % 20 > 0 && next == null) {
            throw new IllegalArgumentException();
        }
        else if (next != null) {
            getNext().process(price % 20);
            System.out.println(price / 20 + " * 20");
        }
    }
}
