package com.hn.saas.controller;

import com.hn.saas.entities.Product;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * create by biji.zhao on 2021/9/2
 */
public class ZuulController {

    public static void main(String[] args) {
        /**
         * 软引用是用来描述一些还有用，但非必须的对象。
         * 只被软引用关联着的对象，在系统将要发生内存溢出异常前，会把这些对象列进回收范围之中进行第二次回收，
         * 如果这次回收还没有足够的内存，才会抛出内存溢出异常
         */
        SoftReference<Product> reference = new SoftReference(new Product());
        Product softProduct = reference.get();

        /**
         * 弱引用也是用来描述那些非必须对象，但是它的强度比软引用更弱一些，被弱引用关联的对象只能生存到下一次垃圾收集发生为止。
         * 当垃圾收集器开始工作，无论当前内存是否足够，都会回收掉只被弱引用关联的对象。
         */
        WeakReference<Product> weakReference = new WeakReference(new Product());
        Product weakProduct = weakReference.get();

        /**
         * 虚引用 是最弱的一种引用关系
         * 无法通过虚引用来取得一个对象实例  ???
         *
         * 为一个对象设置虚引用关联的唯一目的只是为了能在这个对象被收集器回收时收到一个系统通知
         */
        PhantomReference<Product> phantomReference = new PhantomReference(new Product(), new ReferenceQueue());
        Product product = phantomReference.get();


    }
}
