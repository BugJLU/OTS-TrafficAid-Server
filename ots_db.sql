CREATE TABLE user (
  id VARCHAR(255),
  type INT,
  emgContact VARCHAR(255),
  name VARCHAR(255),
  gender INT,
  idCode VARCHAR(255),
  plateNum VARCHAR(255),
  carType VARCHAR(255),
  contactInfo VARCHAR(255),
  mediHist VARCHAR(255),
  geoX VARCHAR(255),
  geoY VARCHAR(255),
  PRIMARY KEY (id),
  FOREIGN KEY (emgContact) REFERENCES user(id)
);

CREATE TABLE resource(
  id INT AUTO_INCREMENT,
  type INT,
  possessorId VARCHAR(255),
  name VARCHAR(255),
  PRIMARY KEY (id),
  FOREIGN KEY (possessorId) REFERENCES user(id)
);

CREATE TABLE contact(
  subjectId VARCHAR(255),
  objectId VARCHAR(255),
  groupType INT,
  intimacy DOUBLE,
  PRIMARY KEY (subjectId,objectId),
  FOREIGN KEY (subjectId) REFERENCES user(id),
  FOREIGN KEY (objectId) REFERENCES user(id)
);

select * from INFORMATION_SCHEMA.KEY_COLUMN_USAGE  where REFERENCED_TABLE_NAME='user';