.SILENT:

.DEFAULT_GOAL = help

COLOR_RESET = \033[0m
COLOR_GREEN = \033[32m
COLOR_YELLOW = \033[33m

PROJECT_NAME = `basename $(PWD)`

SHELL := /bin/bash

DOCKER_IMAGE_NAME = miguelsmuller/api-thex-clients
DOCKER_CONTAINER_NAME = api-thex-clients

GIT_HASH = $(shell git rev-parse --short HEAD)

## prints this help
help:
	printf "${COLOR_YELLOW}\n${PROJECT_NAME}\n\n${COLOR_RESET}"
	awk '/^[a-zA-Z\-\_0-9\.%]+:/ { \
		helpMessage = match(lastLine, /^## (.*)/); \
		if (helpMessage) { \
			helpCommand = substr($$1, 0, index($$1, ":")); \
			helpMessage = substr(lastLine, RSTART + 3, RLENGTH); \
			printf "${COLOR_GREEN}$$ make %s${COLOR_RESET} %s\n", helpCommand, helpMessage; \
		} \
	} \
	{ lastLine = $$0 }' $(MAKEFILE_LIST)
	printf "\n"


## Install dependencies and air module
setup:
	mvn dependency:resolve


## Run the application statically from the source code
run:
	mvn spring-boot:run


## Build a Docker image for the application
docker-build:
	docker build . -t $(DOCKER_IMAGE_NAME)


## Start the application in a Docker container
docker-run:
	docker run --name $(DOCKER_CONTAINER_NAME) \
			-p 3004:3004 \
			-d -it \
			$(DOCKER_IMAGE_NAME)


## Stop the running Docker container
docker-stop:
	docker container stop $(DOCKER_CONTAINER_NAME)


## Remove the running Docker container
docker-remove:
	docker container stop $(DOCKER_CONTAINER_NAME) && \
	docker rm -f $(DOCKER_CONTAINER_NAME)


## Creates a tag for the Docker image for versioning purposes
docker-tag:
	docker tag $(DOCKER_IMAGE_NAME) $(DOCKER_IMAGE_NAME):$(GIT_HASH)


## Publishes the Docker image to a registry (https://hub.docker.com/)
docker-push:
	docker push $(DOCKER_IMAGE_NAME):$(GIT_HASH)