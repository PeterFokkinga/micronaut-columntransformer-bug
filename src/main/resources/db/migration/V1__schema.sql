CREATE CAST (varchar AS interval) WITH INOUT AS IMPLICIT;
CREATE SEQUENCE rider_id_seq;

CREATE TABLE rider
(
    id          integer PRIMARY KEY DEFAULT nextval('rider_id_seq'),
    name        text,
    finish_time interval HOUR TO MINUTE
);


CREATE SEQUENCE report_id_seq;

CREATE TABLE report
(
    id      integer PRIMARY KEY DEFAULT nextval('report_id_seq'),
    rider   integer,
    message text,
    CONSTRAINT report_fk FOREIGN KEY (rider) references rider (id)
);


