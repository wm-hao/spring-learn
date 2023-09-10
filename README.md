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

##  四、集成redis
    1.集成standalone模式redis DemoApplicationTests.testRedis
    2.集成redis-sentinel模式redis（例子RedisController）如何搭建redis-sentinel（随便soso就有啦）

##  五、集成activemq
    1.配置spring-boot-starter-activemq（可能出现JmsMessagingTemplate注入不了，springboot2以后要添加pooled-jms依赖）
    2.同时支持queue和topic模式，topic需要自己注入JmsListenerContainerFactory，然后消费者注解要指明containerFactory = "jmsListenerContainerTopic"
    3.想要queue转发消息到topic，自己代码写，@SendTo没用 
    4.@SendTo注解后，要有返回值，不然会报错进入死信队列DLQ
    5.不转发消息，就void返回
    6.application-2.yml、application-3.yml是为了测试多个订阅，queue模式每次只有一个实例消费，topic都会消费（入口ActiveMQController）

##  六、集成spring-cloud和zk做注册中心
    1.@EnableDiscoveryClient 开启服务发现
    2.用RestTemplate访问application-name作为http主机名的服务