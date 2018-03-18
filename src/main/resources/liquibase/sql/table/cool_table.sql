CREATE TABLE cool_schema.cool_table (
  id         SERIAL PRIMARY KEY,
  mrn        VARCHAR(50) NOT NULL,
  last_name  VARCHAR(50) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  sex        VARCHAR(10) NOT NULL,
  age_value  INTEGER     NOT NULL,
  age_units  VARCHAR(50) NOT NULL,
  occupation VARCHAR(50) NOT NULL
);