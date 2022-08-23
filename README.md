# skybook

-------



<img width="1024" alt="Screenshot 2022-08-24 at 12 49 39 AM" src="https://user-images.githubusercontent.com/69970001/186259571-cb945d9c-6b00-483a-84ae-f1cb63ea3bd6.png">





----------


### Debug Notes below

Goto https://start.spring.io/

Download zip with predepencies for spring boot with lombok

Run as a springboot applicaiton in STS


--------

By default you application.yml might not pick  add below lines in pom.xml

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
