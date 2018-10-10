

protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/addressbook.proto

protoc -I=. --java_out=. ./addressbook.proto
