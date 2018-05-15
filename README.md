**使用gradle管理scala,groovy,java**

_use gradle to manage scala/groovy/java_

大致来说,每个commit对应一个学习内容.

# 1. 分离打包:
## 本地
gradle inD && cd build/install/ && tar -cvf july.tar july/* && mupload -f july.tar -o bbb.tar && rm -f july.tar && cd ../..

## 服务器
wget http://upload.zhenguanyu.com/uploads/bbb.tar && rm -rf july/ && tar -xvf bbb.tar && rm -rf bbb.tar 
sh july/bin/july


# 2. 打成一个包
## 本地
gradle clean shadowJar && mupload -f build/libs/*.jar -o redis-reader.jar 

## 服务器
rm redis-reader.jar && wget http://upload.zhenguanyu.com/uploads/redis-reader.jar

## 代理: 
git config --global http.proxy socks5h://127.0.0.1:1081
git config --global https.proxy socks5://127.0.0.1:1081
git config --global core.gitProxy socks5://127.0.0.1:1081
git config --global -l

