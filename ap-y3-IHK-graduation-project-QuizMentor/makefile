.phony: startDataBase stopDataBase startEnv

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
	gradle test