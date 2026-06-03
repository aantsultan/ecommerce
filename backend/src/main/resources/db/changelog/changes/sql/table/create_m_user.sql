create sequence user_id_seq start with 1;
create table m_user
(
    user_id         bigint          not null DEFAULT nextval('user_id_seq'),
    name            varchar(26)     not null,
    address         varchar(100)    not null,
    constraint      pk_users        primary key (user_id)
);