CREATE TABLE user
(
  username VARCHAR(20),
  mail VARCHAR(100),
  password VARCHAR(20),
  eventId NUMERIC(10)
);

ALTER TABLE user ADD COLUMN id NUMERIC(20) PRIMARY KEY;

INSERT INTO user (username, mail, password, eventId) VALUES ('kuba', 'kuba@op.pl', 'siema12', 1);

