package com.it.rpc.client;

import com.it.rpc.entity.User;
import com.it.rpc.proxy.ClientProxy;
import com.it.rpc.service.UserService;


public class RPCClient {
    public static void main(String[] args) {
        ClientProxy clientProxy = new ClientProxy("127.0.0.1", 8899);
        //通过反射得到userService对象
        UserService proxy = clientProxy.getProxy(UserService.class);

        // 服务的方法1->模拟查数据库的过程
        User userByUserId = proxy.getUserByUserId(10);

        System.out.println("从服务端得到的user为：" + userByUserId);
        // 服务的方法2
        User user = User.builder().userName("张三").id(100).sex(true).build();
        Integer integer = proxy.insertUserId(user);
        System.out.println("向服务端插入数据："+integer);
        }
    }
