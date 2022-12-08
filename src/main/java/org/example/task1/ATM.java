package org.example.task1;

import org.example.task1.handlers.Handler;
import org.example.task1.handlers.Handler20;
import org.example.task1.handlers.Handler5;
import org.example.task1.handlers.Handler50;

public class ATM {
    public static void main(String[] args) {
        Handler handler5 = new Handler5();
        Handler handler20 = new Handler20();
        Handler handler50 = new Handler50();

        handler50.setNext(handler20);
        handler20.setNext(handler5);

        handler50.process(121);
    }
}
