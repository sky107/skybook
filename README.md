# skybook

-------

Goto https://start.spring.io/

Download zip with predepencies for spring boot with lombok

Run as a springboot applicaiton in STS


--------

By default you application.yml might not pick  add below lines in porm.xml

```
spring:
  h2:
    console:
      enabled: true
      path: /h2
      ```

``
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-configuration-processor</artifactId>
</dependency>
``
