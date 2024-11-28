CREATE TABLE notifications (
id bigserial PRIMARY KEY,
user_id varchar(63),
message varchar(255),
date_time timestamp
);