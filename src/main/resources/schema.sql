CREATE TABLE IF NOT EXISTS Book (
    id INT NOT NULL ,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    "year" VARCHAR(4) NOT NULL,
    "description" VARCHAR(1000) NOT NULL,
    image_url VARCHAR(500) NOT NULL,
    "status" VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);