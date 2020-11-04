# CS370team16 Term Project

## DESCRIPTION

- This service analyzes a paper or article and counts how many times each word appears.  
- It will return a table containing a count of each word and/or a word cloud for a visual representation of how many times each word occurs.

## USAGE

### Dependencies

- Java JDK 14
-Maven

### Build 

- run `$mvn clean && mvn package`

### Run

- run `$ java -cp target/cs370team16-1.0-SNAPSHOT-jar-with-dependencies.jar RestfulServer`

## Docker 

- `$ docker build -t <tagname> .`
- `$ docker run -it --name=<tagname> -p 8080:8080 <tagname>`

