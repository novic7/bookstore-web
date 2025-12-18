-- src/main/resources/data.sql

-- Пароль "password" захэширован с помощью BCrypt: $2a$10$T8Z.X/R9hR0.Vb3G/WbO.u.k/Q.f.Z9p.Q8.J.y.C.q.W.e.w.v.a.0

INSERT INTO users (id, username, password, email, role) VALUES
    (1, 'user', '$2a$10$T8Z.X/R9hR0.Vb3G/WbO.u.k/Q.f.Z9p.Q8.J.y.C.q.W.e.w.v.a.0', 'user@example.com', 'ROLE_USER');

INSERT INTO users (id, username, password, email, role) VALUES
    (2, 'admin', '$2a$10$T8Z.X/R9hR0.Vb3G/WbO.u.k/Q.f.Z9p.Q8.J.y.C.q.W.e.w.v.a.0', 'admin@example.com', 'ROLE_ADMIN');

-- Добавьте тестовые книги в БД
INSERT INTO books (id, title, author, category, publication_year, price_buy, status, availability) VALUES
                                                                                                       (1, 'Spring Boot in Action', 'Craig Walls', 'Programming', 2015, 49.99, 'AVAILABLE', 5),
                                                                                                       (2, 'The Hitchhikers Guide to the Galaxy', 'Douglas Adams', 'Fiction', 1979, 19.99, 'AVAILABLE', 10);
