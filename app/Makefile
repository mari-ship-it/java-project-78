.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.14

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

sonar:
	./gradlew build sonar --info

build-run: build run

.PHONY: build