#!/usr/bin/env bash

LOG_PATH="$LOG_DIR"
mkdir -p $LOG_PATH

JAVA_OPT="-Djava.security.egd=file:/dev/./urandom"
JAVA_OPT="$JAVA_OPT -Dlog.path=$LOG_PATH -Dfile.encoding=UTF-8"

PARAMS="--server.port=$APP_PORT --spring.profiles.active=$APP_PROFILES $APP_PARAMS --server.contextPath=$CONTEXT_PATH"

echo "Starting..."
echo "java $JVM_OPT $JAVA_OPT -jar $APP_JAR $PARAMS"

java  $JVM_OPT $JAVA_OPT -jar $APP_JAR $PARAMS