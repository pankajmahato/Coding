/**********************************************************************************
 *
 * https://leetcode.com/problems/print-foobar-alternately/
 *
 * Suppose you are given the following code:
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: "foobar"
 * Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
 * Example 2:
 *
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is being output 2 times.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;

public class _1115_Print_FooBar_Alternately {
    public static void main(String[] args) {
        int n = 10;
        final FooBar fooBar = new FooBar(n);
        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
    }
}

class FooBar {
    private int n;
    private Object lock;
    private boolean runFoo;
    private boolean runBar;

    public FooBar(int n) {
        this.n = n;
        lock = new Object();
        runFoo = true;
        runBar = false;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (lock) {
                while (!runFoo) {
                    lock.wait();
                }
                printFoo.run();
                runFoo = false;
                runBar = true;
                lock.notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (lock) {
                while (!runBar) {
                    lock.wait();
                }
                printBar.run();
                runFoo = true;
                runBar = false;
                lock.notifyAll();
            }

        }
    }
}
