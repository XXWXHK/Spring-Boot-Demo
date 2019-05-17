# application.yml 说明

- 使用 properties 还是 yml ？
    
    - 创建 Spring Boot 项目时，默认生成的是 application.properties 文件，本项目使用 application.yml，原因是 yml 拥有树结构。
    
- 怎样获取 SSL 配置文件（开发环境）？

    - 在 \demo\src\main\resources\config\cert\创建开发版SSL证书说明.docx 中有详细描述。
    
- 怎样获取 SSL 配置文件（生产环境）？

    - 在 阿里云、腾讯云上可免费申请 SSL 配置文件。
    
    - [阿里云SSL](https://www.aliyun.com/product/cas)每个账户可申请20个，每个有效期一年。
    
    - [腾讯云SSL](https://cloud.tencent.com/product/ssl)每个主域名可申请20个，每个有效期一年。