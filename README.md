## 祥子

## 资料
[es社区](https://elasticsearch.cn/)
[bootstrap官方文档](https://v3.bootcss.com/)
[github dev](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
[okhttp](https://square.github.io/okhttp/)
[mybatis](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-test-autoconfigure/index.html)

## 工具
[画图](https://www.visual-paradigm.com/cn/)

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