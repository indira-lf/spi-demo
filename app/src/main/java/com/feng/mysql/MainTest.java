package com.feng.mysql;

import com.feng.data.DataSaveService;

import java.util.ServiceLoader;

/**
 * @author
 * @time 2022/10/15 14:37
 * @Description- spi -> Service Provider Interface
 */
public class MainTest {
    public static void main(String[] args) {
        ServiceLoader<DataSaveService> saveServices = ServiceLoader.load(DataSaveService.class);
        for (DataSaveService saveService : saveServices) {
            saveService.saveData("Hello world!");
        }
    }
}
