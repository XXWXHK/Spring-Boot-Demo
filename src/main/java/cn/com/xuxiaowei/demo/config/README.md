# cn.com.xuxiaowei.demo.config 说明

- 此包的作用？

    - 将一些项目配置放入此包中，用于方便管理。

- 每个类的作用？

    - HttpToHttpsConfig
    
        - 新增端口 http(80)（在 application.yml 中配置的是 https(443) 端口）
    
        - http(80) 自动重定向到 https(443)

    - MybatisPlusConfig
    
        - Mybatis Plus 配置
            
            - SQL执行效率插件
            
            - 分页插件
    
    - ServletConfig
    
        - Servlet 配置文件