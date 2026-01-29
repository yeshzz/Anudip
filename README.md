Project Documentation
Digital Evidence Management System
1. Project Title

Digital Evidence Management System Using Java, JDBC, and MySQL

2. Objective

The objective of this project is to store, manage, and view digital evidence records in a secure and organized way using Java as the core programming language, JDBC for database connectivity, and MySQL as the backend database.

Key Goals:

Capture case-related digital evidence.

Generate a hash for each evidence to maintain integrity.

View a list of all evidence records.

Demonstrate the DAO design pattern in Java.

3. Tools & Technologies Used
Tool/Technology	Version/Purpose
Java SE	Core programming, OOP concepts
JDBC	Database connectivity
MySQL	Relational database management
IDE	Eclipse / IntelliJ / NetBeans
MySQL Connector JAR	JDBC driver for MySQL
4. System Design
4.1 Package Structure
project
 ┣ dao
 │   └── EvidenceDAO.java          // DAO interface
 ┣ daoimpl
 │   └── EvidenceDAOImpl.java      // DAO implementation
 ┣ dto
 │   └── EvidenceDTO.java          // Data Transfer Object
 ┣ service
 │   └── EvidenceService.java      // Business logic
 ┗ main
     └── MainApp.java              // Program entry point

4.2 Database Table

Database Name: evidence
Table Name: evidence

CREATE DATABASE evidence;
USE evidence;

CREATE TABLE evidence (
    evidence_id INT AUTO_INCREMENT PRIMARY KEY,
    case_id VARCHAR(50),
    description VARCHAR(255),
    hash_value VARCHAR(100),
    uploaded_by INT
);


Table Description:

Column Name	Data Type	Description
evidence_id	INT	Unique ID (Primary Key)
case_id	VARCHAR(50)	Case identifier
description	VARCHAR(255)	Evidence description
hash_value	VARCHAR(100)	SHA-256 hash of the evidence description
uploaded_by	INT	User ID of uploader
5. Modules / Classes
5.1 DTO Class – EvidenceDTO

Holds evidence data.

Contains private attributes with getters and setters.

Includes default and parameterized constructors.

5.2 DAO Interface – EvidenceDAO

Declares database operations:

addEvidence(EvidenceDTO evidence)

getAllEvidence()

5.3 DAO Implementation – EvidenceDAOImpl

Implements the DAO interface.

Contains JDBC logic:

Connects to MySQL database.

Inserts new evidence into the table.

Fetches all evidence.

Generates hash for evidence description for integrity check.

5.4 Service Class – EvidenceService

Handles business logic.

Calls DAO methods for:

Registering new evidence.

Viewing all evidence.

Separates business logic from data access.

5.5 Main Class – MainApp

Entry point of the application.

Provides console menu:

Add Evidence

View Evidence List

Exit

Reads input using Scanner.

Calls service layer for operations.

6. Features / Functionalities

Add Evidence:

User enters Case ID and Description.

System generates a hash of the description.

Record is stored in the database.

View Evidence:

Retrieves all evidence from the database.

Displays ID, Case ID, Description, Hash, Uploaded By.

Menu-driven console application for ease of use.

7. Sample Input / Output
Adding Evidence
Enter Case ID: CASE-101
Enter Description: Email server log file
Evidence added successfully.

Viewing Evidence
------ Evidence List ------
Evidence ID : 1
Case ID     : CASE-101
Description : Email server log file
Hash Value  : 123456abcdef...
Uploaded By : 1
----------------------------

8. Flow Chart / System Flow
[MainApp] --> [EvidenceService] --> [EvidenceDAO Interface] --> [EvidenceDAOImpl (JDBC)]


Explanation:

User interacts with MainApp → calls Service Layer → invokes DAO methods → DAOImpl performs database operations.

9. Advantages

Simple Java + JDBC + MySQL implementation.

Clear DAO design pattern.

Easy to extend (add search, delete, user authentication).

Maintains evidence integrity using SHA-256 hash.

10. Limitations

Console-based (no GUI).

Single table only (can be extended to multi-table design).

No user authentication implemented.

11. Future Enhancements

Add user login module.

Implement tamper verification using hash.

Add GUI (Swing / JavaFX).

Add search and delete functionality.

Export evidence list to PDF/Excel.

12. Conclusion

The Digital Evidence Management System demonstrates a simple yet professional Java project using DAO architecture, JDBC, and MySQL.
It teaches core concepts:

Object-Oriented Programming

Database connectivity

Data encapsulation and separation of concerns

This system can be extended into a full-fledged forensic application in the future.
