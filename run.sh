#!/bin/sh

docker rm maven-test
docker build -t maven-test .
docker run -it --name=maven-test -p 8080:8080 maven-test