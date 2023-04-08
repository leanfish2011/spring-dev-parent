# 基础库
> 各个服务使用的基础库
> 1.0-SNAPSHOT版本，springboot应用

## 使用方式
1. 各个工程pom中引用
```  
  <parent>
     <groupId>com.tim</groupId>
     <artifactId>spring-dev-parent</artifactId>
     <version>1.0-SNAPSHOT</version>
  </parent>
```
2. 再引用
```
    <dependency>
      <groupId>com.tim</groupId>
      <artifactId>dev-core</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency>
```
