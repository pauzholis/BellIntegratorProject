CREATE TABLE IF NOT EXISTS Organization (
  id        INTEGER PRIMARY KEY AUTO_INCREMENT,
  version   INTEGER      NOT NULL,
  name      VARCHAR(255) NOT NULL,
  full_name VARCHAR(255) NOT NULL,
  inn       NUMERIC(10) UNSIGNED UNIQUE,
  kpp       NUMERIC(9) UNSIGNED,
  address   VARCHAR(255),
  phone     INTEGER,
  isActive  BOOLEAN
);

CREATE TABLE IF NOT EXISTS Office (
  id              INTEGER PRIMARY KEY AUTO_INCREMENT,
  version         INTEGER      NOT NULL,
  address         VARCHAR(50)  NOT NULL,
  organization_id INT UNSIGNED NOT NULL,
  name            VARCHAR(255) NOT NULL,
  phone           INTEGER,
  isActive        BOOLEAN
);

CREATE TABLE IF NOT EXISTS User (
  id           INTEGER PRIMARY KEY AUTO_INCREMENT,
  version      INTEGER      NOT NULL,
  office_id    INT UNSIGNED NOT NULL,
  first_name   VARCHAR(255) NOT NULL,
  second_name  VARCHAR(255) NOT NULL,
  middle_name  VARCHAR(255) NOT NULL,
  position     VARCHAR(255),
  phone        INTEGER,
  isIdentified BOOLEAN
);

CREATE TABLE IF NOT EXISTS User_Activation (
  id      INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT UNSIGNED NOT NULL,
  hash    VARCHAR(255) NOT NULL,
  version INTEGER      NOT NULL
);

CREATE TABLE IF NOT EXISTS Registration_Data (
  id       INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id  INT UNSIGNED NOT NULL,
  login    VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  name     VARCHAR(255) NOT NULL,
  version  INTEGER      NOT NULL
);

CREATE TABLE Notification (
  id      INT UNSIGNED          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  channel ENUM ('EMAIL', 'SMS') NOT NULL,
  adress  VARCHAR(255)          NOT NULL,
  massage VARCHAR(255)          NOT NULL,
  version INTEGER               NOT NULL
);

CREATE TABLE IF NOT EXISTS Document (
  id      INTEGER PRIMARY KEY AUTO_INCREMENT,
  version INTEGER      NOT NULL,
  user_id INT UNSIGNED NOT NULL,
  code    INTEGER,
  name    VARCHAR(255) NOT NULL,
  number  INTEGER,
  date    DATE         NOT NULL
);

CREATE TABLE IF NOT EXISTS Citizenship (
  id      INTEGER PRIMARY KEY AUTO_INCREMENT,
  version INTEGER      NOT NULL,
  user_id INT UNSIGNED NOT NULL,
  code    INTEGER,
  name    VARCHAR(255) NOT NULL
);

CREATE INDEX IX_Organization_Id
  ON Organization (id);
CREATE INDEX IX_Organization_Name
  ON Organization (name);
CREATE INDEX IX_Organization_Full_Name
  ON Organization (full_name);
CREATE INDEX IX_Organization_INN
  ON Organization (inn);
CREATE INDEX IX_Office_Id
  ON Office (id);
CREATE INDEX IX_Office_Organization_Id
  ON Office (organization_id);
CREATE INDEX IX_Office_Name
  ON Office (name);
CREATE INDEX IX_User_Id
  ON User (id);
ALTER TABLE Office
  ADD FOREIGN KEY (organization_id) REFERENCES Organization (id);
ALTER TABLE User
  ADD FOREIGN KEY (office_id) REFERENCES Office (id);
ALTER TABLE User_Activation
  ADD FOREIGN KEY (user_id) REFERENCES User (id);
ALTER TABLE Registration_Data
  ADD FOREIGN KEY (user_id) REFERENCES User (id);
ALTER TABLE Document
  ADD FOREIGN KEY (user_id) REFERENCES User (id);
ALTER TABLE Citizenship
  ADD FOREIGN KEY (user_id) REFERENCES User (id);