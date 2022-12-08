package org.example.task1.handlers;

public class Handler5 extends Handler{
    @Override
    public void process(int price) {
        if (price % 5 > 0 && next == null) {
            throw new IllegalArgumentException();
        }
        else if (next != null) {
            getNext().process(price % 5);
            System.out.println(price / 5 + " * 5");
        }
    }
}
