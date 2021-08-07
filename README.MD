# 基础库
> 各个服务使用的基础库

## 使用方式
1. 各个工程pom中引用
```  
  <parent>
     <groupId>com.tim</groupId>
     <artifactId>spring-dev-parent</artifactId>
     <version>0.0.1-SNAPSHOT</version>
  </parent>
```
2. 再引用
```
    <dependency>
      <groupId>com.tim</groupId>
      <artifactId>dev-core</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>
```
