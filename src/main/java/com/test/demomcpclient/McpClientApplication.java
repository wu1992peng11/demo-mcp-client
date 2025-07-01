package com.test.demomcpclient;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpClientApplication.class, args);

	}

	//@Value(value = "Please search for \"climate change solutions\" and summarize the top results.")
	@Value(value = "Please search for \"tomorrow weather in Los Angels \" and summarize the top results.")
	private String userInput;

	@Bean
	public CommandLineRunner predefinedQuestions(ChatClient.Builder chatClientBuilder, ToolCallbackProvider tools,
												 ConfigurableApplicationContext context) {
		return args -> {
			try {
				var chatClient = chatClientBuilder
						.defaultToolCallbacks(tools)
						.build();

				System.out.println("\n>>> QUESTION: " + userInput);

				var response = chatClient.prompt(userInput).call();
				System.out.println("\n>>> ASSISTANT: " + response.content());

			} catch (Exception e) {
				System.err.println("Error occurred: " + e.getMessage());
				e.printStackTrace();
			} finally {
				context.close();
			}
		};
	}
}
