package com.feng.redis;

import com.feng.data.DataSaveService;

/**
 * @author
 * @time 2022/10/15 14:43
 * @Description- TODO
 */
public class RedisSaveServiceImpl implements DataSaveService {
    @Override
    public void saveData(String data) {
        System.out.println("Redis保存了数据："+data);
    }
}
