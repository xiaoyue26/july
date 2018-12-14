package protoc;

import com.google.protobuf.ByteString;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static protoc.ArticleProtoc.Article;
import static java.lang.System.out;

/**
 * @author xiaoyue26
 */
public class ReadWriteProtoc {

    public void write() throws IOException {
        Article article = Article.newBuilder()
                .setArticleId(1)
                .setUv(ByteString.copyFromUtf8("321"))
                .setArticleExcerpt("article_excerpt2")
                .build();
        FileUtils.writeByteArrayToFile(new File("out/article.out"), article.toByteArray());
    }

    public void read() throws IOException {

        byte[] byteArticle = FileUtils.readFileToByteArray(new File("out/article.out"));
        Article article = Article.parseFrom(byteArticle);
        out.println(article.getArticleId());
        out.println(article.getArticleExcerpt());
        ByteString uvString = article.getUv();
        out.println(new String(uvString.toByteArray()));
    }

    public static void main(String[] args) throws IOException {
        ReadWriteProtoc obj = new ReadWriteProtoc();
        obj.write();
        obj.read();
    }
}
