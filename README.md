# 欢迎捐助

- 如果您觉得本项目对您有帮助，请捐助，谢谢。

- 您的捐助就是我最大的动力。

<p align=center>
  <a href="https://xuxiaowei.com.cn">
    <img src="https://cdn2-xuxiaowei.oss-cn-qingdao.aliyuncs.com/img/QRCode.png/xuxiaowei.com.cn" alt="徐晓伟工作室" width="360">
  </a>
</p>


# Spring-Boot-Demo
Spring Boot 项目演示模板，将整合完整项目所需及技术、示例、要点。

# 本项目技术

## SSL

- 创建开发版的SSL，生产环境请使用 [阿里云SSL](https://www.aliyun.com/product/cas)、[腾讯云SSL](https://cloud.tencent.com/product/ssl)
    （自己有域名即可申请，阿里云每个账户可申请20个，腾讯云每个主域名可申请20个）
    
- 配置 SSL（https） 

- http 自动重定向到 https

# Spring Boot 依赖（创建项目时可选）

- Spring Boot
    - 2.1.5.RELEASE

- Core
    - Lombok                    注解（Getter/Setter）。
    - Configuration Processor   为您的自定义配置键生成元数据（注解处理器）。

- Web
    - Web                       使用Tomcat和Spring MVC进行全栈Web开发。

- Template
	- Thymeleaf                 是一个适用于Web和独立环境的现代服务器端Java模板引擎。

- SQL
    - MySQL                     MySQL JDBC驱动程序
    
# 其他依赖（创建项目时不可选）

- MyBatis Plus

    - MyBatis Plus Boot Starter         Spring Boot 整合 MyBatis Plus 必须依赖。
    
    - MyBatis Plus Generator            MyBatis Plus 代码生成器 依赖。
    
    - Spring Boot Starter Velocity      Velocity 模板引擎，MyBatis Plus 代码生成器 默认模板引擎。

- 图片验证码
    
    - patchca                           GitHub 图片验证码
    
# 其他说明

- 将本地 host 添加 127.0.0.1 demo.xuxiaowei.com.cn，
    即可使用 [http://demo.xuxiaowei.com.cn](http://demo.xuxiaowei.com.cn)、[https://demo.xuxiaowei.com.cn](https://demo.xuxiaowei.com.cn) 访问本项目，
    SSL 未验证，浏览器会报警告，显示连接不安全，测试环境忽略即可，开发环境使用阿里云SSL、腾讯云SSL。
	