
# Simple class File with minimal Java output
Small Java class which outputs some standard information that is available in every Java runtime environment:
* information about the locale
* information about the system properties

## Build
```
cd ~/Workspaces/class
./gradlew compileJava
```

## Run
```
cd ~/Workspaces/class
./gradlew run
```

## Run in Docker Container
```
cd ~/Workspaces/class
docker run -v `pwd`:/tmp -it --rm openjdk:8u151-jre-alpine3.7 "/tmp/docker-run.sh"
docker run -v `pwd`:/tmp -it --rm openjdk:8-jre "/tmp/docker-run.sh"
docker run -v `pwd`:/tmp -it --rm openjdk:9-jre "/tmp/docker-run.sh"
docker run -v `pwd`:/tmp -it --rm openjdk:10-jre "/tmp/docker-run.sh"
```

