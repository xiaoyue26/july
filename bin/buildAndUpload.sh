#!/usr/bin/env bash
gradle shadowJar
mupload -f build/libs/july-1.0-SNAPSHOT-all.jar -o redis-reader.jar
