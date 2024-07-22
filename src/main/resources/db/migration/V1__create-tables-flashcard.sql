CREATE TABLE IF NOT EXISTS users
(
    id       uuid PRIMARY KEY UNIQUE NOT NULL,
    name     VARCHAR(255)            NOT NULL,
    email    TEXT                    NOT NULL,
    password VARCHAR(255)            NOT NULL
);

CREATE TABLE IF NOT EXISTS deck
(
    deck_id uuid PRIMARY KEY UNIQUE NOT NULL,
    title   VARCHAR(255)            NOT NULL,
    user_id uuid                    NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS card
(
    card_id  uuid PRIMARY KEY UNIQUE NOT NULL,
    question TEXT                    NOT NULL,
    answer   TEXT                    NOT NULL,
    deck_id  uuid                    NOT NULL,
    FOREIGN KEY (deck_id) REFERENCES deck (deck_id)
);
