# hello-sample

[![license](https://img.shields.io/badge/license-MIT-green.svg?style=flat&logo=github)](https://www.mit-license.org)
[![java](https://img.shields.io/badge/java-1.8-brightgreen.svg?style=flat&logo=java)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![spring](https://img.shields.io/badge/springboot-2.3.2-brightgreen.svg?style=flat&logo=spring)](https://docs.spring.io/spring-boot/docs/2.3.x-SNAPSHOT/reference/htmlsingle)
[![gradle](https://img.shields.io/badge/gradle-7.2-brightgreen.svg?style=flat&logo=gradle)](https://docs.gradle.org/7.2/userguide/installation.html)
[![build](https://github.com/aaric/hello-sample/workflows/build/badge.svg)](https://github.com/aaric/hello-sample/actions)
[![release](https://img.shields.io/badge/release-0.14.1-blue.svg)](https://github.com/aaric/hello-sample/releases)

> Hello Example.

## 1 子模块命名规范

|No.|Name|Path|Remark|
|:---:|-----|-----|-----|
|1|`hello-pojo`||*实体模块*|
|2|`hello-common`||*共享模块*|
|3|`hello-service-*`||*业务层*|
|4|`hello-web-admin`|`/api/v1/admin/...`|*管理端API*|
|5|`hello-web-portal`|`/api/v1/portal/...`|*门户API*|
|6|`hello-web-applet`|`/api/v1/applet/...`|*小程序API*|

## 2 `API` 规范遵循 `RESTFul` 风格

> 请求路径命名遵循`/api/{version}/{endpoint}/{package}/{class}`规则，例如：`/api/v1/admin/system/file`  
> `version`：*版本信息，例如：`v1`、`v2`等*  
> `endpoint`：*子模块，例如：`admin`、`portal`、`applet`等*  
> `package`：*功能集，即包名，例如：`system`、`rbac`等*  
> `class`：*功能，即类名，例如：`file`、`user`等*

|No.|Operating|Http Method|Remark|
|:---:|-----|-----|-----|
|1|`Create`|*POST*|`curl -X POST /api/v1/admin/system/file -d {}`|
|2|`Delete`|*DELETE*|`curl -X DELETE /api/v1/admin/system/file/{id}`|
|3|`Modify`|*PUT*|`curl -X PUT /api/v1/admin/system/file -d {}`|
|4|`Is Exist`|*HEAD*|`curl -X HEAD /api/v1/admin/system/file/{id}`|
|5|`Get One`|*GET*|`curl -X GET /api/v1/admin/system/file/{id}`|
|6|`Page`|*POST*|`curl -X POST /api/v1/admin/system/file/{index}/{size} -d {}`|

## 3 Validation内置校验注解说明

|No.|Name|Usage|Remark|
|:---:|:---:|-----|-----|
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

## 4 Actuator端点路径说明

|No.|Method|Path|IsAuth|Remark|
|:---:|:---|-----|:---:|-----|
|1|`GET`|`/actuator/autoconfig`|true|*查看自动配置的使用情况*|
|2|`GET`|`/actuator/configprops`|true|*查看配置属性，包括默认配置*|
|3|`GET`|`/actuator/beans`|true|*查看bean及其关系列表*|
|4|`GET`|`/actuator/dump`|true|*打印线程栈*|
|5|`GET`|`/actuator/env`|true|*查看所有环境变量*|
|6|`GET`|`/actuator/env/{name}`|true|*查看具体变量值*|
|7|`GET`|`/actuator/health`|false|*查看应用健康指标*|
|8|`GET`|`/actuator/info`|false|*查看应用信息*|
|9|`GET`|`/actuator/mappings`|true|*查看所有url映射*|
|10|`GET`|`/actuator/metrics`|true|*查看应用基本指标*|
|11|`GET`|`/actuator/metrics/{name}`|true|*查看具体指标*|
|12|`POST`|`/actuator/shutdown`|true|*关闭应用*|
|13|`GET`|`/actuator/trace`|true|*查看基本追踪信息*|
|14|`GET`|`/actuator/prometheus`|false|*查看Prometheus监控指标*|

## 5 LADPSearch

### 5.1 Server

```bash
cat > docker-compose.yaml <<-'EOF'
version: '3'
services:
  openldap:
    image: bitnami/openldap:2.5
    container_name: openldap_community_edition
#    volumes:
#      - ./openldap_data:/bitnami/openldap
    environment:
      - LDAP_ROOT=dc=ldaptest,dc=com
      - LDAP_ADMIN_USERNAME=admin
      - LDAP_ADMIN_PASSWORD=admin123
      - LDAP_USER_DC=testdc
      - LDAP_GROUP=testgroup
      - LDAP_USERS=testuser
      - LDAP_PASSWORDS=testuser
    ports:
      - 1389:1389
      - 1636:1636
    restart: always
    deploy:
      restart_policy:
        condition: on-failure

EOF
docker-compose up -d
```

### 5.2 Client

#### 5.2.1 Install

```bash
yum install -y openldap-clients
```

#### 5.2.2 Login

##### 5.2.2.1 admin

> password -> `admin123`

```bash
ldapsearch -LLL -x -H ldap://127.0.0.1:1389 \
  -D "cn=admin,dc=ldaptest,dc=com" -b "dc=ldaptest,dc=com" -W
ldapsearch -LLL -x -H ldap://127.0.0.1:1389 \
  -D "cn=admin,dc=ldaptest,dc=com" -b "dc=ldaptest,dc=com" -w admin123
```

##### 5.2.2.2 other users

```bash
ldapsearch -LLL -x -H ldap://127.0.0.1:1389 \
  -D "cn=testuser,ou=testdc,dc=ldaptest,dc=com" -b "ou=testdc,dc=ldaptest,dc=com" -w testuser
```

## 6 OnlyOffice

> [Java with Spring Boot](https://api.onlyoffice.com/editors/example/javaspring)

### 6.1 Nginx V1 (**Recommend**)

```nginx
map $http_upgrade $connection_upgrade {
    default upgrade;
    '' close;
}

upstream onlydoc-servers {
    server 10.0.11.25:4000;
}

upstream onlyoffice-servers {
    server 10.0.11.25:8080;
}

server {
    listen       18080;
    server_name localhost;

    charset utf-8;

    # http -> integration
    location ^~ /onlydoc/ {
        proxy_pass http://onlydoc-servers/;
        proxy_set_header Host $host;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header X-Forwarded-Host $http_host/onlydoc;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Real-PORT $remote_port;
    }

    # http -> all
    location ^~ /onlyoffice/ {
        proxy_pass http://onlyoffice-servers/;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "upgrade";
        proxy_set_header Host $host;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header X-Forwarded-Host $http_host/onlyoffice;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Real-PORT $remote_port;
        proxy_connect_timeout 15s;
        proxy_read_timeout 120s;
        proxy_send_timeout 60s;
    }
}
```

### 6.2 Nginx V2 (**Key Path**)

```nginx
map $http_upgrade $connection_upgrade {
    default upgrade;
    '' close;
}

upstream onlydoc-servers {
    server 10.0.11.25:4000;
}

upstream onlyoffice-servers {
    server 127.0.0.1:8080;
}

server {
    listen       18080;
    server_name localhost;

    charset utf-8;

    # http -> integration
    location ^~ /onlydoc/ {
        proxy_pass http://onlydoc-servers/;
        proxy_set_header Host $host;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header X-Forwarded-Host $http_host/onlydoc;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Real-PORT $remote_port;
    }

    # http -> all
    location ^~ /onlyoffice/ {
        proxy_pass http://onlyoffice-servers/;
        proxy_set_header Host $host;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header X-Forwarded-Host $http_host/onlyoffice;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Real-PORT $remote_port;
    }

    # http -> rewrite
    location ^~ /onlyoffice/web-apps/ {
        rewrite ^/onlyoffice/web-apps/(.*)$ /onlyoffice/6.4.2-6/web-apps/$1 redirect;
    }

    # websocket
    location ^~ /onlyoffice/6.4.2-6/doc/ {
        proxy_pass http://onlyoffice-servers/6.4.2-6/doc/;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "upgrade";
        proxy_set_header Host $host;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header X-Forwarded-Host $http_host/onlyoffice;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Real-PORT $remote_port;
        proxy_connect_timeout 15s;
        proxy_read_timeout 120s;
        proxy_send_timeout 60s;
    }
}
```
