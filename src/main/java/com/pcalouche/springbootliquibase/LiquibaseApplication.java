package com.pcalouche.springbootliquibase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@Slf4j
public class LiquibaseApplication {

	private static final List<String> requiredOptions = Arrays.asList("dbUrl", "dbUser", "dbPwd");

	static void main(String[] args) {
		configureApplication(new SpringApplicationBuilder(), new DefaultApplicationArguments(args)).run(args);
	}

	private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder,
			ApplicationArguments args) {
		log.info("Application started with the following arguments:");
		for (String name : args.getOptionNames()) {
			log.info("{} -> {}", name, args.getOptionValues(name));
		}

		if (!args.getOptionNames().containsAll(requiredOptions)) {
			log.error("Not all required arguments were supplied.  Required arguments are: {}", requiredOptions);
			System.exit(1);
		}

		Map<String, Object> properties = new HashMap<>();
		for (String requiredOption : requiredOptions) {
			properties.put(requiredOption, args.getOptionValues(requiredOption));
		}

		if (args.getOptionNames().contains("dropFirst")) {
			properties.put("liquibase.drop-first", args.getOptionValues("dropFirst"));
		}

		return builder.properties(properties).sources(LiquibaseApplication.class);
	}

}
