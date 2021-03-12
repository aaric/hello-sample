# hello-sample

[![license](https://img.shields.io/badge/license-MIT-green.svg?style=flat&logo=github)](https://www.mit-license.org)
[![java](https://img.shields.io/badge/java-1.8-brightgreen.svg?style=flat&logo=java)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![spring](https://img.shields.io/badge/springboot-2.3.2-brightgreen.svg?style=flat&logo=spring)](https://docs.spring.io/spring-boot/docs/2.3.x-SNAPSHOT/reference/htmlsingle)
[![gradle](https://img.shields.io/badge/gradle-6.7-brightgreen.svg?style=flat&logo=gradle)](https://docs.gradle.org/6.7/userguide/installation.html)
[![build](https://github.com/aaric/hello-sample/workflows/build/badge.svg)](https://github.com/aaric/hello-sample/actions)
[![release](https://img.shields.io/badge/release-0.8.0-blue.svg)](https://github.com/aaric/hello-sample/releases)

> Hello Example.

## 一、子模块命名规范

|No.|Name|Path|Remark|
|:-:|----|----|------|
|1|`hello-pojo`||*实体模块*|
|2|`hello-common`||*共享模块*|
|3|`hello-service-*`||*业务层*|
|4|`hello-web-admin`|`/api/v1/admin/...`|*管理端API*|
|5|`hello-web-portal`|`/api/v1/portal/...`|*门户API*|
|6|`hello-web-applet`|`/api/v1/applet/...`|*小程序API*|

## 二、`API` 规范遵循 `RESTFul` 风格

> 请求路径命名遵循`/api/{version}/{endpoint}/{package}/{class}`规则，例如：`/api/v1/admin/system/file`  
> `version`：*版本信息，例如：`v1`、`v2`等*  
> `endpoint`：*子模块，例如：`admin`、`portal`、`applet`等*  
> `package`：*功能集，即包名，例如：`system`、`rbac`等*  
> `class`：*功能，即类名，例如：`file`、`user`等*

|No.|Operating|Http Method|Remark|
|:-:|---------|-----------|------|
|1|`Create`|*POST*|`curl -X POST /api/v1/admin/system/file -d {}`|
|2|`Delete`|*DELETE*|`curl -X DELETE /api/v1/admin/system/file/{id}`|
|3|`Modify`|*PUT*|`curl -X PUT /api/v1/admin/system/file -d {}`|
|4|`Is Exist`|*HEAD*|`curl -X HEAD /api/v1/admin/system/file/{id}`|
|5|`Get One`|*GET*|`curl -X GET /api/v1/admin/system/file/{id}`|
|6|`Page`|*POST*|`curl -X POST /api/v1/admin/system/file/{index}/{size} -d {}`|

## 三、Validation内置校验注解说明

|No.|Name|Usage|Remark|
|:-:|:-:|---|---|
|1|`@Null`|被注释的元素必须为null|*例如：extendId*|
|2|`@NotNull`|被注释的元素不能为null|*例如：username*|
|3|`@NotEmpty`|被注释的字符串的必须非空，可以是空白字符串|*例如：username*|
|4|`@NotBlank`|被注释的字符串的必须非空，不能是空白字符串|*例如：username*|
|5|`@AssertTrue`|被注释的元素必须为true|*暂无*|
|6|`@AssertFalse`|被注释的元素必须为false|*暂无*|
|7|`@Min`|被注释的元素必须是一个数字，其值必须大于等于指定的最小值|*例如：age*|
|8|`@Max`|被注释的元素必须是一个数字，其值必须小于等于指定的最大值|*例如：age*|
|9|`@DecimalMin`|被注释的元素必须是一个数字，其值必须大于等于指定的最小值|*例如：salary*|
|10|`@DecimalMax`|被注释的元素必须是一个数字，其值必须小于等于指定的最大值|*例如：salary*|
|11|`@Negative`|被注释的元素必须是一个严格意义上的负数|*例如：countdown*|
|12|`@NegativeOrZero`|被注释的元素必须是一个负数或者0|*例如：countdown*|
|13|`@Positive`|被注释的元素必须是一个严格意义上正数|*例如：money*|
|14|`@PositiveOrZero`|被注释的元素必须是一个正数或者0|*例如：money*|
|15|`@Size`|被注释的元素的大小必须在指定的范围内（包含）|*例如：username, array*|
|16|`@Digits`|被注释的元素必须是一个数字，其值必须在可接受的范围内|*例如：money*|
|17|`@Past`|被注释的元素必须是一个过去的日期时间|*例如：date*|
|18|`@PastOrPresent`|被注释的元素必须是一个过去的日期时间或者是当前日期时间|*例如：date*|
|19|`@Future`|被注释的元素必须是一个将来的日期时间|*例如：date*|
|20|`@FutureOrPresent`|被注释的元素必须是一个将来的日期时间或者当前日期时间|*例如：date*|
|21|`@Pattern`|被注释的元素必须符合指定的正则表达式|*例如：string*|
|22|`@Email`|被注释的元素必须是电子邮箱地址|*例如：email*|
