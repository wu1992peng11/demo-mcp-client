package com.test.demomcpclient;


import com.anthropic.client.AnthropicClient;
import com.anthropic.client.okhttp.AnthropicOkHttpClient;
import com.anthropic.models.messages.Message;
import com.anthropic.models.messages.MessageCreateParams;
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
            //log.info("tool{}:{}",i,toolCallbacks[i].toString());
            System.out.println("tool{}:{}"+toolCallbacks[i].toString());
        }
        mcpSyncClients.forEach(client -> {
            System.out.println("client:{}"+client.toString());
        });
    }

    @PostConstruct
    public void init2() {
        AnthropicClient client = AnthropicOkHttpClient.fromEnv();

        MessageCreateParams params = MessageCreateParams.builder()
                .model("claude-opus-4-20250514")
                .maxTokens(1000)
                .temperature(1.0)
                .system("You are a world-class poet. Respond only with short poems.")
                .addUserMessage("Why is the ocean salty?")
                .build();

        Message message = client.messages().create(params);
        System.out.println(message.content());
    }


}
