## 基于Spring Boot 的问答社区

### 环境
开发软件：IntelliJ IDEA
服务器：腾讯云 CentOS 7.6
Java版本：JDK 1.8

### 命令

- commit后需要修改说明信息，执行此命令（改变最近一次提交命令）:
`git commit --amend`
- 运行命令创建数据库脚本：`mvn flyway:migrate`

- 逆向工程 `mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate`

### 插件
[Markdown-editor.md](http://editor.md.ipandao.com/)

### 资料
[腾讯云 Java SDK](https://cloud.tencent.com/document/product/436/10199)