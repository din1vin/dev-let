DROP TABLE IF EXISTS users;

CREATE TABLE user
(
    id    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name  varchar(35),
    phone varchar(35)
);