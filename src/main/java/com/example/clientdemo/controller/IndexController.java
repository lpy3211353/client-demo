package com.example.clientdemo.controller;

import com.example.clientdemo.service.RpcInvokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private RpcInvokeService rpcInvokeService;

    @RequestMapping(value = "test")
    public String test() throws Exception{
        return rpcInvokeService.correct();
    }

    @RequestMapping(value = "ttest")
    public Object ttest(@RequestBody String data) throws Exception{
        return rpcInvokeService.test(data);
    }
    @Autowired
    public void setRpcInvokeService(RpcInvokeService rpcInvokeService) {
        this.rpcInvokeService = rpcInvokeService;
    }
}
