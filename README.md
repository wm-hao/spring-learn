# spring、spring- boot 、mybatis-plus、spring-cloud  实例搭建
## 一、spring boot 搭建
    1.搭建方式
         通过Web界面使用
         通过Spring Tool Suite使用
         通过IntelliJ IDEA使用
         通过Spring Boot CLI使用
    2.自定义starter（app.controller.HelloController.test引用的starter不在此工程，soeasy自己百度吧）

## 二、集成mybatis-plus
    1.简单的UserMapper->继承BaseMapper
    2.代码生成器CodeGeneration
    3.多数据源配置Dynamic-Datasource
    4.分页查询Page<T>、PaginationInnerInterceptor（HelloController#list）
    5.事务,多数据源事务切换（有问题）@DS
    6.分表 DynamicTableNameInnerInterceptor
    7.延迟加载  lazy-loading-enabled: true   @TableField(exist = false)
##   三、集成swagger-ui
    1.引入springfox-boot-starter增加相关注解，注意新的ui地址是http://localhost:8080/swagger-ui/index.html（原因是springfox.boot.starter.autoconfigure.SwaggerUiWebMvcConfigurer）