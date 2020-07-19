package main;

import javax.swing.plaf.TableHeaderUI;

import static main.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Anoher Thread ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class");
            }
        }.start();

//        Thread myRunnableThread = new Thread(new MyRunnable());
//        myRunnableThread.start();

        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class implementation of run()");
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "AnoteherThred is terminated, or timed out, so I am back!");
//                    anotherThread.interrupt();
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted.");
                }
            }
        });

        myRunnableThread.start();
//        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread");
    }


}
