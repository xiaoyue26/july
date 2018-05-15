#!/usr/bin/env bash
rm -f redis-reader.jar
wget http://upload.zhenguanyu.com/uploads/redis-reader.jar
java -classpath redis-reader.jar kafka.MyConsumer



rm -f redis-reader.jar && wget http://upload.zhenguanyu.com/uploads/redis-reader.jar && java -classpath redis-reader.jar kafka.MyConsumer2