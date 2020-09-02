#!/usr/bin/env bash

UNIQUEID=$(cat /dev/random | base64 | head -c 20)

export SCHEDULER_UNIQUEID=$UNIQUEID

exec java -jar /app/app.jar