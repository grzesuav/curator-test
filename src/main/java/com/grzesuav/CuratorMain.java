package com.grzesuav;

import org.apache.curator.framework.CuratorFramework;

import java.nio.ByteBuffer;

import static com.grzesuav.CuratorSession.PATH;

public class CuratorMain {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorSession.getCuratorFramework();
        if (curatorFramework.checkExists().forPath(PATH) == null) {
            curatorFramework.create().creatingParentsIfNeeded().forPath(PATH);
            System.out.println("Creating path " + PATH);
        }
        byte[] newData = new byte[8];
        ByteBuffer wrapper = ByteBuffer.wrap(newData);
        wrapper.putLong(5);
        curatorFramework.setData().forPath(PATH, newData);
        System.out.println("Set value to ");
    }

}
