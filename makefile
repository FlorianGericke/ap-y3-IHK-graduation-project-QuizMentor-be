.phony: startDataBase stopDataBase startEnv test lint-all lint

startDataBase:
	@echo "Starting database..."
	@docker-compose up -d

stopDataBase:
	@echo "Stopping database..."
	@docker-compose down

startEnv:
	$(MAKE) startDataBase
	@echo "Starting Backend..."
	@gradle bootRun --console=plain

test:
	@gradle test

lint-all:
	@docker run --rm \
	-e RUN_LOCAL=true \
	-e VALIDATE_ALL_CODEBASE=true \
	-e VALIDATE_JAVA=true \
	-e DEFAULT_BRANCH=main \
	-e FILTER_REGEX_INCLUDE="src/.*" \
	-v $(PWD):/tmp/lint \
	github/super-linter:latest

lint:
	@docker run --rm \
	-e RUN_LOCAL=true \
	-e VALIDATE_ALL_CODEBASE=false \
	-e VALIDATE_JAVA=true \
	-e DEFAULT_BRANCH=develop \
	-e FILTER_REGEX_INCLUDE="src/.*" \
	-v $(PWD):/tmp/lint \
	github/super-linter:latest

