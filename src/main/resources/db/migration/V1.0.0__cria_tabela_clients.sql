
CREATE TABLE IF NOT EXISTS clients  (
    id INTEGER PRIMARY KEY,
    full_name TEXT NOT NULL,
    email TEXT NOT NULL,
    creation_at TEXT NOT NULL
);

-- SQLite does not support built-in date and time