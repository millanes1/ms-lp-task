#!/bin/bash

# docker-compose doesn't work with argument passed by shell command very well, so create temparary variables and pass them to docker-compose up.
# variable for MS_TASK
export MS_TASK_HOME=$(pwd)/module-task


cd $MS_TASK_HOME
mvn clean
mvn package


export UID=$UID

docker-compose up

