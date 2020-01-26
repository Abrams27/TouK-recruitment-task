INSERT INTO TICKET_TYPE (id, name, price) VALUES
    (0, 'ADULT', 25),
    (1, 'STUDENT', 18),
    (2, 'CHILD', 12.50);


INSERT INTO MOVIE_DIRECTOR (id, name, surname) VALUES
    (0, 'Stanley', 'Kubrick'),
    (1, 'Mary', 'Harron'),
    (2, 'Sam', 'Mendes'),
    (3, 'Sidney', 'Lumet');

INSERT INTO MOVIE (id, title, runtime, director) VALUES
    (0, 'A Clockwork Orange', 136, 0),
    (1, 'American Psycho', 101, 1),
    (2, 'American Beauty', 122, 2),
    (3, '12 Angry Men', 96, 3);


INSERT INTO SCREENING_ROOM (id, number_of_rows, name) VALUES
    (0, 3, 'Small #1'),
    (1, 3, 'Small #2'),
    (2, 5, 'Big #1');

INSERT INTO SEATS_ROW (id, row_number, number_of_seats, screening_room) VALUES
    (0, 1, 2, 0),
    (1, 2, 3, 0),
    (2, 3, 2, 0),

    (3, 1, 4, 1),
    (4, 2, 3, 1),
    (5, 3, 2, 1),

    (6, 1, 5, 2),
    (7, 2, 6, 2),
    (8, 3, 3, 2),
    (9, 4, 4, 2),
    (10, 5,  2, 2);


INSERT INTO SEAT (id, number_in_row, seats_row) VALUES
    (1, 1, 0),
    (2, 2, 0),

    (3, 1, 1),
    (4, 2, 1),
    (5, 3, 1),

    (6, 1, 2),
    (7, 2, 2),


    (8, 1, 3),
    (9, 2, 3),
    (10, 3, 3),
    (11, 4, 3),

    (12, 1, 4),
    (13, 2, 4),
    (14, 3, 4),

    (15, 1, 5),
    (16, 2, 5),


    (17, 1, 6),
    (18, 2, 6),
    (19, 3, 6),
    (20, 4, 6),
    (21, 5, 6),

    (22, 1, 7),
    (23, 2, 7),
    (24, 3, 7),
    (25, 4, 7),
    (26, 5, 7),
    (27, 6, 7),

    (28, 1, 8),
    (29, 2, 8),
    (30, 3, 8),


    (31, 1, 9),
    (32, 2, 9),
    (33, 3, 9),
    (34, 4, 9),

    (35, 1, 10),
    (36, 2, 10);


INSERT INTO SCREENING (id, time, movie, room) VALUES
    (0, '2020-02-14 14:25:00', 0, 0),
    (1, '2020-02-13 10:40:00', 3, 0),

    (2, '2020-02-14 12:35:00', 1, 1),
    (3, '2020-02-12 18:50:00', 2, 1),

    (4, '2020-02-14 14:30:00', 0, 2),
    (5, '2020-02-14 19:45:00', 0, 2);
