CREATE TABLE gender (
  gender VARCHAR(6) PRIMARY KEY NOT NULL UNIQUE
);

INSERT INTO gender(gender) VALUES ('male');
INSERT INTO gender(gender) VALUES ('female');

CREATE TABLE activity_level (
  activity_level VARCHAR(20) PRIMARY KEY NOT NULL UNIQUE
);

INSERT INTO activity_level(activity_level) VALUES ('sedentary');
INSERT INTO activity_level(activity_level) VALUES ('somewhat_active');
INSERT INTO activity_level(activity_level) VALUES ('active');
INSERT INTO activity_level(activity_level) VALUES ('very_active');


CREATE TABLE goal (
  goal VARCHAR(8) PRIMARY KEY NOT NULL UNIQUE
);

INSERT INTO goal(goal) VALUES ('lose');
INSERT INTO goal(goal) VALUES ('maintain');
INSERT INTO goal(goal) VALUES ('gain');

CREATE TABLE user (
    id BIGINT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR(255),
    username VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    gender VARCHAR(6) REFERENCES gender(gender),
    date_of_birth DATE,
    body_mass_kg SMALLINT UNSIGNED,
    height_cm SMALLINT UNSIGNED,
    goal VARCHAR(8) REFERENCES goal(goal),
    goal_weight_kg SMALLINT UNSIGNED,
    activity_level VARCHAR(20) REFERENCES activity_level(activity_level)
);
