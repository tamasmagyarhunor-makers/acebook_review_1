DROP TABLE IF EXISTS comments;

CREATE TABLE comments (
    id SERIAL PRIMARY KEY,
    user_id varchar(63),
    post_id bigint,
    comments text,
    date_time timestamp,
    CONSTRAINT fk_post_id FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE
);