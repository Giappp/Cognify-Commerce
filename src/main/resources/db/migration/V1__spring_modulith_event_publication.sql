CREATE TABLE event_publication (
                                   id UUID PRIMARY KEY,
                                   publication_date TIMESTAMP NOT NULL,
                                   listener_id VARCHAR(255),
                                   serialized_event TEXT NOT NULL,
                                   event_type VARCHAR(255) NOT NULL
);