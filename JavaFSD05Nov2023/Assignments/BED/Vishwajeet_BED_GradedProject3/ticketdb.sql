create database ticketdb
use ticketdb
CREATE TABLE ticketdb.ticket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    short_description VARCHAR(255),
    content TEXT,
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO ticketdb.ticket (title, short_description, content) VALUES
('Ticket 1', 'Issue with login page', 'Users are unable to login to the system.'),
('Ticket 2', 'Error in payment process', 'Payments are not processing correctly.'),
('Ticket 3', 'Feature request', 'Add a new feature to the dashboard.');
