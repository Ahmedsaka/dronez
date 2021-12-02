Requirements: Java, maven, and elasticsearch/docker must be installed and running
i.e to run elasticsearch in docker mode run  docker run -p 9200:9200-e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.10.0


To build the project, move into the project directory and run mvn clean package

Move into the target folder to and execute the command java -jar dronez-0.0.1-SNAPSHOT.jar to start the application

Note: this application uses an embedded database