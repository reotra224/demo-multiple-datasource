
CREATE TABLE potential_students (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  age INT
);

INSERT INTO potential_students (name, age) VALUES ('Alice', 22);
INSERT INTO potential_students (name, age) VALUES ('Ibou', 35);
INSERT INTO potential_students (name, age) VALUES ('Afana', 40);
INSERT INTO potential_students (name, age) VALUES ('Nene', 20);