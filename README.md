# springBootTemplate
随着框架使用的不断的更新，后面使用SpringBoot会多，这边准备构建一个SpringBoot项目使用的模版。

所谓模版，和之前一样，就是一个最简单的项目，包含所有最简单的空实现。

```
模版的目的

1、不熟悉SpringBoot项目的人，在学习了SpringBoot的基础部分之后，能根据这个模版快速上手

2、开发团队的项目结构和使用装备的统一，包括目录结构，使用的一些组件上面的统一

3、不想重复造轮子，每次新建一个项目很麻烦
```

```
模版所用组件和版本

jdk 1.8
gradle 4.3.1
springBoot 1.5.8
mybatis 3.4.5
mybatis-spring 1.3.1
Druid 1.0.19
thymeleaf
```
 
```
目录简单说明

src/main/java/
存放java代码，其中SpringBootTemplateApplication为SpringBoot启动类

src/main/resources/
application.yml全局SpringBoot配置文件，配置需要使用下面两个配置中的一个
一个application-dev开发环境，application-prod.yml生产环境，当然如果你在全局中配置，则都会生效。

src/main/resources/static
存放各种静态资源文件，如css，js，image等

src/main/resources/templates
存放使用的页面文件，各种html等

src/main/resources/mapper
存放mybatis的sql语句xml文件
```

新增redis配置，项目启动前本机需要启动redis，否则会出现ERRROR

持续更新中~~~~~~~
