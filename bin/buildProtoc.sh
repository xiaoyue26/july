export SRC_DIR=../src/main/java/
protoc -I=$SRC_DIR/protoc  --java_out=$SRC_DIR $SRC_DIR/protoc/ArticleProtoc.proto