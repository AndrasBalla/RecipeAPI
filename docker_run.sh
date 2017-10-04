#!/usr/bin/env bash

echo "Cleaning target directory"
mvn clean

echo "Building new jar"
mvn package

echo "Starting server"
mvn spring-boot:run