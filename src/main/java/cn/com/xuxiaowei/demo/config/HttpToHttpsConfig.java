package cn.com.xuxiaowei.demo.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * http 重定向到 https
 * <p>
 * 设置 端口号 http（80），并将 http（80） 重定向到 https（443）
 *
 * @author xuxiaowei
 */
@Configuration
public class HttpToHttpsConfig {

    /**
     * 设置 端口号 http 80，并将 80 重定向到 443
     */
    @Bean
    protected ServletWebServerFactory servletWebServerFactory() {

        // 使用无参构造器也可，效果一样，这里介绍了创建指定连接器
        Connector connector = new Connector(org.apache.coyote.http11.Http11NioProtocol.class.getName());

        // 设置端口
        connector.setPort(80);

        // 使用 Spring 的 {@link ServletContextInitializer} 或 Tomcat {@link LifecycleListener}进行初始化。
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {

            /**
             * 在与Tomcat服务器一起使用之前对Tomcat {@link Context}进行后处理。
             * 子类可以重写此方法以将其他处理应用于{@link Context}。
             *
             * @param context Catalina servlet 引擎中的 servlet context
             */
            @Override
            protected void postProcessContext(Context context) {

                // Web应用程序的安全性约束元素（创建一个安全约束）
                SecurityConstraint constraint = new SecurityConstraint();

                // 此安全性约束的用户数据约束。 必须是NONE，INTEGRAL或CONFIDENTIAL（设置安全约束的用户约束）
                constraint.setUserConstraint("CONFIDENTIAL");

                // Web应用程序的安全性约束的Web资源集合（创建新的Web资源集合）
                SecurityCollection collection = new SecurityCollection();

                // 添加URL模式以成为此Web资源集合的一部分（添加资源合集的URL范围）（自动将http重定向到https的URL范围）
                collection.addPattern("/*");

                // 向受此安全约束保护的用户添加新的Web资源集合（在安全约束中添加新的Web资源集合）
                constraint.addCollection(collection);

                // 为此Web应用程序的集添加安全性约束。
                context.addConstraint(constraint);
            }

        };

        // 添加一个新的连接器（http）
        tomcat.addAdditionalTomcatConnectors(connector);

        return tomcat;
    }

}
