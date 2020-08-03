BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);



INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;


BEGIN TRANSACTION;

DROP TABLE IF EXISTS plant;
CREATE TABLE plant (
        plant_id serial NOT NULL,
        plant_name varchar(100) NOT NULL,
        description varchar(1000) NOT NULL,
        plants_per_sq_foot int NOT NULL,
        sun_requirements varchar(100) NOT NULL,
        region varchar(100) NOT NULL,
        seed_cost int NOT NULL,
        CONSTRAINT PK_plant_id PRIMARY KEY (plant_id)     

);
COMMIT TRANSACTION;



BEGIN TRANSACTION;

DROP TABLE IF EXISTS plant_subplot;
CREATE TABLE plant_subplot (
        plant_id int NOT NULL,
        subplot_id int
--        CONSTRAINT PK_plant_id PRIMARY KEY (plant_id)
);
COMMIT TRANSACTION;


BEGIN TRANSACTION;

DROP TABLE IF EXISTS subplot;
CREATE TABLE subplot (
        subplot_id serial NOT NULL,
        length int NOT NULL,
        width int NOT NULL,
        plot_id serial NOT NULL,
        subplot_name varchar(100) NOT NULL,
        CONSTRAINT PK_subplot_id PRIMARY KEY (subplot_id)
);
COMMIT TRANSACTION;

BEGIN TRANSACTION;

DROP TABLE IF EXISTS plot;
CREATE TABLE plot (
        plot_id int NOT NULL,
        length int NOT NULL,
        width int NOT NULL,
        plot_name varchar(100) NOT NULL,
        CONSTRAINT PK_plot_id PRIMARY KEY (plot_id)


);
COMMIT TRANSACTION;

BEGIN TRANSACTION;
DROP TABLE IF EXISTS plot_supplies;
CREATE TABLE plot_supplies (
        plot_id int,
        supply_id int,
        CONSTRAINT PK_supply_id PRIMARY KEY (supply_id)
        


);
COMMIT TRANSACTION;

BEGIN TRANSACTION;
DROP TABLE IF EXISTS supplies; 
CREATE TABLE supplies (
        supply_id int NOT NULL,
        supply_name varchar(100) NOT NULL,
        supply_cost int NOT NULL,
        CONSTRAINT PK_supplies PRIMARY KEY (supply_id)
);
ALTER TABLE subplot ADD FOREIGN KEY (plot_id) REFERENCES plot(plot_id);
ALTER TABLE plant_subplot ADD FOREIGN KEY (plant_id) REFERENCES plant(plant_id);
ALTER TABLE plant_subplot ADD FOREIGN KEY (subplot_id) REFERENCES subplot(subplot_id);
ALTER TABLE plot_supplies ADD FOREIGN KEY (plot_id) REFERENCES plot(plot_id);
ALTER TABLE plot_supplies ADD FOREIGN KEY (supply_id) REFERENCES supplies(supply_id);
COMMIT TRANSACTION;