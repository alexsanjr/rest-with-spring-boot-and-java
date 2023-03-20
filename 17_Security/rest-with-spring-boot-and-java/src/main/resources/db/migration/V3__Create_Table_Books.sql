CREATE TABLE books (
  id SERIAL PRIMARY KEY,
  author TEXT,
  launch_date TIMESTAMP NOT NULL,
  price decimal(65,2) NOT NULL,
  title TEXT
);
