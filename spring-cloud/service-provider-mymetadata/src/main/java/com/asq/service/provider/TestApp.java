package com.asq.service.provider;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/4 14:54
 * @description TODO
 **/
public class TestApp
{
    public static void main(String[] args) {
        java.lang.management.MemoryUsage usage = java.lang.management.ManagementFactory.getMemoryMXBean()
                .getHeapMemoryUsage();
        System.out.println("Max: " + usage.getMax()/1024/1024/1024);
        System.out.println("Init: " + usage.getInit()/1024);
        System.out.println("Committed: " + usage.getCommitted());
        System.out.println("Used: " + usage.getUsed());
    }
}
