CREATE TABLE MOVIE_DIRECTOR (
    id                  NUMBER              NOT NULL,
    name                VARCHAR(30)         NOT NULL,
    surname             TEXT                NOT NULL,

    CONSTRAINT movie_director_pk PRIMARY KEY (id)
);

CREATE TABLE MOVIE (
    id                  NUMBER              NOT NULL,
    name                NUMBER              NOT NULL,
    runtime             NUMBER              NOT NULL,
    director            NUMBER              NOT NULL,

    CONSTRAINT movie_pk PRIMARY KEY (id),

    CONSTRAINT director_fk FOREIGN KEY (director)
        REFERENCES MOVIE_DIRECTOR(id),
);


CREATE TABLE TICKET_TYPE (
    id                  NUMBER              NOT NULL,
    name                VARCHAR(30)         NOT NULL,
    price               DECIMAL             NOT NULL,

    CONSTRAINT ticket_type_pk PRIMARY KEY (id),

    CONSTRAINT checked_name CHECK (
        name = 'ADULT' OR
        name = 'STUDENT' OR
        name = 'CHILD'
    )
);

CREATE TABLE TICKET (
    id                  NUMBER              NOT NULL,
    type                NUMBER              NOT NULL,
    reservation         NUMBER              NOT NULL,

    CONSTRAINT ticket_pk PRIMARY KEY (id),

    CONSTRAINT type_fk FOREIGN KEY (type)
        REFERENCES TICKET_TYPE(id),
    CONSTRAINT reservation_fk FOREIGN KEY (reservation)
        REFERENCES RESERVATION(id)
);

CREATE TABLE USER (
    id                  NUMBER              NOT NULL,
    name                VARCHAR(60)         NOT NULL,
    surname             TEXT                NOT NULL,

    CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TABLE RESERVATION (
    id                  NUMBER              NOT NULL,
    screening           NUMBER              NOT NULL,
    user                NUMBER              NOT NULL,

    CONSTRAINT reservation_pk PRIMARY KEY (id),

    CONSTRAINT screening_fk FOREIGN KEY (screening)
        REFERENCES SCREENING(id),
    CONSTRAINT user_fk FOREIGN KEY (user)
        REFERENCES USER(id)
);

CREATE TABLE SCREENING (
    id                  NUMBER              NOT NULL,
    time                DATETIME            NOT NULL,
    movie               NUMBER              NOT NULL,
    room                NUMBER              NOT NULL,

    CONSTRAINT screening_pk PRIMARY KEY (id),

    CONSTRAINT movie_fk FOREIGN KEY (movie)
        REFERENCES MOVIE(id),
    CONSTRAINT room_fk FOREIGN KEY (room)
        REFERENCES SCREENING_ROOM(id)
);

CREATE TABLE SCREENING_ROOM (
    id                  NUMBER              NOT NULL,


    CONSTRAINT screening_room_pk PRIMARY KEY (id)

);

CREATE TABLE SEATS_ROW (
    id                  NUMBER              NOT NULL,
    screening_room      NUMBER              NOT NULL,

    CONSTRAINT seats_row_pk PRIMARY KEY (id),

    CONSTRAINT screening_room_fk FOREIGN KEY (screening_room)
        REFERENCES SCREENING_ROOM(id)
);

CREATE TABLE SEAT (
    id                  NUMBER              NOT NULL,
    number_in_row       NUMBER              NOT NULL,
    row                 NUMBER              NOT NULL,

    CONSTRAINT seat_pk PRIMARY KEY (id),

    CONSTRAINT row_fk FOREIGN KEY (row)
        REFERENCES SEATS_ROW(id)
);

CREATE TABLE SEAT_TO_RESERVATION (
    seat_id             NUMBER              NOT NULL,
    reservation_id      NUMBER              NOT NULL,

    CONSTRAINT seat_to_reservation_pk PRIMARY KEY (seat_id, reservation_id),

    CONSTRAINT seat_fk FOREIGN KEY (seat_id)
        REFERENCES SEAT(id),
    CONSTRAINT reservation_fk FOREIGN KEY (reservation_id)
        REFERENCES RESERVATION(id)

);

