<h1 align="center">
  <br>
  <img src="jamal.jpg" alt="Jamal Logo" width="200">
  <br>
  JAVA MAIL ASSISTANCE LIBRARY.
  <br>
</h1>

<p align="center">
  A Spring boot library for mail communication(Sending).
</p>

<p align="center">
  <a href="#features">Features</a> |
  <a href="#prerequisites">Prerequisites</a> |
  <a href="#mavenCentralDependency">Maven Central/Repository Dependency</a> |
  <a href="#libraryImportation">Library Importation</a> |
  <a href="#dependencyInjection">Dependency Injection</a> 
  <a href="#usage">Usage</a> |
  <a href="#privacy">Privacy</a> |
  <a href="#clone">Clone </a> 
</p>


## <a id="features"></a> Features
```bash
 - This is a java (SpringBoot) library to be used for mail communication(Sending)
 - It uses JavaMailSender
 - It accepts any type of email body
 - It works with any java version strating with java 8
 - It can be used by both Maven and Gradle 
 - It can be used in Java Core and Any Java Framework (Spring, SpringBoot, Kotlin)
 - It is simple to import and use
```

## <a id="prerequisites"></a> Prerequisites
```bash
- Any Java version (>= java 8)
```
## <a id="libraryImportation"></a>Library Importation
<a id="mavenCentralDependency"></a>
### <a id="mavenCentralDependency"></a>Maven Central Or Maven Repository Dependency
- For Gradle Project
```bash
  implementation 'io.github.jamalakida:java-mail-assistance-library:1.0.0'
```

-  For Maven Project
```bash
<dependency>
    <groupId>io.github.jamalakida</groupId>
    <artifactId>java-mail-assistance-library</artifactId>
    <version>1.0.0</version>
</dependency>
```

- For Kotlin, SBT, Ivy, Grape, Leiningen, Buildr ->
  <a href="https://central.sonatype.com/artifact/io.github.jamalakida/java-mail-assistance-library">Maven Central</a> | <a href="https://mvnrepository.com/artifact/io.github.jamalakida/java-mail-assistance-library/1.0.0">Maven Repository</a> 

## <a id="responses"></a> Response Involved
- <a href="#usage-single-data">Normal Data Response</a>

## <a id="usage"></a> Usage  
Steps: 
### A. Import libray as:
- <a href="#libraryImportation">Dependency</a>

###  B. Add Mail Configuration properties in application.properties or bootstrap.properties
```bash
Example: 

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-gmail-email@gmail.com
spring.mail.password=your-gmail-password
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.auth=true

    
```

### C. Instantiate the bean of the imported Remote Assistance Library (Use one the following technique)
- By Annotation: EnableMailAssistance
```bash
@EnableMailAssistance 
```

### <a id="dependencyInjection"></a> D. Dependency Injection (In a class, Abstract or Interface)
```bash
  @Autowired
    protected MailAssistance mailAssistance;
    
```


### E. <a id="usage-single-data"></a> Usage
###### 01. FOR SENDING TO SINGLE RECIPIENT:
- Sending email:
```bash
Example: 
  
 mailAssistance.sendMail("kennydoe@gmail.com", "janedoe@gmail.com",
                "TESTING", "Hello Jamal");
```

- Corresponding success Response:
```bash
Example: 
  
   {
     "error":false,
     "message":"Email sent to janedoe@gmail.com"
   }
```

- Corresponding failure Response:
```bash
Example: 
  
   {
     "error":false,
     "message":"Failed to send Email to janedoe@gmail.com"
   }
```

###### 02. FOR SENDING TO MULTIPLE RECIPIENTS:
- Sending email;
```bash
Example: 
  
    mailAssistance.sendMail("noreply@pccb.go.tz", List.of("johndoe@gmail.com", "janedoe@gmail.com"),
                "TESTING", "Hello Jamal");
```

-  Corresponding success Response:
```bash
Example: 

    [
      {
         "error":false,
         "message":"Email sent to janedoe@gmail.com"
       },
       
      {
       "error":false,
       "message":"Email sent to johndoe@gmail.com"
     }
    ]
 
```

-  With failure Response:
```bash
Example: 

    [
      {
         "error":false,
         "message":"Failed to send Email to janedoe@gmail.com"
       },
       
      {
       "error":false,
       "message":"Email sent to johndoe@gmail.com"
     }
    ]
```

## <a id="privacy"></a> Privacy
```bash
This is a public library. It is available and can be used by any one.
```

## <a id="clone"></a> Clone the repository
```bash
git clone https://github.com/jamalakida/java-mail-assistance-library.git
```


