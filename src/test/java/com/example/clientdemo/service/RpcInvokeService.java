package com.example.clientdemo.service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.lpy.client.ClientRpcService;
import org.springframework.stereotype.Service;

@Service
public class RpcInvokeService {
    private String rpcServer;
    private ClientRpcService rpcClient;

    public String correct() throws Exception{
        return rpcClient.invoke(rpcServer,"hello", "dadwasd");
    }
}
