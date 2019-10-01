## 基于Spring Boot 的社区

## 命令
git commit --amend --no-edit

- commit后需要修改说明信息，执行此命令（改变最近一次提交命令）:
`git commit --amend`
- 运行命令创建数据库脚本：`mvn flyway:migrate`

- `mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate`