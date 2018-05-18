FROM openjdk:10-jre-slim
COPY ./target/main-0.0.1-SNAPSHOT.jar /main.jar
EXPOSE 8080 5000
CMD [	"java", \
	"-Djava.rmi.server.hostname=0.0.0.0", \
	"-Dcom.sun.management.jmxremote", \
	"-Dcom.sun.management.jmxremote.port=5000", \
	"-Dcom.sun.management.jmxremote.rmi.port=5000", \
	"-Dcom.sun.management.jmxremote.local.only=false", \
	"-Dcom.sun.management.jmxremote.authenticate=false", \
	"-Dcom.sun.management.jmxremote.ssl=false", \
	"-jar", "/main.jar"]
