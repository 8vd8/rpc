package com.it.rpc;

import com.it.rpc.server.BlogService;
import com.it.rpc.server.RPCServer;
import com.it.rpc.server.serviceImpl.BlogServiceImpl;
import com.it.rpc.server.serviceImpl.SimpleRPCRPCServer;
import com.it.rpc.server.serviceImpl.ThreadPoolRPCRPCServer;
import com.it.rpc.service.UserService;
import com.it.rpc.service.serviceImpl.UserServiceImpl;
import provider.ServiceProvider;

import java.util.HashMap;
import java.util.Map;

public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();
        //Map<String, Object> serviceProvide = new HashMap<>();
        // 暴露两个服务接口， 即在RPCServer中加一个HashMap
        //serviceProvide.put("com.ganghuan.myRPCVersion2.service.UserService",userService);
        //serviceProvide.put("com.ganghuan.myRPCVersion2.service.BlogService",blogService);
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);
        RPCServer RPCServer = new ThreadPoolRPCRPCServer(serviceProvider);
        RPCServer.start(8899);
    }
}
