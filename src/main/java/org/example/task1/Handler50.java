package org.example.task1;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.guieffect.qual.SafeEffect;

public class Handler50 extends Handler{
    @Override
    public void process(int price) {
        if (price % 50 > 0 && next == null) {
            throw new IllegalArgumentException();
        }
        else if (next != null) {
            getNext().process(price % 50);
            System.out.println(price / 50 + " * 50");
        }
    }
}
