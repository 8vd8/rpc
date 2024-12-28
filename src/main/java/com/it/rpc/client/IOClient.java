package com.it.rpc.client;

import com.it.rpc.common.RPCRequest;
import com.it.rpc.common.RPCResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//通过socket接受客户端的输入和服务端的输出
//主要是对服务端的输出进行封装，用来将输出的信息转成统一的格式
public class IOClient {

    public static RPCResponse sendRequest(String host, int port, RPCRequest request){
        try {
            Socket socket = new Socket(host, port);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            System.out.println(request);
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            RPCResponse response = (RPCResponse) objectInputStream.readObject();

            return response;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println();
            return null;
        }
    }
}