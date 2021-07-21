> Swagger Documentation link: `http://localhost:8080/swagger-ui/index.html`

> Resources:
 - Department: /dept
 - Project: /project
 - Employee: /emp

###API to Retrieve all employees of a project: 
API URL: `/dept/{departCode}/project/{projCode}/emp`

Sample URL to retrieve all employees of a project: `http://localhost:8080/dept/D203/project/P2031/emp`

###API to Dis-associate an employee from a project: 
API URL: `/dept/{departCode}/project/{projCode}/emp/{empCode}`

Sample URL to disassociate an employee from a project: `http://localhost:8080/dept/D203/project/P2031/emp/E30008`


### Table Creation Scripts:

Schema Name: demo

- dept:
CREATE TABLE `dept` (
  `departcode` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `dept_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`departcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci

- employee:
CREATE TABLE `employee` (
  `empcode` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `emp_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`empcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci

- project:
CREATE TABLE `project` (
  `projcode` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `project_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `departcode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`projcode`),
  KEY `departcode` (`departcode`),
  CONSTRAINT `departcode` FOREIGN KEY (`departcode`) REFERENCES `dept` (`departcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci

- project_employee:
CREATE TABLE `project_employee` (
  `projcode` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `departcode` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `empcode` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`projcode`,`departcode`,`empcode`),
  KEY `departcode` (`departcode`),
  KEY `empcode` (`empcode`),
  CONSTRAINT `project_employee_ibfk_1` FOREIGN KEY (`projcode`) REFERENCES `project` (`projcode`),
  CONSTRAINT `project_employee_ibfk_2` FOREIGN KEY (`departcode`) REFERENCES `dept` (`departcode`),
  CONSTRAINT `project_employee_ibfk_3` FOREIGN KEY (`empcode`) REFERENCES `employee` (`empcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci