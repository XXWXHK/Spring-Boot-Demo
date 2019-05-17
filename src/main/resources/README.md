# application.yml 说明

- 使用 properties 还是 yml ？
    
    - 创建 Spring Boot 项目时，默认生成的是 application.properties 文件，本项目使用 application.yml，原因是 yml 拥有树结构。
    
- 怎样获取 SSL 配置文件（开发环境）？

    - 在 \demo\src\main\resources\config\cert\创建开发版SSL证书说明.docx 中有详细描述。
    
- 怎样获取 SSL 配置文件（生产环境）？

    - 在 阿里云、腾讯云上可免费申请 SSL 配置文件。
    
    - [阿里云SSL](https://www.aliyun.com/product/cas)每个账户可申请20个，每个有效期一年。
    
    - [腾讯云SSL](https://cloud.tencent.com/product/ssl)每个主域名可申请20个，每个有效期一年。
    
- 静态文件（URL）优先级？

    - 通过在 application.yml 中增加 logging.level.web.web=debug（这里使用的是 application.properties 写法，方便），
    访问任何URL，都可以在控制台看到以下内容：
    
    - Mapped to ResourceHttpRequestHandler [class path resource [META-INF/resources/], class path resource [resources/], class path resource [static/], class path resource [public/], ServletContext resource [/], class path resource []]
    
    - URL（静态文件）的优先级是：[META-INF/resources/] > [resources/] > [static/] > [public/]，Servlet 大于静态文件。
        - 优先级从高到低：
            - \demo\src\main\resources\META-INF\resources
            - \demo\src\main\resources\resources
            - \demo\src\main\resources\static
            - \demo\src\main\resources\public
        - 新建项目时，默认生成 \demo\src\main\resources\static，如果将静态文件放入到 \demo\src\main\resources\static 中，如 layui、vue等，
            如要修改源码，可将要修改的文件复制一份，在比它优先级高的静态文件夹中构建相同的目录即可。
