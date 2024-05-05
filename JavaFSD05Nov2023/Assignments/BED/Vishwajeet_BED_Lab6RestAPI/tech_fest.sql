-- create database tech_fest
-- use tech_fest

CREATE TABLE tech_fest.users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL,
    INDEX idx_username (username) -- Add index on username column
);

CREATE TABLE tech_fest.user_roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username)
);

CREATE TABLE tech_fest.students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    course VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL
);


-- Insert sample user data
INSERT INTO tech_fest.users (username, password, enabled) VALUES
('admin', '$2a$12$0AyIfMU39uWnj3w.8R5mv.mJBmeZFeOhytpMmDr40cjsalIT7fBjW', true), -- password is 'adminpassword' (BCrypt hashed)
('user', '$2a$12$NiAeMZXI4BGSC2cJ..zC/OgYeJKx0q4wm4P8qytVSvBN3nY8eNJNK', true); -- password is 'password' (BCrypt hashed)


-- Insert sample user roles
INSERT INTO tech_fest.user_roles (username, role) VALUES
('admin', 'ADMIN'),
('user', 'USER');

-- Insert sample student data
INSERT INTO tech_fest.students (id, first_name, last_name, course, country) VALUES
(1, 'Suresh', 'Reddy', 'B.Tech', 'India'),
(2, 'Murali', 'Mohan', 'B.Arch', 'Canada'),
(3, 'Daniel', 'Denson', 'B.Tech', 'New Zealand'),
(4, 'Tanya', 'Gupta', 'B.Com', 'USA');