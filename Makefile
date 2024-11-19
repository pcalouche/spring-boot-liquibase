# Format the code
.PHONY: format
format:
	mvn spotless:apply spring-javaformat:apply

# Run tests and verify
.PHONY: mvn-verify
mvn-verify: format
	mvn clean verify

# Skip tests and verify
.PHONY: mvn-verify-skip-tests
mvn-verify-skip-tests: format
	mvn clean verify -DskipTests
