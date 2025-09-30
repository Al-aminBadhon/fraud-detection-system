INSERT INTO roles (name) VALUES ('ROLE_ADMIN'), ('ROLE_OFFICER'), ('ROLE_CUSTOMER');

-- create admin user: username=admin password=password (bcrypt)
INSERT INTO users (id, username, password, email, enabled)
VALUES (1, 'admin', '$2a$10$yJf9vZqg3e0oH3L6g1cG9eWqWqz7YhO2QZbJ1fOQeZk2v5z0wqM6a', 'admin@example.com', true);

-- map admin to role
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id FROM users u, roles r WHERE u.username='admin' AND r.name='ROLE_ADMIN';
