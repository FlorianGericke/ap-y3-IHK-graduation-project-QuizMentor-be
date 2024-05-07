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
	@docker run -rm \
	--env-file ".github/super-linter.env" \
	-e RUN_LOCAL=true \
	-e GITHUB_TOKEN="" \
	-e VALIDATE_ALL_CODEBASE=true \
	-v $(PWD):/tmp/lint \
	github/super-linter:latest

lint:
	@docker run  \
	--env-file ".github/super-linter.env" \
	-e RUN_LOCAL=true \
	-e GITHUB_TOKEN="" \
	-v $(PWD):/tmp/lint \
	github/super-linter:latest