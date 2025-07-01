package com.test.demomcpclient;


import io.modelcontextprotocol.client.McpAsyncClient;
import io.modelcontextprotocol.client.McpSyncClient;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ClientShowService {

    @Autowired
    private List<McpSyncClient> mcpSyncClients;  // For sync client

// OR

//    @Autowired
//    private List<McpAsyncClient> mcpAsyncClients;  // For async client

    @Autowired
    private SyncMcpToolCallbackProvider toolCallbackProvider;

    @PostConstruct
    public void init() {
        System.out.println("Bean 初始化后执行的代码...");
        ToolCallback[] toolCallbacks = toolCallbackProvider.getToolCallbacks();
        for(int i =0 ;i<toolCallbacks.length;i++){
            log.info("tool{}:{}",i,toolCallbacks[i].toString());
        }
        mcpSyncClients.forEach(client -> {
            log.info("client:{}",client.toString());
        });
    }



}
