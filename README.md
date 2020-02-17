## 祥子

## 资料
[es社区](https://elasticsearch.cn/)
[bootstrap官方文档](https://v3.bootcss.com/)
[github dev](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
[okhttp](https://square.github.io/okhttp/)
[mybatis](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-test-autoconfigure/index.html)
[thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)

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
```

## 笔记
1.textarea 用 th:text回显，而input 用th:value回显
2.fastjson 能将下划线自动转成驼峰

## 疑问
1.PageDTO中 pages 为什么要new出来 其它变量无需new
2.select中为啥用count(1)不用coun(*
3.在加入拦截器后，如果有@EnableWebMvc注解就会找不到资源，去掉就好了
