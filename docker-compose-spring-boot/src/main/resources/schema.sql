DROP TABLE IF EXISTS Task;
CREATE TABLE Task (
  id IDENTITY,
  user_id BIGINT,
  text VARCHAR(4000),
  created_at DATETIME,
  updated_at DATETIME
);


DROP TABLE IF EXISTS User;
CREATE TABLE User (
  id IDENTITY,
  name VARCHAR(50),
  email VARCHAR(100),
  created_at DATETIME,
  updated_at DATETIME
);