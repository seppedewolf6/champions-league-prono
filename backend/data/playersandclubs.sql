-- ==========================
-- CLUBS
-- ==========================

INSERT INTO clubs (id, name, pot, coefficient) VALUES
                                                   (gen_random_uuid(), 'Real Madrid', 1, 136.0),
                                                   (gen_random_uuid(), 'Manchester City', 1, 148.0),
                                                   (gen_random_uuid(), 'Bayern Munich', 1, 144.0),
                                                   (gen_random_uuid(), 'Paris Saint-Germain', 1, 116.0),

                                                   (gen_random_uuid(), 'Liverpool', 2, 114.0),
                                                   (gen_random_uuid(), 'Inter Milan', 2, 101.0),
                                                   (gen_random_uuid(), 'Arsenal', 2, 98.0),
                                                   (gen_random_uuid(), 'Borussia Dortmund', 2, 97.0),

                                                   (gen_random_uuid(), 'Barcelona', 3, 91.0),
                                                   (gen_random_uuid(), 'Juventus', 3, 80.0),
                                                   (gen_random_uuid(), 'Atletico Madrid', 3, 89.0),
                                                   (gen_random_uuid(), 'Benfica', 3, 82.0),

                                                   (gen_random_uuid(), 'RB Leipzig', 4, 77.0),
                                                   (gen_random_uuid(), 'Napoli', 4, 79.0),
                                                   (gen_random_uuid(), 'Sporting CP', 4, 59.0),
                                                   (gen_random_uuid(), 'Club Brugge', 4, 55.0);


-- ==========================
-- PLAYERS
-- ==========================

INSERT INTO players (id, club_id, external_api_id, name, player_position)
VALUES

-- Real Madrid
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Real Madrid'),
    NULL,
    'Kylian Mbappe',
    'ATTACKER'
),

-- Manchester City
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Manchester City'),
    NULL,
    'Erling Haaland',
    'ATTACKER'
),

-- Bayern Munich
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Bayern Munich'),
    NULL,
    'Harry Kane',
    'ATTACKER'
),

-- PSG
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Paris Saint-Germain'),
    NULL,
    'Ousmane Dembele',
    'ATTACKER'
),

-- Liverpool
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Liverpool'),
    NULL,
    'Mohamed Salah',
    'ATTACKER'
),

-- Inter Milan
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Inter Milan'),
    NULL,
    'Lautaro Martinez',
    'ATTACKER'
),

-- Arsenal
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Arsenal'),
    NULL,
    'Bukayo Saka',
    'ATTACKER'
),

-- Dortmund
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Borussia Dortmund'),
    NULL,
    'Julian Brandt',
    'MIDFIELDER'
),

-- Barcelona
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Barcelona'),
    NULL,
    'Pedri',
    'MIDFIELDER'
),

-- Juventus
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Juventus'),
    NULL,
    'Dusan Vlahovic',
    'ATTACKER'
),

-- Atletico Madrid
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Atletico Madrid'),
    NULL,
    'Antoine Griezmann',
    'ATTACKER'
),

-- Benfica
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Benfica'),
    NULL,
    'Angel Di Maria',
    'MIDFIELDER'
),

-- RB Leipzig
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'RB Leipzig'),
    NULL,
    'Xavi Simons',
    'MIDFIELDER'
),

-- Napoli
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Napoli'),
    NULL,
    'Romelu Lukaku',
    'ATTACKER'
),

-- Sporting CP
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Sporting CP'),
    NULL,
    'Viktor Gyokeres',
    'ATTACKER'
),

-- Club Brugge
(
    gen_random_uuid(),
    (SELECT id FROM clubs WHERE name = 'Club Brugge'),
    NULL,
    'Simon Mignolet',
    'KEEPER'
);

-- ==========================
-- TEAM
-- ==========================

INSERT INTO teams (
    id,
    user_id,
    captain_player_id,
    team_name,
    locked
)
VALUES (
           gen_random_uuid(),
           'aeb18f0a-6e19-4cc5-8e6b-8398c434b847',
           (
               SELECT id
               FROM players
               WHERE name = 'Kylian Mbappe'
           ),
           'Champions League XI',
           false
       );


-- ==========================
-- TEAM PLAYERS
-- ==========================


-- STARTERS

INSERT INTO team_players (
    id,
    team_id,
    player_id,
    is_starter
)
VALUES

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Kylian Mbappe'
        ),
        true
    ),

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Erling Haaland'
        ),
        true
    ),

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Mohamed Salah'
        ),
        true
    ),

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Bukayo Saka'
        ),
        true
    ),

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Pedri'
        ),
        true
    ),

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Julian Brandt'
        ),
        true
    ),

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Angel Di Maria'
        ),
        true
    ),

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Hans Vanaken'
        ),
        true
    ),

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Xavi Simons'
        ),
        true
    ),

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Viktor Gyokeres'
        ),
        true
    ),

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Harry Kane'
        ),
        true
    ),


-- BENCH

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Ousmane Dembele'
        ),
        false
    ),

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Lautaro Martinez'
        ),
        false
    ),

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Antoine Griezmann'
        ),
        false
    ),

    (
        gen_random_uuid(),
        (
            SELECT id FROM teams
            WHERE team_name = 'Seppe Champions League XI'
        ),
        (
            SELECT id FROM players
            WHERE name = 'Romelu Lukaku'
        ),
        false
    );