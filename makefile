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


lint:
	docker run --env-file .github/super-linter.env -v $(PWD):/tmp/lint \
	github/super-linter
