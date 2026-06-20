package com.breno.financecontrol.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner{
	
	@Override
	public void run(String... args) throws Exception {
	}
}
