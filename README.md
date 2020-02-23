## 祥子

## 资料
[es社区](https://elasticsearch.cn/)
[bootstrap官方文档](https://v3.bootcss.com/)
[github dev](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
[okhttp](https://square.github.io/okhttp/)
[mybatis](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-test-autoconfigure/index.html)
[thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)
[spring文档](https://docs.spring.io/spring/docs/5.0.1.RELEASE/spring-framework-reference/)

## 工具
[画图](https://www.visual-paradigm.com/cn/)
[flyway](https://flywaydb.org/getstarted/firststeps/maven)
[lombok](https://projectlombok.org/)

## 脚本
```sql
create table USER
(
	ID INT auto_increment,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN CHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
	constraint USER_PK
		primary key (ID)
);
```
```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```

## 笔记
1.textarea 用 th:text回显，而input 用th:value回显
2.fastjson 能将下划线自动转成驼峰
3.mybatis用mybatis generator自动生成sql
4.okhttp发送http请求
5.spring-boot-devtools自动部署，liveReload发现后台服务变了就刷新页面
6.统一处理异常

## 疑问
1.PageDTO中 pages 为什么要new出来 其它变量无需new
2.select中为啥用count(1)不用count(*)
3.在加入拦截器后，如果有@EnableWebMvc注解就会找不到资源，去掉就好了
4.拦截器中自定义的HandlerInterceptor入参，为什么不能new出来，必须要@Autowired自动注入
5.IndexController的session中的user为啥是list类型？导致在navigation.html中要${session.user[0].name}这样使用
