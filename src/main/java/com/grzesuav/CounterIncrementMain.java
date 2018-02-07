package com.grzesuav;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicLong;
import org.apache.curator.retry.ExponentialBackoffRetry;

import static com.grzesuav.CuratorSession.PATH;

public class CounterIncrementMain {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorSession.getCuratorFramework();

        DistributedAtomicLong counter = new DistributedAtomicLong(curatorFramework, PATH, new ExponentialBackoffRetry(1000, 2));

        AtomicValue<Long> longAtomicValue = counter.increment();


        System.out.println("Long value: " + longAtomicValue.preValue());
    }
}
