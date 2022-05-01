DROP DATABASE IF EXISTS orderservicedb;
DROP USER IF EXISTS `orderadmin`@`%`;
DROP USER IF EXISTS `orderuser`@`%`;

CREATE DATABASE IF NOT EXISTS orderservicedb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `orderadmin`@`%` IDENTIFIED WITH mysql_native_password BY 'orderadmin';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
    CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `orderservicedb`.* TO `orderadmin`@`%`;

CREATE USER IF NOT EXISTS `orderuser`@`%` IDENTIFIED WITH mysql_native_password BY 'orderuser';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `orderservicedb`.* TO `orderuser`@`%`;