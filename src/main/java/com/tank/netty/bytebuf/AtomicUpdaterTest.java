package com.tank.netty.bytebuf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicIntegerFieldUpdater为某个实例对象的属性提供线程安全的操作
 * @author tank
 * @create 2019/11/25 21:35
 */
public class AtomicUpdaterTest {
    public static void main(String[] args) {
//        Person person = new Person();
//        for (int i = 0; i < 10; i++) {
//
//            Thread thread = new Thread(()->{
//                try {
//                    Thread.sleep(20);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(person.age++);
//            });
//            thread.start();
//        }

        Person person = new Person();
        AtomicIntegerFieldUpdater<Person> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater
                .newUpdater(Person.class, "age");
        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(()->{
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(atomicIntegerFieldUpdater.getAndIncrement(person));
            });
            thread.start();
        }
        //assert 1 == 2;  vm option中加 -ea 可生效，assert false抛异常
        System.out.println(2222);
    }

}
class Person{
    volatile int age = 1;
}