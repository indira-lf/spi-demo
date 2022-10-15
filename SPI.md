# 什么是 SPI？

​	SPI（Service Provider Interface）是一种旨在由第三方实现或者扩展的 API。**它可以用于启用、扩展甚至替换框架中的组件。**SPI 的目的是为了在不修改原来的代码库的基础上，开发人员可以使用新的插件或者模块来增强框架功能。如我们常使用的 JDBC，在 Java 的核心类库中，并没有规定开发者需要使用何种类型的数据库，开发者可以根据自身需求来选择不同的数据库类型，可以是 MySQL、Oracle。

​	所以**Java 的核心类库只提供了数据库驱动的接口 Java.sql.Driver**，不同的数据库服务提供商可以实现此接口，而开发者只需配置相应数据库驱动的实现类，JDBC 框架就能自行加载第三方的服务以达到客户端访问不同类型的数据库的功能。

# SPI实现步骤

1. 在模块api-db-interface定义接口DataSaveService

```java
public interface DataSaveService {
    /**
     * 数据保存服务
     * @param data
     */
    void saveData(String data);
}
```

2. 在api-db-impl-mysql模块和api-db-impl-redis模块实现DataSaveService接口，重写saveData方法

```java
public class MySQLSaveServiceImpl implements DataSaveService {
    @Override
    public void saveData(String data) {
        System.out.println("MySQL保存了数据："+data);
    }
}
```

```java
public class RedisSaveServiceImpl implements DataSaveService {
    @Override
    public void saveData(String data) {
        System.out.println("Redis保存了数据："+data);
    }
}
```

3. 在api-db-impl-mysql模块和api-db-impl-redis模块的resources文件夹新建META-INF文件夹，在META-INF文件夹下面新建services文件夹，services文件下新建以文件名为接口限定名的文件，里面写入实现接口的实现类的限定名
4. test测试类

```java
public class MainTest {
    public static void main(String[] args) {
        ServiceLoader<DataSaveService> saveServices = ServiceLoader.load(DataSaveService.class);
        for (DataSaveService saveService : saveServices) {
            saveService.saveData("Hello world!");
        }
    }
}
```

