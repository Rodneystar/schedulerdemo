create database if not exists scheduling;

use scheduling;

create table if not exists
record (
    id bigint auto_increment primary key,
    agent_id varchar(128),
    jobtime DATETIME
);