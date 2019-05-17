# Spring-Boot-Demo
Spring Boot 项目演示模板。

# 本项目技术

## SSL

- 创建开发版的SSL，生产环境请使用 阿里云SSL、腾讯云SSL（自己有域名即可申请，阿里云每个账户可申请20个，腾讯云每个主域名可申请20个）
- 配置 SSL（https） 
- http 自动重定向到 https

# Spring Boot 依赖（创建项目时可选）

- Spring Boot
    - 2.1.5.RELEASE

- Web
    - Web                   使用Tomcat和Spring MVC进行全栈Web开发。

- Template
	- Thymeleaf             是一个适用于Web和独立环境的现代服务器端Java模板引擎。

- SQL
    - MySQL                 MySQL JDBC驱动程序
    
# 其他依赖（创建项目时不可选）

- spring-boot-configuration-processor   
    
    - 注解处理器
    
# 其他说明

- 将本地 host 添加 127.0.0.1 demo.xuxiaowei.com.cn，
    即可使用 http://demo.xuxiaowei.com.cn、https://demo.xuxiaowei.com.cn 访问本项目，
    SSL 未验证，浏览器会报警告，显示连接不安全，测试环境忽略即可，开发环境使用阿里云SSL、腾讯云SSL。