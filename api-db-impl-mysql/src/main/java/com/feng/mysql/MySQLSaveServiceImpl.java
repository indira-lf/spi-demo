package com.feng.mysql;

import com.feng.data.DataSaveService;

/**
 * @author
 * @time 2022/10/15 14:41
 * @Description- TODO
 */
public class MySQLSaveServiceImpl implements DataSaveService {
    @Override
    public void saveData(String data) {
        System.out.println("MySQL保存了数据："+data);
    }
}
