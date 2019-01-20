# CRM
A CRM Project (ON Web) from Self-learning.



> 系统开发的步骤、流程，以及一些注意点



&nbsp;

### 环境

- 项目，Jar包

- Struts：struts.xml,web.xml中的核心过滤器

- Hibernate：Spring托管，映射文件保留

- Spring：applicationContext.xml，web.xml核心监听器

- properties：JDBC连接，log4j

  ```xml
  <!-- spring核心监听器 -->
  <listener>
      <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  <context-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  <!-- struts核心过滤器 -->
  <filter>
      <filter-name>struts2</filter-name>
      <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
  </filter>
  <filter-mapping>
      <filter-name>struts2</filter-name>
      <url-pattern>/*</url-pattern>
  </filter-mapping>
  ```

- 包结构等

&nbsp;

### 开发

#### 用户模块

- 传统的Web(Action)-Service-Dao分层；Spring配置Bean，Action交给Spring进行配置，注入Service；Service中注入Dao，Dao使用HibernateDaoSupport进行Hibernate模板操作的支持——同时需要在Dao的Bean声明中注入一个SessionFactory。
- Action使用Struts的模型驱动，从表单数据封装到私有属性中（需要在Action中提供一个已实例化的对象）；
- 加密处理：MD5对登录控制中的密码进行加密后，转存到数据库中，使用一个MD5Utils的工具类。
- 事务管理：在所有Service中需要进行事务控制的地方，配置事务管理。Spring中配置事务管理器(提供sessionFactory属性的注入)，开启事务管理。在需要的Service类中，打上注解`@Transactional`





































#### 问题：

1. 页面返回跳转是redirect时，actionerror的值就获取不到了么？不是，actionerror在值栈中。