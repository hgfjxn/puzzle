package win.hgfdodo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class Outer {
    private Inner user;
    private Inner message;


    //此处去掉构造函数即可符合预期；如果构造函数存在会造成user 和message的值一样。
    public Outer(Inner user, Inner message) {
        this.user = user;
        this.message = message;

        System.out.println(System.nanoTime() + " constructor: " + user + "," + message);
    }

    public Inner getUser() {
        return user;
    }

    public void setUser(Inner user) {
        System.out.println(System.nanoTime() + " user:" + user);
        this.user = user;
    }

    public Inner getMessage() {
        return message;
    }

    public void setMessage(Inner message) {
        System.out.println(System.nanoTime() + " message:" + message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "Outer{" +
                "user=" + user +
                ", message=" + message +
                '}';
    }
}
