/**********************************************************************************
 *
 * https://leetcode.com/problems/print-in-order/
 *
 * Suppose we have a class:
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 * Example 2:
 *
 * Input: [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 *
 *
 * Note:
 *
 * We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.thread;

public class _1114_Print_in_Order {
    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 2};
        final Foo foo = new Foo();
        for (int n : input) {
            switch (n) {
                case 1: {
                    Thread t = new Thread(() -> {
                        try {
                            foo.first(() -> System.out.print("first"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    t.start();
                    break;
                }
                case 2: {
                    Thread t = new Thread(() -> {
                        try {
                            foo.second(() -> System.out.print("second"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    t.start();
                    break;
                }
                case 3: {
                    Thread t = new Thread(() -> {
                        try {
                            foo.third(() -> System.out.print("third"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    t.start();
                    break;
                }
            }
        }
    }
}

class Foo {

    private Object lock;
    private boolean oneDone;
    private boolean twoDone;

    public Foo() {
        lock = new Object();
        oneDone = false;
        twoDone = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lock) {
            printFirst.run();
            oneDone = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (lock) {
            while (!oneDone) {
                lock.wait();
            }
            printSecond.run();
            twoDone = true;
            lock.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lock) {
            while (!twoDone) {
                lock.wait();

            }
            printThird.run();
        }
    }
}
