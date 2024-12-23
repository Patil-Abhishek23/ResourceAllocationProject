# ResourceAllocationProject
A large scale organization requires a solution to manage the resource allocation to projects based on the skillset. Solution should be providing the list of resources based on the skills required for the given project. It should be able to accept multiple input e.g. skillset, experience. Below are the some of the data pointer listed.
Estute Project


**Requirments To start the Application**

——>Go to the application.properties file and the your database credentials.

——> Insert Query for Inserting Data into Employees Table

INSERT INTO employees (resource_Id, Resource_Name, experience, Skills) VALUES
(1, 'Dennis', 4, 'Java,Spring,JMS,MySQL,Angular,React,Web services,Nodejs'),
(2, 'Thompson', 7, 'Java,Oracle,React,Angular,Javascript,REST API'),
(3, 'Kim', 12, 'Java,JSP,Spring,Oracle,MySQL,PostgreSQL,Mongo,Rest API,Web services,Docker,Redis'),
(4, 'Aisha', 9, 'Angular,Javascript,Nodejs,Rest API,Web services,Docker,SQL server,PostgreSQL'),
(5, 'Maya', 5, 'Spring,SpringBoot,Hibernate,MySQL,PostgreSQL,Nodejs,Python'),
(6, 'Kumar', 3, 'Java,Redis,MySQL,Javascript');



——> I have created two API’s employees matching all skills and at least one skill.

 Scenario 1 : To check the API below I have provided curl command For any one of the skill matches.

curl --location --request GET 'http://localhost:8080/api/employees/anyoneskill?skills=Mysql&skills=React&maxExperience=12' \
--header 'Content-Type: application/json' \
--data '{'

Example output

￼<img width="1440" alt="AnyOneSkill" src="https://github.com/user-attachments/assets/e0235b04-9d1e-4b71-80b0-7bb360455438" />


 Scenario 2 : To check the API below I have provided curl command for all the skill matches.

curl --location --request GET 'http://localhost:8080/api/employees/filter?skills=Mysql' \
--header 'Content-Type: application/json' \
--data '{
    "id":10,
    "employeeName": "John Doe",
    "experience": 5,
    "skills": "Java, Spring, SQL"
},

Example Output
￼

<img width="1440" alt="Match all Skills" src="https://github.com/user-attachments/assets/a75a8620-e249-4390-86dd-41771284def4" />



NOTE:Skills and experiences  provided by user.
