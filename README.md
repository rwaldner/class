
# Simple class File with minimal Java output

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

