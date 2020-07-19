package main;

import static main.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName() );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread woke me up"); //ez is megtortenhet
            return; //a return kikapcsolja a szalat
        }
        System.out.println(ANSI_BLUE + "Five seconds have passed and I am awake");
    }
}
