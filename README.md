Spring struts hibernate login register with authroztion and remeber me best practice
=====
This project implements a simple login register and edit employees information webapp using Spring4 struts2 and hibernate3.
It is really helpful for those who learn the framework for the first time
Screenshot
====
Login form

![login](https://raw.githubusercontent.com/wssbwssbwssb/spring-struts-hibernate-login-register-with-authroztion-and-remeber-me-best-practice/master/screenshot/login.png "login")

Register form

![register](https://raw.githubusercontent.com/wssbwssbwssb/spring-struts-hibernate-login-register-with-authroztion-and-remeber-me-best-practice/master/screenshot/register.png "register")

List form

![list](https://raw.githubusercontent.com/wssbwssbwssb/spring-struts-hibernate-login-register-with-authroztion-and-remeber-me-best-practice/master/screenshot/list.png "list")

Features
---------
  * Remember me function: login with cookies when a new session is created.
  * Series and Token: Series and tokens is generated and stored in database like the way discused [here](http://stackoverflow.com/questions/14122365/struts2-remember-me) . An alternate way to implement the function is using the Spring Security like [here](http://www.mkyong.com/spring-security/spring-security-remember-me-example/).
  * Only the owner can access the item that create by him
Reference
----------
* [Struts2 remember me](http://stackoverflow.com/questions/14122365/struts2-remember-me)
* [Spring Security Remember Me Example](http://www.mkyong.com/spring-security/spring-security-remember-me-example/)
* [Spring 4 + Struts 2 + Hibernate Integration Tutorial](http://howtodoinjava.com/2014/05/14/spring-4-struts-2-hibernate-integration-tutorial/)
* [在struts2中使用拦截器（Interceptor）控制登录和权限](http://dengyin2000.iteye.com/blog/149260)
* [Base64 and other routine](https://github.com/spring-projects/spring-security/tree/master/web/src/main/java/org/springframework/security/web/authentication/rememberme)