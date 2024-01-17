DROP TABLE IF EXISTS TEAMS CASCADE;
DROP TABLE IF EXISTS ORGANIZATIONS CASCADE;
DROP TABLE IF EXISTS EMPLOYERS CASCADE;
DROP TABLE IF EXISTS EMPLOYEE_COOPERATION CASCADE;
DROP TABLE IF EXISTS JOBS CASCADE;
DROP TABLE IF EXISTS SPONSORS CASCADE;
DROP TABLE IF EXISTS SPONSORS_ORGANIZATIONS CASCADE;
DROP TABLE IF EXISTS GAMES CASCADE;
DROP TABLE IF EXISTS REGIONS CASCADE;
DROP TABLE IF EXISTS COUNTRY CASCADE;
DROP TABLE IF EXISTS PLAYERS CASCADE;
DROP TABLE IF EXISTS PLRS_TM CASCADE;
DROP TABLE IF EXISTS TOURNAMENTS CASCADE;
DROP TABLE IF EXISTS TM_ON_TOUR CASCADE;

CREATE TABLE ORGANIZATIONS(
    ID SERIAL PRIMARY KEY,
    NAME TEXT NOT NULL,
    DESCRIPTION TEXT
);

CREATE TABLE GAMES (
    ID SERIAL PRIMARY KEY,
    NAME TEXT NOT NULL,
    DESCRIPTION TEXT NOT NULL

);

CREATE TABLE REGIONS (
    ID SERIAL PRIMARY KEY,
    NAME CHAR(5) NOT NULL

);

CREATE TABLE COUNTRY (
    ID SERIAL PRIMARY KEY,
    NAME TEXT NOT NULL,
    REG_ID INTEGER NOT NULL,
    FOREIGN KEY (REG_ID) REFERENCES REGIONS (ID)
);


CREATE TABLE JOBS(
    JOB_ID SERIAL PRIMARY KEY,
    DESCRIPTION TEXT,
    SALARY BIGINT
);

CREATE TABLE TEAMS(
    ID SERIAL PRIMARY KEY,
    ORG_ID INTEGER NOT NULL,
    FOREIGN KEY (ORG_ID) REFERENCES ORGANIZATIONS,
    GAME_ID INTEGER NOT NULL,
    FOREIGN KEY (GAME_ID) REFERENCES GAMES,
    TOTAL_WIN INT,
    REGION_ID INTEGER NOT NULL,
    FOREIGN KEY (REGION_ID) REFERENCES REGIONS
);



CREATE TABLE EMPLOYERS(
    EMPLOYEE_ID SERIAL PRIMARY KEY,
    FS_NAME TEXT NOT NULL,
    SC_NAME TEXT NOT NULL,
    JOD_ID INTEGER NOT NULL,
    FOREIGN KEY (JOD_ID) REFERENCES JOBS,
    ORG_ID INTEGER,
    FOREIGN KEY (ORG_ID) REFERENCES ORGANIZATIONS,
    AGE INT CHECK ( AGE BETWEEN 18 AND 99)
);

CREATE TABLE EMPLOYEE_COOPERATION(
    COOPERATION_ID SERIAL PRIMARY KEY,
    EMPLOYEE_ID INTEGER NOT NULL,
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYERS,
    ORG_ID INTEGER NOT NULL,
    FOREIGN KEY (ORG_ID) REFERENCES ORGANIZATIONS
);



CREATE TABLE SPONSORS(
    SPONSOR_ID SERIAL PRIMARY KEY,
    NAME TEXT NOT NULL,
    DESCRIPTION TEXT
);

CREATE TABLE SPONSORS_ORGANIZATIONS(
    START_DATE DATE,
    END_DATE DATE,
    PRIMARY KEY (START_DATE, END_DATE),
    SPONSOR_ID INTEGER NOT NULL,
    FOREIGN KEY (SPONSOR_ID) REFERENCES SPONSORS,
    ORG_ID INTEGER NOT NULL,
    FOREIGN KEY (ORG_ID) REFERENCES ORGANIZATIONS,
    BUDGET INTEGER NOT NULL
);



CREATE TABLE TOURNAMENTS (
    ID SERIAL PRIMARY KEY,
    NAME TEXT NOT NULL,
    PRIZE_POOL INTEGER NOT NULL CHECK (PRIZE_POOL >= 0) DEFAULT 0,
    GM_ID INTEGER NOT NULL,
    CON_ID INTEGER NOT NULL,
    FOREIGN KEY (GM_ID) REFERENCES GAMES (ID),
    FOREIGN KEY (CON_ID) REFERENCES COUNTRY (ID),
    WINNER_ID INTEGER
);

CREATE TABLE TM_ON_TOUR (
    TM_ID INTEGER,
    TOUR_ID INTEGER,
    PRIMARY KEY (TM_ID, TOUR_ID),
    FOREIGN KEY (TM_ID) REFERENCES TEAMS (ID),
    FOREIGN KEY (TOUR_ID) REFERENCES TOURNAMENTS (ID)
);




CREATE TABLE PLAYERS (
    ID SERIAL PRIMARY KEY,
    NICKNAME TEXT NOT NULL,
    FIRST_NAME TEXT NOT NULL,
    SECOND_NAME TEXT,
    BIRTH_DAY DATE NOT NULL,
    TTL_APRX_WIN INT,
    TM_ID INTEGER NOT NULL,
    COUNTRY TEXT NOT NULL
);

CREATE TABLE PLRS_TM (
    PLR_ID INTEGER,
    TM_ID INTEGER,
    START_DATE DATE,
    END_DATE DATE,
    PRIMARY KEY (PLR_ID, TM_ID, START_DATE, END_DATE),
    FOREIGN KEY (PLR_ID) REFERENCES PLAYERS (ID),
    FOREIGN KEY (TM_ID) REFERENCES TEAMS (ID)
);
----------------------------------------------------------------------------
----------------------------                    ----------------------------
-----------------------         Filling data         -----------------------
-----------------------                              -----------------------
----------------------------                    ----------------------------
----------------------------------------------------------------------------

INSERT INTO GAMES (NAME, DESCRIPTION) VALUES ('DOTA 2', 'One of the oldest MOBA games.');

INSERT INTO REGIONS (NAME) VALUES ('CIS'); -- 1
INSERT INTO REGIONS (NAME) VALUES ('EU'); -- 2

INSERT INTO SPONSORS (NAME, DESCRIPTION) VALUES ('BetBoom', 'The best booking maahcine');
INSERT INTO SPONSORS (NAME, DESCRIPTION) VALUES ('WinLine', 'The best booking maahcine after BetBoom');
INSERT INTO SPONSORS (NAME, DESCRIPTION) VALUES ('RedBull', 'The best energy drink');
INSERT INTO SPONSORS (NAME, DESCRIPTION) VALUES ('Shell', 'The best motor fuel');

INSERT INTO JOBS (DESCRIPTION, SALARY) VALUES ('Community caster', 1600),
                                              ('Cleaner', 600),
                                              ('Operator', 1300);


INSERT INTO COUNTRY (NAME, REG_ID) VALUES ('Russia', 1), ('Belarus', 1), ('Ukraine', 1),
                                          ('Germany', 2), ('Netherlands', 2), ('Denmark', 2), ('North America', 2);

INSERT INTO TOURNAMENTS (NAME, PRIZE_POOL, GM_ID, CON_ID, WINNER_ID) VALUES ('The International 2023', 4000000, 1, 7, NULL);


------------------------TEAM SPIRIT------------------------

INSERT INTO ORGANIZATIONS (NAME, DESCRIPTION) VALUES ('Team Spirit', 'One of the greatest cybersport organization in DOTA 2 history.'); -- 1

INSERT INTO TEAMS (ORG_ID, GAME_ID, TOTAL_WIN, REGION_ID) VALUES (1, 1, 27249259, 1); -- 1

INSERT INTO PLAYERS (NICKNAME, FIRST_NAME, SECOND_NAME, BIRTH_DAY, TTL_APRX_WIN, TM_ID, COUNTRY) VALUES ('Yatoro', 'Илья', 'Мулярчук', '12-03-2003', 5379012, 1, 'Ukraine'), -- 1
            ('Larl', 'Денис', 'Сигитов', '22-01-2002', 1434671, 1, 'Russia'), -- 2
            ('Collapse', 'Магомед', 'Халилов', '25-02-2002', 5381226, 1, 'Russia'), -- 3
            ('Mira', 'Мирослав', 'Колпаков', '03-11-1999', 5366144, 1, 'Ukraine'), -- 4
            ('Miposhka', 'Ярослав', 'Найдёнов', '30-11-1997', 5630005, 1, 'Russia'); -- 5

INSERT INTO PLRS_TM (PLR_ID, TM_ID, START_DATE, END_DATE) VALUES (1, 1, '2020-12-19', CURRENT_DATE),
            (2, 1, '2022-12-08', CURRENT_DATE),
            (3, 1, '2020-12-19', CURRENT_DATE),
            (4, 1, '2021-03-07', CURRENT_DATE),
            (5, 1, '2020-12-19', CURRENT_DATE);


------------------------Gaimin Gladiators------------------------

INSERT INTO ORGANIZATIONS (NAME, DESCRIPTION)  VALUES ('Gaimin Gladiators',
 'Gaimin Gladiators (also known as GG) is a European esports organization.
  They entered the Dota 2 competitive scene
  in February 2022 with the signing of Team Tickles.'); -- 2

INSERT INTO TEAMS (ORG_ID, GAME_ID, TOTAL_WIN, REGION_ID) VALUES (2, 1, 3671249, 2); -- 1

INSERT INTO PLAYERS (NICKNAME, FIRST_NAME, SECOND_NAME, BIRTH_DAY, TTL_APRX_WIN, TM_ID, COUNTRY) VALUES ('dyrachyo', 'Антон', 'Шкредов', '05-09-2001', 768757, 2, 'Russia'), -- 6
            ('Quinn', 'Quinn', 'Callahan', '09-09-1998', 1314343, 2, 'North America'), -- 7
            ('Ace♠', 'Marcus Folke', 'Hoelgaard Christensen', '19-01-1994', 1500683, 2, 'Denmark'), -- 8
            ('tOfu', 'Erik', 'Engel', '14-08-1996', 767785, 2, 'Germany'), -- 9
            ('Seleri', 'Melchior Leander', 'Isaac Hillenkamp', '03-07-1999', 815262, 2, 'Netherlands'); -- 10

INSERT INTO PLRS_TM (PLR_ID, TM_ID, START_DATE, END_DATE) VALUES (6, 2, '2022-02-08', CURRENT_DATE),
            (7, 2, '2022-12-07', CURRENT_DATE),
            (8, 2, '2022-02-08', CURRENT_DATE),
            (9, 2, '22022-02-08', CURRENT_DATE),
            (10, 2, '2022-02-08', CURRENT_DATE);
------------------------Team Secret------------------------

INSERT INTO ORGANIZATIONS (NAME, DESCRIPTION)  VALUES ('9Pandas', 'is an esports organization based in Belgrade, Serbia. ' ||
                                                       'They entered the Dota 2 competitive scene in April 2023.'); -- 3

INSERT INTO TEAMS (ORG_ID, GAME_ID, TOTAL_WIN, REGION_ID) VALUES (3, 1, 1084569, 1); -- 1

INSERT INTO PLAYERS (NICKNAME, FIRST_NAME, SECOND_NAME, BIRTH_DAY, TTL_APRX_WIN, TM_ID, COUNTRY) VALUES ('RAMZES666', 'Роман', 'Кушнарев', '24-04-1999', 2064214, 3, 'Russia'), --11
            ('kyotaka', 'Глеб', 'Зырянов', '19-08-2003', 256059, 3, 'Russia'), -- 12
            ('MieRo', 'Матвей', 'Васюнин', '28-06-2003', 249761, 2, 'Russia'), -- 13
            ('Antares', 'Владислав', 'Кертман', '07-10-2002', 240921, 2, 'Russia'), -- 14
            ('Solo', 'Алексей', 'Березин', '07-08-1990', 2042915, 2, 'Russia'); -- 15

INSERT INTO PLRS_TM (PLR_ID, TM_ID, START_DATE, END_DATE) VALUES (11, 3, '2023-04-17', CURRENT_DATE),
            (12, 3, '2023-04-17', CURRENT_DATE),
            (13, 3, '2023-04-17', '2023-11-14'),
            (14, 3, '2023-04-17', CURRENT_DATE),
            (15, 3, '2023-04-17', CURRENT_DATE);
------------------------BetBoom Team------------------------

INSERT INTO ORGANIZATIONS (NAME, DESCRIPTION)  VALUES ('BetBoom Team',
                            'BetBoom Team is a Russian esports organization'); -- 4

INSERT INTO TEAMS (ORG_ID, GAME_ID, TOTAL_WIN, REGION_ID) VALUES (4, 1, 1458653, 1); -- 4

INSERT INTO PLAYERS (NICKNAME, FIRST_NAME, SECOND_NAME, BIRTH_DAY, TTL_APRX_WIN, TM_ID, COUNTRY) VALUES
            ('Nightfall', 'Егор', 'Григоренко', '16-05-2002', 785129, 4, 'Russia'), -- 16
            ('gpk', 'Данил', 'Скутин', '23-08-2001', 720898, 4, 'Russia'), -- 17
            ('Pure', 'Иван', 'Москаленко', '06-02-2004', 359690, 4, 'Russia'), -- 18
            ('Save-', 'Виталий', 'Мельник', '04-02-2002', 678127, 4, 'Moldova'), -- 19
            ('TORONTOTOKYO', 'Александр', 'Хертек', '30-04-1997', 4244032, 4, 'Russia'); -- 20

INSERT INTO PLRS_TM (PLR_ID, TM_ID, START_DATE, END_DATE) VALUES (16, 4, '2022-12-08', CURRENT_DATE),
            (17, 4, '2022-12-08', CURRENT_DATE),
            (18, 4, '2022-12-08', CURRENT_DATE),
            (19, 4, '2022-12-08', CURRENT_DATE),
            (20, 4, '2022-12-08', CURRENT_DATE);

-----------------------------------------------------------------------
----------------------------               ----------------------------
-----------------------         Many            -----------------------
-----------------------           to            -----------------------
----------------------------    Many       ----------------------------
-----------------------------------------------------------------------

INSERT INTO SPONSORS_ORGANIZATIONS (START_DATE, END_DATE, SPONSOR_ID, ORG_ID, BUDGET) VALUES ('2020-12-19', '2021-11-19', 1, 1, 700000),
                                                                                             ('2021-12-01', '2022-03-11', 1, 3, 900000),
                                                                                             ('2019-12-01', '2022-02-11', 2, 4, 608000);
INSERT INTO EMPLOYERS (FS_NAME, SC_NAME, JOD_ID, ORG_ID, AGE) VALUES ('Alexander', 'Levin', 1, 1, 27),
                                                                     ('Dmitry', 'Kaplan', 2, NULL, 20),
                                                                     ('Oleg', 'Bocharov' ,3, 1, 29);

INSERT INTO EMPLOYEE_COOPERATION (EMPLOYEE_ID, ORG_ID) VALUES (1, 1), (3, 1);
INSERT INTO TM_ON_TOUR (TM_ID, TOUR_ID) VALUES (1, 1), (2, 1), (3, 1), (4, 1);
-----------------------------------------------------------------------
----------------------------               ----------------------------
-----------------------         Indexes         -----------------------
-----------------------                         -----------------------
----------------------------               ----------------------------
-----------------------------------------------------------------------


CREATE INDEX TTL_WIN_IDX ON PLAYERS USING BTREE(TTL_APRX_WIN);
CREATE INDEX NN_IDX ON PLAYERS USING HASH(NICKNAME);


-----------------------------------------------------------------------
----------------------------               ----------------------------
-----------------------         Queries         -----------------------
-----------------------                         -----------------------
----------------------------               ----------------------------
-----------------------------------------------------------------------

SELECT PLAYERS.NICKNAME, PLAYERS.FIRST_NAME, PLAYERS.SECOND_NAME, PLAYERS.BIRTH_DAY,
                        PLAYERS.TTL_APRX_WIN, PLAYERS.TM_ID, PLAYERS.TM_ID FROM PLAYERS
WHERE NICKNAME = 'Yatoro';

-- для поиска информации по игроку логичнее всего использовать его никнейм (так принято) => most usable column
-- => add hash-index on nickname

SELECT PLAYERS.NICKNAME, PLAYERS.COUNTRY, PLAYERS.TTL_APRX_WIN, ORGANIZATIONS.NAME, TEAMS.TOTAL_WIN FROM PLAYERS
    JOIN TEAMS ON PLAYERS.TM_ID = TEAMS.ID
    JOIN ORGANIZATIONS ON TEAMS.ORG_ID = ORGANIZATIONS.ID
WHERE TTL_APRX_WIN > 1000000
ORDER BY TTL_APRX_WIN DESC;

-- логично добавить BTREE индекс на тотал апрокс вины игроков, ТК нужно часто юузать операторы >< и в целом игроков больше всего

SELECT ORGANIZATIONS.NAME, ORGANIZATIONS.DESCRIPTION, GAMES.NAME FROM ORGANIZATIONS
    JOIN TEAMS ON ORGANIZATIONS.ID = TEAMS.ORG_ID
    JOIN GAMES ON GAMES.ID = TEAMS.GAME_ID
WHERE TEAMS.TOTAL_WIN > 20000000;
-----------------------------------------------------------------------
----------------------------               ----------------------------
-----------------------         Functions       -----------------------
-----------------------             and         -----------------------
----------------------------   Procedures  ----------------------------
-----------------------------------------------------------------------


DROP PROCEDURE addPrizeForTeam(teamID int, dollarPrize int);

CREATE OR REPLACE PROCEDURE addPrizeForTeam(teamID int, dollarPrize int)
    LANGUAGE PLPGSQL
AS $$
BEGIN
    UPDATE TEAMS
    SET TOTAL_WIN = TEAMS.TOTAL_WIN + dollarPrize
    WHERE teamID = TEAMS.ID;
    COMMIT;
END;
$$;
CREATE OR REPLACE FUNCTION startDateByNickname(nn text)
    RETURNS date
    LANGUAGE plpgsql
AS
$$
DECLARE
    startDate date;
begin
    SELECT START_DATE
    INTO startDate
    FROM PLRS_TM
    JOIN PLAYERS ON PLRS_TM.PLR_ID = PLAYERS.ID
    WHERE PLAYERS.NICKNAME = nn;
    RETURN startDate;
end;
$$;
SELECT startDateByNickname('Miposhka');
SELECT * FROM TEAMS;
CALL addPrizeForTeam(1, 600);
SELECT * FROM TEAMS;

CREATE OR REPLACE FUNCTION addPrizeForTeamNew()
    RETURNS TRIGGER
    LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE TEAMS
    SET TOTAL_WIN = TEAMS.TOTAL_WIN + NEW.prize_pool
    WHERE TEAMS.ID = NEW.winner_id;
    RETURN NEW;
END;
$$;

CREATE TRIGGER add_prize_trigger
AFTER UPDATE OF WINNER_ID ON TOURNAMENTS
FOR EACH ROW
EXECUTE FUNCTION addPrizeForTeamNew();
SELECT * from TEAMS;
UPDATE tournaments set WINNER_ID = 1 where ID =  1;
SELECT * FROM TEAMS;
-- ПОЛНЕЙШЕЕ ФУНКЦИОнАЛЬНОЕ ПОКРЫТИЕ
CREATE OR REPLACE FUNCTION getTeamNames(gameName TEXT)
    RETURNS TEXT[]
    LANGUAGE plpgsql
AS
$$
BEGIN
     RETURN ARRAY(
        SELECT ORGANIZATIONS.NAME
        FROM organizations
            join TEAMS T on T.ORG_ID = ORGANIZATIONS.ID
            join GAMES G on G.ID = T.GAME_ID
        WHERE G.NAME = gameName
    );
END;
$$;

CREATE OR REPLACE FUNCTION getTeamPlayes(TEAM_NAME TEXT, GAME TEXT)
    RETURNS TEXT[][]
    LANGUAGE PLPGSQL
AS $$
BEGIN
    RETURN ARRAY (

        SELECT ARRAY[PLAYERS.FIRST_NAME, PLAYERS.NICKNAME, PLAYERS.SECOND_NAME] FROM PLAYERS
            JOIN TEAMS ON PLAYERS.TM_ID = TEAMS.ID
            JOIN ORGANIZATIONS ON TEAMS.ORG_ID = ORGANIZATIONS.ID
            JOIN GAMES G on TEAMS.GAME_ID = G.ID
            WHERE ORGANIZATIONS.NAME = TEAM_NAME AND G.NAME = GAME


    );
END;
$$;
DROP FUNCTION getTeamAproxWin(TEAM_NAME TEXT);
CREATE OR REPLACE FUNCTION getTeamAproxWin(TEAM_NAME TEXT)
    RETURNS INTEGER
    LANGUAGE plpgsql
AS $$
    DECLARE ttw INTEGER;
BEGIN

   SELECT TEAMS.TOTAL_WIN INTO ttw
    FROM TEAMS
    JOIN ORGANIZATIONS O on O.ID = TEAMS.ORG_ID
    WHERE O.NAME = TEAM_NAME;

    RETURN ttw;
END;
$$;
DROP FUNCTION getPlayerAge(PLAYER_FIRST_NAME TEXT);
CREATE OR REPLACE FUNCTION getPlayerAge(PLAYER_FIRST_NAME TEXT)
    RETURNS interval
    LANGUAGE plpgsql
AS
$$
BEGIN
    RETURN (
           SELECT age(BIRTH_DAY::DATE)  FROM PLAYERS
           WHERE FIRST_NAME = PLAYER_FIRST_NAME
           );
end;
$$;
select * FROM getTeamNames('DOTA 2');
select (getTeamPlayes('Team Spirit', 'DOTA 2'));
select * from getTeamAproxWin('Team Spirit');
select * from getPlayerAge('Ярослав')
