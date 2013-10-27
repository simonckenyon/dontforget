DROP DATABASE if exists dontforget;
CREATE DATABASE if not exists dontforget;
GRANT ALL ON dontforget.* TO dontforget@localhost IDENTIFIED BY "d0ntf0rg3t";
GRANT CREATE TEMPORARY TABLES ON dontforget.* TO dontforget@localhost IDENTIFIED BY "d0ntf0rg3t";
FLUSH PRIVILEGES;
ALTER DATABASE dontforget DEFAULT CHARACTER SET utf8;
