CREATE TABLE tables
(
    id                   SERIAL PRIMARY KEY,
    name                 VARCHAR(30) NOT NULL,
    number_of_max_guests SMALLINT    NOT NULL
);

CREATE TABLE customers
(
    id            SERIAL PRIMARY KEY,
    full_name     VARCHAR(255)  NOT NULL,
    phone_number  VARCHAR(30)   NOT NULL,
    email_address VARCHAR(2555) NOT NULL
)

CREATE table blocklisted_customers
(
    id          SERIAL PRIMARY KEY,
    reason      VARCHAR(255) NOT NULL,
    customer_id INTEGER      NOT NULL,
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customers (id) ON DELETE CASCADE
);

CREATE TABLE reservations
(
    id                 SERIAL PRIMARY KEY,
    reservation_date   DATE        NOT NULL DEFAULT NOW(),
    reservation_status VARCHAR(20) NOT NULL,
    number_of_guests   SMALLINT    NOT NULL,
    customer_id        INTEGER     NOT NULL,
    table_id           INTEGER     NOT NULL,
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customers (id) ON DELETE CASCADE,
    CONSTRAINT fk_table_id FOREIGN KEY (table_id) REFERENCES tables (id) ON DELETE CASCADE
);