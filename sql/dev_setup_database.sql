DROP DATABASE if exists dontforget_dev;
CREATE DATABASE if not exists dontforget_dev;
GRANT ALL ON dontforget_dev.* TO dontforget@localhost IDENTIFIED BY "d0ntf0rg3t";
GRANT CREATE TEMPORARY TABLES ON dontforget_dev.* TO dontforget@localhost IDENTIFIED BY "d0ntf0rg3t";
FLUSH PRIVILEGES;
ALTER DATABASE dontforget_dev DEFAULT CHARACTER SET utf8;
