DROP DATABASE if exists dontforget_test;
CREATE DATABASE if not exists dontforget_test;
GRANT ALL ON dontforget_test.* TO dontforget@localhost IDENTIFIED BY "d0ntf0rg3t";
GRANT CREATE TEMPORARY TABLES ON dontforget_test.* TO dontforget@localhost IDENTIFIED BY "d0ntf0rg3t";
FLUSH PRIVILEGES;
ALTER DATABASE dontforget_test DEFAULT CHARACTER SET utf8;
