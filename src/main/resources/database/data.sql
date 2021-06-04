CREATE TABLE IF NOT EXISTS User
(
    `UserId`      int         NOT NULL AUTO_INCREMENT,
    `FirstName`   varchar(64) NOT NULL,
    `LastName`    varchar(64) NOT NULL,
    `Name`        varchar(500) NOT NULL,
    `Email`       varchar(64) NOT NULL,
    `DateOfBirth` DATE        NOT NULL,
    `City`        varchar(64),
    `Password`    varchar(64) NOT NULL,
    `Enabled`     bool,
    `Role`        varchar(128) DEFAULT 'USER',
    `DocumentId` int,
    PRIMARY KEY (`UserId`)
);


CREATE TABLE IF NOT EXISTS ConfirmationToken
(
    `ConfirmationTokenId` int           not null auto_increment,
    `CreatedAt`           datetime      not null,
    `ExpiresAt`           datetime      not null,
    `ConfirmedAt`         datetime,
    `Token`               nvarchar(255) not null,
    `UserId`              int,
    PRIMARY KEY (`ConfirmationTokenId`),
    FOREIGN KEY (`UserId`) REFERENCES User (`UserId`)
);
create table if not exists document
(
    `documentId` int NOT NULL AUTO_INCREMENT,
    `title`      nvarchar(5000),
    `userId`     int,
    `deletedOn`  datetime,
    `deletedBy`  int,
    `uploadDate` dateTime,
    `fullPath`   nvarchar(500),
    `fileName`   nvarchar(100),
    `tags`       nvarchar(1000),
    `size`       decimal,
    PRIMARY KEY (`documentId`),
    FOREIGN KEY (`userId`) REFERENCES User (`UserId`),
    FOREIGN KEY (`deletedBy`) REFERENCES User (`UserId`)
);

create table if not exists album
(
    `albumId`     int           not null auto_increment,
    `userId`      int           not null,
    `title`       nvarchar(500) not null,
    `description` nvarchar(5000),
    `isShared`    bool,
    `createdOn` datetime not null ,
    `createdBy` int,
    `updatedOn` datetime,
    `updatedBy` int,
    PRIMARY KEY (`albumId`),
    FOREIGN KEY (`userId`) REFERENCES User (`UserId`),
    FOREIGN KEY (`createdBy`) REFERENCES User (`UserId`),
    FOREIGN KEY (`updatedBy`) REFERENCES User (`UserId`)
);
create table if not exists albumDocument
(
    `albumDocumentId`     int           not null auto_increment,
    `documentId`    int,
    `albumId`    int,
    PRIMARY KEY (`albumDocumentId`),
    FOREIGN KEY (`albumId`) REFERENCES album (`albumId`),
    FOREIGN KEY (`documentId`) REFERENCES document (`documentId`)
);
create table if not exists publication
(
    `publicationId` int           not null auto_increment,
    `userId`        int           not null,
    `title`         nvarchar(500) not null,
    `documentId`    int,
    PRIMARY KEY (`publicationId`),
    FOREIGN KEY (`userId`) REFERENCES User (`UserId`),
    FOREIGN KEY (`documentId`) REFERENCES document (`documentId`)
);
create table if not exists comment
(
    `commentId` int           not null auto_increment,
    `publicationId`        int           not null,
    `comment`         nvarchar(5000) not null,
    `documentId`    int,
    `createdOn` datetime not null ,
    `createdBy` int,
    `updatedOn` datetime,
    `updatedBy` int,
    PRIMARY KEY (`commentId`),
    FOREIGN KEY (`publicationId`) REFERENCES publication (`publicationId`),
    FOREIGN KEY (`createdBy`) REFERENCES User (`UserId`),
    FOREIGN KEY (`updatedBy`) REFERENCES User (`UserId`)
);
create table if not exists friend
(
    `friendId` int           not null auto_increment,
    `userId`        int           not null,
    `userFriendId` int not null,
    PRIMARY KEY (`friendId`),
    FOREIGN KEY (`userId`) REFERENCES User (`UserId`),
    FOREIGN KEY (`userFriendId`) REFERENCES User (`UserId`)
);


