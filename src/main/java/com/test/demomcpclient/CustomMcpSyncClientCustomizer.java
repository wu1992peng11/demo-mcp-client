package com.test.demomcpclient;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.spec.McpSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.mcp.customizer.McpSyncClientCustomizer;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
@Slf4j
public class CustomMcpSyncClientCustomizer implements McpSyncClientCustomizer {
    @Override
    public void customize(String serverConfigurationName, McpClient.SyncSpec spec) {
        //log.info("customize");
        System.out.println("customize");
        // Customize the request timeout configuration
        spec.requestTimeout(Duration.ofSeconds(60));

        // Sets the root URIs that this client can access.
        //spec.roots(roots);

        // Sets a custom sampling handler for processing message creation requests.
        /*spec.sampling((McpSchema.CreateMessageRequest messageRequest) -> {
            // Handle sampling
            McpSchema.CreateMessageResult result = ...
            return result;
        });*/

        // Adds a consumer to be notified when the available tools change, such as tools
        // being added or removed.
        spec.toolsChangeConsumer((List<McpSchema.Tool> tools) -> {
            // Handle tools change
            /*log.info("tools change:{}",tools.);*/
            tools.forEach(tool -> log.info(tool.name()));
        });

        // Adds a consumer to be notified when the available resources change, such as resources
        // being added or removed.
        spec.resourcesChangeConsumer((List<McpSchema.Resource> resources) -> {
            // Handle resources change
        });

        // Adds a consumer to be notified when the available prompts change, such as prompts
        // being added or removed.
        spec.promptsChangeConsumer((List<McpSchema.Prompt> prompts) -> {
            // Handle prompts change
        });

        // Adds a consumer to be notified when logging messages are received from the server.
        spec.loggingConsumer((McpSchema.LoggingMessageNotification log) -> {
            // Handle log messages
        });
    }
}
