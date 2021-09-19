
<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
        <li><a href="#technologies">Technologies</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <ul></ul>
        <li><a href="#installation">Installation</a></li>
</ul>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
  </ol>
</details>

# School Management System

<!-- ABOUT THE PROJECT -->
## About The Project
## Dördüncü hafta ödevi son teslim tarihi : 06.08.2021(Gelecek hafta pazartesi) - Saat =>  23:30

![homework](https://user-images.githubusercontent.com/45206582/131386439-6727321a-5a50-4c20-9413-ea4013013434.PNG)

![UML_classDiagram](https://user-images.githubusercontent.com/80898514/133933700-fe0c7d5a-9b3a-435a-b914-cb49d73a33f8.jpg)

* According to UML Diagram, within the Controller/Service/Repository logic a project created. CRUD operations such as save, update, delete added the project. CRUD operations implemented with Swagger UI. H2 database is used for database connection.


### Technologies
- Java 8
- Spring Boot
- Spring Web
- Lombok
- Maven
- JPA / Hibernate
- H2 Database
- MapStruct
- Swagger UI



### Built With

You should have Maven and JDK 1.8 to  built the project.
* [Maven](https://maven.apache.org/download.cgi)
* [JDK 1.8](https://www.oracle.com/java/technologies/downloads/#java8)




<!-- GETTING STARTED -->
## Getting Started



### Installation

1. Firstly, you should clone repo.

` git clone https://github.com/113-GittiGidiyor-Java-Spring-Bootcamp/fourth-homework-Nevzatcs.git `

2. Then, change your directory to:

` cd fourth-homework-Nevzatcs/hw04 `

3. Finally, write down it on the cmd:

` mvn spring-boot:run `



<!-- USAGE EXAMPLES -->
## Usage
After run the project:
1. You should  open this URL : http://localhost:8080/swagger-ui.html#/ to see and make the CRUD operations that can be done.
2. You can get informations about operations that you've done in Swagger by reaching H2 database :  http://localhost:8080/h2-console by clicking URL you can go to H2 console.(There is no password for your access, you can change password in DataSourceConfiguration file.)

### Swagger UI
You can use Swagger, as I show in images.
Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.
* Step 1
  ![swagger](https://user-images.githubusercontent.com/80898514/133933611-6d755adf-0ba3-460a-82ed-6c5cdd60e88c.jpg)

* Step 2
  ![try it out](https://user-images.githubusercontent.com/80898514/133933617-4fd88ba3-8fda-4d1a-80fb-d7f56e4dbd94.jpg)

* Step 3
  ![executee](https://user-images.githubusercontent.com/80898514/133933623-45926c7d-04f1-4197-9137-a4b7d6441314.jpg)


### H2 Database
* After opening the URL, you will get this page. By clicking connect, you can see the tables and you can monitor the table and its informations.
  ![h2](https://user-images.githubusercontent.com/80898514/133933629-c25dd79d-eed5-4fe0-85f4-375b9d900bef.jpg)

* Here is the s-examples of informations in database.
  ![transaction info](https://user-images.githubusercontent.com/80898514/133933633-d1cbb69f-8c29-4a3b-925b-c1cea709454d.jpg)
  ![exceptionlog_example](https://user-images.githubusercontent.com/80898514/133933641-dbcc6199-6c9f-4cbb-b5f0-fbf9ec798bb6.jpg)







<!-- CONTRIBUTING -->
## Contributing

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See [LICENSE](https://github.com/113-GittiGidiyor-Java-Spring-Bootcamp/fourth-homework-Nevzatcs/blob/main/LICENSE) for more information.



<!-- CONTACT -->
## Contact

Nevzat Can Samur - [@linkedin](https://www.linkedin.com/in/nevzatcansamur/) 
