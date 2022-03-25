package com.example.clientdemo.service;

import com.alibaba.fastjson.JSON;
import com.example.clientdemo.model.Demo;
import com.lpy.client.ClientRpcService;
import com.lpy.command.CommandResponse;
import com.lpy.command.DefaultCommandRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
public class RpcInvokeService {
    private String rpcServer;
    private ClientRpcService rpcClient;

    public String correct() throws Exception{
        DefaultCommandRequest req = new DefaultCommandRequest();
        req.setCommandId("correct");
        return rpcClient.invoke(rpcServer,JSON.toJSONString(req), "dadwasd");
    }

    public Object test(String data) throws Exception {
        class Req extends DefaultCommandRequest{
            private String data;

            public String getData() {
                return data;
            }

            public void setData(String data) {
                this.data = data;
            }
        }
        Req req=new Req();
        req.setCommandId("test");
        req.setData(data);

        return rpcClient.invoke(rpcServer,JSON.toJSONString(req), UUID.randomUUID().toString().replaceAll("-", ""));
    }

    @Value("${biz.dependency-service.commons}")
    public void setRpcServer(String rpcServer) {
        this.rpcServer = rpcServer;
    }


    @Autowired
    public void setRpcClient(ClientRpcService rpcClient) {
        this.rpcClient = rpcClient;
    }
}
