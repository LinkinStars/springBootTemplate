SpringBootTemplate
==================


# 简介

随着框架使用的不断的更新，后面使用SpringBoot会多，这边准备构建一个SpringBoot项目使用的模版。
所谓模版，和之前一样，就是一个最简单的项目，包含所有最简单的空实现。

<br/>
<br/>

## 模版目的  
- 1、不熟悉SpringBoot项目的人，在学习了SpringBoot的基础部分之后，能根据这个模版快速上手
- 2、开发团队的项目结构和使用装备的统一，包括目录结构，使用的一些组件上面的统一
- 3、不想重复造轮子，每次新建一个项目很麻烦

<br/>
<br/>

## 目录说明  

- `src/main/java/`

存放java代码，其中SpringBootTemplateApplication为SpringBoot启动类

- `src/main/resources/`

application.yml 全局配置文件  
application-data.yml  数据源相关配置文件  
application-mvc.yml  页面mvc相关配置文件  
application-config.yml  需要引入的一些全局配置

application-dev.yml  开发环境配置    
application-prod.yml  生产环境配置

- `src/main/resources/static`

存放各种静态资源文件，如css，js，image等

- `src/main/resources/templates`

存放使用的页面文件，各种html等

- `src/main/resources/mapper`

存放mybatis的sql语句xml文件

<br/>
<br/>

## 数据结构

> 表结构定义写法如下

````sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_tab
-- ----------------------------
DROP TABLE IF EXISTS `user_tab`;
CREATE TABLE `user_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `val` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
````


## 注意事项

1. _项目启动前本机需要启动redis，否则会出现ERRROR_
2. _测试地址为http://127.0.0.1:8080/test，测试方法全部在UserController中_

<br/>
<br/>



## RedisUtil

> 新Redis操作工具类,暴露如下操作方法

| 方法名        | 入参                                      | 出参    |
| ------------- | ----------------------------------------- | ------- |
| setExpireTime | String key, long timeout                  | boolean |
| delete        | String key                                | void    |
| hasKey        | String key                                | boolean |
| set           | String key, Object value                  | void    |
| set           | String key, Object value, Long expireTime | void    |
| get           | String key                                | Object  |


<br/>
<br/>


## CacheConfig简单缓存
1、启动类上需要加@EnableCaching注解  
2、在需要执行缓存的类上面写上缓存前缀名称  
@CacheConfig(cacheNames="user")  
3、在查询方法上使用@Cacheable(key = "'list'")配置键的名称  
4、在修改方法上使用@CachePut(key = "'list'")配置键的名称  
http://127.0.0.1:8080/cache/user/list  
http://127.0.0.1:8080/cache/user/add  
http://127.0.0.1:8080/cache/user/delete  
<br/>
<br/>

## FileHandleUtil
> 文件上传工具类，上传到与jar包同级的static目录下，开发环境和服务器环境均可
----------
方法：upload  
  
入参：  
inputStream 文件流  
path 文件路径，如：image/  
filename 文件名，如：test.jpg  

出参：  
最后文件存放路径为：static/upload/image/test.jpg  
文件访问路径为：http://127.0.0.1:8080/upload/image/test.jpg  
该方法返回值为：/upload/image/test.jpg    

-----------
方法：delete  

入参：  
path： 文件路径，是upload方法返回的路径如：/upload/image/test.jpg

----------
关联配置：
````
spring:  
  # 静态资源路径
  resources:
    static-locations: classpath:static/,file:static/
````


<br/>
<br/>


## Dockerfile使用步骤   
1、使用gradle的bootRepackage进行打包   
2、Dockerfile目录下使用命令：docker build -t springboot:v1.0 .  
3、启动本地redis，并修改application-dev.yml中redis的IP地址为宿主机的IP地址如：192.168.1.111，mysql的IP地址同理   
4、使用命令：docker run --name springbootTemplate -d -p 8080:8080 springboot:v1.0   
5、直接访问测试地址即可  


### 注意事项

- `Dockerfile`中的`APP_NAME`对应`jar.baseName-jar.version`
- `Dockerfile`中的`APP_PORT`&`EXPOSE`根据项目情况填写

<br/>
<br/>

## 快速启动和停止应用的脚本
app.sh脚本为快速启动应用和关闭应用的脚本，使用方法如下：  

首先，将你需要发布的jar包，和含有上述内容的脚本app.sh，上传至linux服务器，**注意两者必须处于同一目录**，并给与app.sh相应执行权限，chmod 777 app.sh

然后就可以执行脚本，命令如下

| 命令 | 作用 |
| :-: | :-: |
| ./app.sh start | 启动应用 |
| ./app.sh stop | 关闭应用 |
| ./app.sh restart | 重启应用 |
| ./app.sh status | 查看应用状态 |


脚本中可以修改的地方：  
nohup java -XX:+UseG1GC -XX:+HeapDumpOnOutOfMemoryError -Xms512M -Xmx4G -jar $appName > /dev/null 2>&1 &  
这是最终jar的启动命令，在这里你需要对gc、Xms、Xmx等针对你机器的实际情况修改，还可以添加你所需要的启动参数等。  

for i in {5..1}  
这里是设置restart的时候等待的时间，因为有的项目在5秒之内可能没有办法正常停止，所以可以调整为10秒，保证应用确实正常停止后再启动  

- 脚本至更新1.0.1  
1. 启动停止优化  
./app.sh start 默认会启动当前目录下最后放入的jar包，stop同理   

2. 启动停止参数优化    
./app.sh start springBootTemplate-0.0.1-SNAPSHOT.jar后面可以跟上项目名称，启动或停止指定的项目  

3. 重启指令优化，方便重新发布服务  
./app.sh restart如果当前目录下有两个jar包，会停止前一个放入的jar并备份，然后启动最新放入的jar  
如:当前目录情况为  
app1.jar 放入文件夹时间为12:00  
app2.jar 放入文件夹时间为13:00  
app.sh  
执行重启指令后，先停止app1.jar，然后备份app1.jar，然后启动app2.jar   

