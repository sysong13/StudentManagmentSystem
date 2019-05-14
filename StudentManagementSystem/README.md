### 界面预览

### 后端使用mysql数据库 + JDBC + DAO设计模式 + Servlet产生JSON数据

### 前端使用ajax获取JSON数据，jquery实现渲染

### 运行方法：
#### 1.1 pre Requires
  * jdk
  * maven
  * tomcat
  * mysql
#### 1.2 本地编译
* git clone项目到本地

* 进入StudentManagementSystem文件夹
* 命令行输入： mvn clean install
* 编译成功后在 `StudentManagementSystem/my-webapp/target` 下找到 my-webapp.war
* 将war包放在Tomcat目录的webapp下，启动tomcat
* 浏览器输入：localhost:8080/my-webapp/html/index.html
