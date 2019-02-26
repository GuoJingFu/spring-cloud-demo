# spring cloud 完整demo

## eureka-server项目：eureka server注册中心
### 集群配置
      1. 启动时修改端口，每个应用设置不同端口
      2. eureka的defaultZone应该设置为所有server的服务地址
          比如启动两个端口分别为8081，8082， 则
         `defaultZone: http://localhost:8081/eureka/,http://localhost:8082/eureka/`
### 报错问题
      1. 访问eureka server界面出现保护模式提示：EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE
        stackoverflow上，有人给出的建议是： 
            (1) 在生产上可以开自注册，部署至少两个server 
            (2) 在本机器上测试的时候，可以把比值调低(默认0.85)，比如0.49 
            (3) 或者直接把自我保护模式关闭
      2. eureka客户端向eureka server注册时连接端口为默认8761
        原因为defaultZone没有设置,注意2.0.0版本源码中识别的是defaultZone不能改为default-zone
        eureka.client.service-url.defaultZone=http://ip:port/eureka/

## service-producer项目：eureka client 服务提供者
###  服务提供者集群配置
       和eureka注册中心配置类似
       1. 启动时修改端口，每个应用设置不同端口
       2. eureka的defaultZone应该设置为所有server的服务地址

## feign-consumer项目： 服务消费者
    这里采用feign来作为服务消费者；
    特点：
        1. 可插拔的注解支持，包括Feign注解和JAX-RS注解;
        2. 支持可插拔的HTTP编码器和解码器;
        3. 支持Hystrix和它的Fallback;
        4. 支持Ribbon的负载均衡;
        5. 支持HTTP请求和响应的压缩。

__注意: 服务生产者和消费者是一个相对概念, 表示两个微服务的服务提供者和使用者__
 
 ## api-gateway项目：服务网关
 ### 网关只能配置为单个服务
       1. 由于作为统一的接口暴露服务，配置多个没有意义；
       2. 如果要对网关服务进行集群部署，需要配置统一DNS服务器路径，进行转发和负载均衡。
### 和springboot web服务不兼容
       1. 注意springcloud gateway使用的web框架为webflux，和springMVC不兼容。