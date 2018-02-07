package com.grzesuav;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorSession {
    public static final String PATH = "/a/b/c";

    static CuratorFramework getCuratorFramework() throws InterruptedException {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181")
                .connectionTimeoutMs(5000)
                .sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        curatorFramework.start();
        curatorFramework.blockUntilConnected();
        return curatorFramework;
    }
}
