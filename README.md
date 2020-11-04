DESCRIPTION
---------------
This service analyzes a paper or article and counts how many times each word appears.  
It will return a table containing a count of each word and/or a word cloud for a visual representation of 
how many times each word occurs.

USAGE
---------------
Build:
mvn package
Run:
java -cp target/cs370team16-1.0-SNAPSHOT-jar-with-dependencies.jar RestfulServer

Using the root path "/" route for the HTTP POST method

DOCKER
---------------
A “Docker” section, which contains instructions for building your Docker image,
and more importantly, how to run the image as a container. 

docker rm maven-test
docker build -t maven-test
docker run -it --name=maven-test -p 8080:8080 maven-test
