

-- create database emsdb
-- use emsdb
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles (
    user_id BIGINT,
    role_id BIGINT,  -- Modified to BIGINT
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE employees (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

INSERT INTO roles (name) VALUES ('ADMIN'), ('USER');

INSERT INTO users (username, password) VALUES 
    ('admin', '$2a$12$f57sh5hPAK1UemTe9jrmIuYkb6HLPGzcDtK0v20zuwsjfMfsoCJwW'), 
    ('user', '$2a$12$OBZ3/R3ytqUVApQPCfqyz.d8xj16ztmke1HVH6g5XelLjC.tBdtrm');

INSERT INTO user_roles (user_id, role_id) VALUES
    ((SELECT id FROM users WHERE username = 'admin'), (SELECT id FROM roles WHERE name = 'ADMIN')),
    ((SELECT id FROM users WHERE username = 'user'), (SELECT id FROM roles WHERE name = 'USER'));

INSERT INTO employees (first_name, last_name, email) VALUES 
    ('John', 'Doe', 'john.doe@example.com'),
    ('Jane', 'Doe', 'jane.doe@example.com'),
    ('Alice', 'Smith', 'alice.smith@example.com');





