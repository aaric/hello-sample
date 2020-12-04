# hello-sample

[![license](https://img.shields.io/badge/license-MIT-green.svg?style=flat&logo=github)](https://www.mit-license.org)
[![java](https://img.shields.io/badge/java-1.8-brightgreen.svg?style=flat&logo=java)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![spring](https://img.shields.io/badge/springboot-2.3.2-brightgreen.svg?style=flat&logo=spring)](https://docs.spring.io/spring-boot/docs/2.3.x-SNAPSHOT/reference/htmlsingle)
[![gradle](https://img.shields.io/badge/gradle-6.7-brightgreen.svg?style=flat&logo=gradle)](https://docs.gradle.org/6.7/userguide/installation.html)
[![build](https://github.com/aaric/hello-sample/workflows/build/badge.svg)](https://github.com/aaric/hello-sample/actions)
[![release](https://img.shields.io/badge/release-0.2.0-blue.svg)](https://github.com/aaric/hello-sample/releases)

> Hello Example.

## 1. 子项目命名规范

|No.|Name|Path|Remark|
|:-:|----|----|------|
|1|`hello-pojo`||*实体模块*|
|2|`hello-common`||*共享模块*|
|3|`hello-server-*`||*业务层*|
|4|`hello-web-admin`|`/api/admin/v1/...`|*管理端API*|
|5|`hello-web-portal`|`/api/portal/v1/...`|*门户API*|
|6|`hello-web-applet`|`/api/applet/v1/...`|*小程序API*|
