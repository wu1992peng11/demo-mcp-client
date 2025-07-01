package com.test.demomcpclient;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Slf4j
class DemoMcpClientApplicationTests {


	/*@Test
	void contextLoads() {
		var stdioParams = ServerParameters.builder("java")
				.args(
						"-jar",
						"D:\\projects\\spring-init-mcp\\target\\demo-0.0.1-SNAPSHOT.jar"
					,"--server.port"
						,"8081"
				)
				.build();
		var stdioTransport = new StdioClientTransport(stdioParams);
		var mcpClient = McpClient.sync(stdioTransport).build();

		mcpClient.initialize();

		McpSchema.ListToolsResult tools = mcpClient.listTools();

		//log.info("Mcp tools:{}",tools.tools());
		System.out.println("Mcp tools:{}"+tools.tools());

		McpSchema.CallToolResult weather = mcpClient.callTool(
				new McpSchema.CallToolRequest("getWeatherByCoordinates",
						Map.of("lat","39.7456","lon","-97.0892"))
		);
		//log.info("weather result{}",weather.content());
		System.out.println("weather result{}"+weather.content());
	}*/

}
