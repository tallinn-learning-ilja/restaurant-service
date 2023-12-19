-- Insert test data into tables table
INSERT INTO tables (name, number_of_max_guests)
VALUES ('Table 1', 4),
       ('Table 2', 6),
       ('Table 3', 6),
       ('Table 4', 8),
       ('Table 5', 3),
       ('Table 6', 5),
       ('Table 7', 4),
       ('Table 8', 6),
       ('Table 9', 2),
       ('Table 10', 8);

-- Insert test data into customers table
INSERT INTO customers (full_name, phone_number, email_address)
VALUES ('John Smith', '54354321', 'john.smith@example.com'),
       ('Jane Smith', '987-654-3210', 'jane.smith@example.com'),
       ('Bob Johnson', '555-123-4567', 'bob.johnson@example.com'),
       ('Alice White', '333-999-8888', 'alice.white@example.com'),
       ('Charlie Brown', '777-555-4444', 'charlie.brown@example.com'),
       ('Eva Green', '111-222-3333', 'eva.green@example.com'),
       ('Michael Jackson', '999-888-7777', 'michael.jackson@example.com'),
       ('Sara Lee', '444-666-1111', 'sara.lee@example.com'),
       ('David Miller', '555-777-9999', 'david.miller@example.com'),
       ('Olivia Taylor', '777-888-5555', 'olivia.taylor@example.com');

-- Insert test data into reservations table
INSERT INTO reservations (reservation_date, reservation_status, number_of_guests, customer_id, table_id)
VALUES ('2023-01-15', 'CONFIRMED', 2, 1, 1),
       ('2023-02-20', 'PENDING', 4, 2, 2),
       ('2023-03-25', 'CONFIRMED', 3, 3, 3),
       ('2023-04-10', 'PENDING', 5, 4, 4),
       ('2023-05-12', 'CONFIRMED', 2, 5, 5),
       ('2023-06-18', 'PENDING', 6, 6, 6),
       ('2023-07-22', 'CONFIRMED', 4, 7, 7),
       ('2023-08-30', 'PENDING', 3, 8, 8),
       ('2023-09-05', 'CONFIRMED', 5, 10, 10);

-- Insert test data into blocklisted_customers table
INSERT INTO blocklisted_customers (reason, customer_id)
VALUES ('No-show', 1),
       ('Violated policies', 2),
       ('Late cancellations', 4),
       ('Repeated no-shows', 6),
       ('Fraudulent activity', 8),
       ('Disruptive behavior', 9);