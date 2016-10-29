create table persons(
    id integer auto_increment primary key,
    email varchar(30),
    firstName varchar(30),
    lastName varchar(30),
    birthDay date,
    managerFullName varchar(100),
    professionalLevel varchar(30),
    primarySkill varchar (30),

    dateCreated date,
    createdByUser varchar(50),
    dateLastModified date,
    lastModifiedByUser varchar(50)
);

create table mentorshipPrograms(
    id integer auto_increment primary key,
    name varchar(50),
    location varchar(100),
    startDate date,
    endDate date,

    dateCreated date,
    createdByUser varchar(50),
    dateLastModified date,
    lastModifiedByUser varchar(50)
);