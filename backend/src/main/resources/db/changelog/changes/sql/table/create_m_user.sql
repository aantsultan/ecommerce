
create table m_user
(
    user_id         bigserial       primary key,
    name            varchar(26)     not null,
    address         varchar(100)    not null
);