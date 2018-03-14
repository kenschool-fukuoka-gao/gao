
use sample;
CREATE TABLE employee
(
    employeeId                  VARCHAR(50) NOT NULL,
    employeeName                VARCHAR(50) NOT NULL,
    kana                        VARCHAR(50) NOT NULL,
    password                    VARCHAR(50) NOT NULL,
    mailAddress                 VARCHAR(50) NOT NULL,
    PRIMARY KEY (employeeId)
);

use sample;
CREATE TABLE site
(
    siteId                     INT NOT NULL,
    siteName                   VARCHAR(50) NOT NULL,
    responsible                VARCHAR(50) NOT NULL,
    worker                     VARCHAR(100) NOT NULL,
    deadLine                   DATE NOT NULL,
    compDate                   DATE DEFAULT NULL,
    PRIMARY KEY (siteId)
);

use sample;
CREATE TABLE process
(
    processId                  INT NOT NULL,
    processName                VARCHAR(50) NOT NULL,
    startDate                  DATE NOT NULL,
    endDate                    DATE NOT NULL,
    PRIMARY KEY (processId)
);

use sample;
CREATE TABLE site_pro
(
    siteId                     INT NOT NULL,
    processId                  INT NOT NULL
);