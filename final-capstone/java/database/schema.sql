BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id CASCADE;

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
INSERT INTO users (username,password_hash,role) VALUES ('doyle','$2a$10$Z8rmoLK4SHX3q4/jkEqgqeZP3uTLsLsP/uZUsYkXzMC7AlIu5rtVC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('brandon','$2a$10$Z8rmoLK4SHX3q4/jkEqgqeZP3uTLsLsP/uZUsYkXzMC7AlIu5rtVC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('ingrid','$2a$10$Z8rmoLK4SHX3q4/jkEqgqeZP3uTLsLsP/uZUsYkXzMC7AlIu5rtVC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('ben','$2a$10$Z8rmoLK4SHX3q4/jkEqgqeZP3uTLsLsP/uZUsYkXzMC7AlIu5rtVC','ROLE_USER');



COMMIT TRANSACTION;


BEGIN TRANSACTION;

DROP TABLE IF EXISTS plant CASCADE;
CREATE TABLE plant (
        plant_id serial NOT NULL,
        plant_name varchar(100) NOT NULL,
        description varchar(1000) NOT NULL,
        plants_per_sq_foot int NOT NULL,
        sun_requirements varchar(100) NOT NULL,
        region varchar(100) NOT NULL,
        seedling_cost decimal NOT NULL,
        CONSTRAINT PK_plant_id PRIMARY KEY (plant_id)     

);
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Arugula', 'Leafy green, with an herbaceous, peppery flavor, great for salads and sandwiches', '4', '3-4 hours', 'Mediterranean', '6.25');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Basil', 'Aromatic herb, great for cooking and in sauces', '3', '6-8 hours', 'Tropical', '3.75');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Beets', 'Colorful root vegetable', '9', '6 hours', 'Mediterranean', '4.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Bok Choy', 'Leafy grren vegetable in the cabbage family, great for cooking', '9', '3-5 hours', 'Asia', '2.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Broccoli', 'Cruciferous vegetable with many health benefits and cooking uses', '1', 'Partial Shade', 'Southwestern United States', '2.75');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Brussel Sprout', 'Mini cabbages, they taste great when roasted', '1', 'Minimum of 6 hours', 'Mediterranean', '3.75');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Cabbage', 'Leafy green, red, purple or white crop in the broccoli family', '1', 'Minimum of 6 hours', 'Europe', '5.00');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Carrot', 'Delicious, orange root vegetable, great for cooking or eating raw', '16', 'Minimum of 6 hours', 'Africa', '3.00');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Cauliflower', 'Crucerferous vegetable with versitle cooking properties', '1', 'Minimum of 6 hours', 'Asia', '7.75');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Corn', 'Sweet yellow grain, great for cooking', '4', 'Minimum of 6 hours', 'United States', '6.25');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Collards', 'Deep leafy grren member of the cabbage family', '1', '4-5 hours', 'Mediterranean', '2.95');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Cucumber', 'Refreshing vine fruit, great for salads', '2', 'Minimum of 8 hours', 'India', '3.75');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Eggplant', 'Herbaceous perennial, related to the tomato, great for cooking', '1', 'Minimum of 6 hours', 'India', '7.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Garlic', 'Herbaceous, pungent, flowering bulb, often used in cooking, keeps the vampires away!', '9', 'Minimum of 8 hours', 'Middle Asia', '3.25');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Green Onions', 'Also known as scallions, often used for cooking', '16', '6-7 hours', 'Asia', '1.75');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Kale', 'Leafy herbaceous biennial plant, great for cooking or eating raw', '1', 'Minimum of 6 hours', 'Mediterranean', '5.00');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Lettuce (leaf)', 'Perfect for salads!', '6', '10-12 hours', 'Egypt', '4.95');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Lettuce (head)', 'Perfect for salads!', '2', '10-12 hours', 'Egypt', '4.95');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Mint', 'Perfect for teas, cooking, and garnishing', '4', '4-6 hours', 'South America', '2.25');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Onion', 'Pungent biennial, great for cooking', '9', '13-16 hours', 'Central Asia', '2.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Zucchini', 'Dark green summer squash, great for cooking', '1', '6-8 hours', 'Central America', '8.00');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Thyme', 'Wiry, stemmed, herbaceous perennial, often used as a seasoning', '4', '6 hours', 'Southern Europe', '6.25');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Turnips', 'Hardy biennia plant in the mustard family', '9', 'Minimum of 6 hours', 'Europe', '5.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Tomato', 'Acidic nightshade, often used for cooking', '1', 'Minimum of 8 hours', 'Central America', '6.00');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Spinach', 'Iron-rich leafy grren, Popeye would be proud!', '9', 'Minimum of 6 hours', 'Southwestern Asia', '3.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Squash', 'Great for fall dishes', '1', '6 hours', 'Mexico', '2.95');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Sage', 'Evergreen herb in the mint family', '1', '6-8 hours', 'Mediterranean', '2.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Rosemary', 'Evergreen shrub, with purple flowers and a lovely scent', '1', '6-8 hours', 'Mediterranean', '5.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Rhubarb', 'Perfect for pies, jellies, and more, should not be eaten raw', '1', 'Minimum of 6 hours', 'Central Asia', '1.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Rashishes', 'Bitter root vegetable, great for salads and garnishes', '16', 'Minimum of 6 hours', 'Mediterranean', '2.75');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Potato', 'Versitile, starchy root vegetable', '4', 'Minimum of 6 hours', 'Peru', '3.50');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Bell Pepper', 'Perfect for salads and stir-fry dishes', '1', '6-8 hours', 'South America', '6.25');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Peas', 'Classic garden veggie, great for novice gardeners', '9', '6-8 hours', 'Mediterranean', '4.00');
INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES ('Parsley', 'Great for garnishing', '4', '5 hours', 'Mediterranean', '6.25');


COMMIT TRANSACTION;





BEGIN TRANSACTION;

DROP TABLE IF EXISTS plot CASCADE;
CREATE TABLE plot (
       plot_id serial NOT NULL,
        length int NOT NULL,
        width int NOT NULL,
        garden_id int NOT NULL,
        plot_number int NOT NULL,
        plant_id int,
        CONSTRAINT PK_plot_id PRIMARY KEY (plot_id)
);
COMMIT TRANSACTION;

BEGIN TRANSACTION;

DROP TABLE IF EXISTS garden CASCADE;
CREATE TABLE garden (
        user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL, 
        garden_id serial NOT NULL,
        length int NOT NULL,
        width int NOT NULL,
        garden_name varchar(100) NOT NULL,
        CONSTRAINT PK_garden_id PRIMARY KEY (garden_id)


);
COMMIT TRANSACTION;

BEGIN TRANSACTION;
DROP TABLE IF EXISTS garden_supplies;
CREATE TABLE garden_supplies (
        garden_id int,
        supply_id int,
        supply_qty int,
        CONSTRAINT PK_garden_supply_id PRIMARY KEY (garden_id, supply_id)
);
COMMIT TRANSACTION;

BEGIN TRANSACTION;
DROP TABLE IF EXISTS supplies CASCADE; 
CREATE TABLE supplies (
        supply_id int NOT NULL,
        supply_name varchar(100) NOT NULL,
        supply_cost decimal NOT NULL,
        CONSTRAINT PK_supplies PRIMARY KEY (supply_id)
);

INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('1', '2 cu ft. Bagged Brown Mulch', '4.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('2', '2 cu ft. Bagged Red Mulch', '4.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('3', '2 cu ft. Bagged Black Mulch', '4.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('4', '2 cu ft. Bagged Cypress Mulch Blend', '4.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('5', '2 cu ft. Bagged Pine Bark Nuggets', '4.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('6', '16-Tine Rake', '20.00');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('7', '24-Tine Steel Rake', '20.00');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('8', 'Hand Trowel', '9.00');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('9', 'Steel Hand Trowel', '11.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('10', 'Bypass Pruner', '10.75');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('11', 'Stainless Steel Micro Tip Pruner', '13.25');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('12', '46 in. Long Handle Steel Round Point Shovel', '8.25');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('13', '48 in. Round Point Shovel', '26.00');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('14', '23.5 in. Wood D-Handle Square Point Shovel', '24.75');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('15', 'Firm Grip Grain Pigskin Gloves', '12.25');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('16', 'Digz Gardener Glove', '14.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('17', 'Rose Embroidered mid-length Gloves', '14.75');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('18', 'Multi-Purpose Heavy Duty Dig It! Garden Cart', '100.00');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('19', 'Plastic Wheelbarrow', '80.00');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('20', '4-tined basic green cultivator', '18.75');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('21', '4- tined green hand rake', '9.50');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('22', 'Dig it! Watering can', '45.00');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('23', 'Dit It! Copper Logo Watering can', '60.00');
INSERT INTO supplies (supply_id, supply_name, supply_cost) VALUES ('24', 'Dig It! Tomato Cage', '20.00');






BEGIN TRANSACTION;

DROP TABLE IF EXISTS user_data CASCADE;
CREATE TABLE user_data(
        user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL, 
		first_name varchar(100) NOT NULL,
		last_name varchar(100) NOT NULL,
        email varchar(100) NOT NULL,
        region varchar(100),
        city varchar(100),
        state varchar(100),
		zip varchar(20),
CONSTRAINT PK_user_data PRIMARY KEY (user_id)        

);

INSERT INTO user_data (user_id, first_name, last_name, email, region, city, state, zip) VALUES ('1', 'user', 'x', 'userx@gardenmail.com', 'null', 'Detroit', 'Michigan', '48202');
INSERT INTO user_data (user_id, first_name, last_name, email, region, city, state, zip) VALUES ('2', 'admin', 'x', 'adminx@gardenmail.com', 'null', 'Detroit', 'Michigan', '48202');
INSERT INTO user_data (user_id, first_name, last_name, email, region, city, state, zip) VALUES ('3', 'Doyle', 'ODonnell', 'doyleodo@gardenmail.com', 'null', 'Brighton', 'Michigan', '48114');
INSERT INTO user_data (user_id, first_name, last_name, email, region, city, state, zip) VALUES ('4', 'Brandon', 'Grumbling', 'brandon@gardenmail.com', 'null', 'Philadelphia', 'Michigan', '19125');
INSERT INTO user_data (user_id, first_name, last_name, email, region, city, state, zip) VALUES ('5', 'Ingrid', 'OConnor', 'ingrid@gardenmail.com', 'null', 'Detroit', 'Michigan', '48202');
INSERT INTO user_data (user_id, first_name, last_name, email, region, city, state, zip) VALUES ('6', 'Ben', 'Offer', 'ben@gardenmail.com', 'null', 'Ferndale', 'Michigan', '48220');

COMMIT TRANSACTION;



BEGIN TRANSACTION;

DROP TABLE IF EXISTS hardiness CASCADE;
CREATE TABLE hardiness (
        hardiness_id int,
	zone_name varchar(10),
	avg_last_frost_month varchar(10),
	avg_last_frost_day int,
	avg_first_frost_month varchar(10),
	avg_first_frost_day int,
	avg_growing_days int,
        CONSTRAINT PK_hardiness_id PRIMARY KEY (hardiness_id)
);

INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('1', '3A', 'May', '15', 'September', '15', '123');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('2', '3B', 'May', '15', 'September', '15', '123');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('3', '4A', 'May', '15', 'October', '1', '139');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('4', '4B', 'May', '15', 'October', '1', '139');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('5', '5A', 'May', '1', 'October', '15', '168');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('6', '5B', 'May', '1', 'October', '15', '168');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('7', '6A', 'Apr', '15', 'October', '15', '183');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('8', '6B', 'Apr', '15', 'October', '15', '183');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('9', '7A', 'Apr', '1', 'October', '31', '213');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('10', '7B', 'Apr', '1', 'October', '31', '213');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('11', '8A', 'March', '15', 'November', '15', '245');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('12', '8B', 'March', '15', 'November', '15', '245');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('13', '9A', 'February', '15', 'November', '30', '290');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('14', '9B', 'February', '15', 'November', '30', '290');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('15', '10A', 'January', '1', 'December', '31', '290');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('16', '10B', 'January', '1', 'December', '31', '290');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('17', '11A', 'January', '1', 'December', '31', '290');
INSERT INTO hardiness (hardiness_id, zone_name, avg_last_frost_month, avg_last_frost_day, avg_first_frost_month, avg_first_frost_day, avg_growing_days) VALUES ('18', '11B', 'January', '1', 'December', '31', '290');


COMMIT TRANSACTION;




DROP TABLE IF EXISTS plant_hardiness;
CREATE TABLE plant_hardiness (
        hardiness_id int,
	plant_id int,
        
        CONSTRAINT PK_plant_hardiness PRIMARY KEY (hardiness_id, plant_id)
);
COMMIT TRANSACTION;



ALTER TABLE plot ADD FOREIGN KEY (garden_id) REFERENCES garden(garden_id);

ALTER TABLE garden_supplies ADD FOREIGN KEY (garden_id) REFERENCES garden(garden_id);
ALTER TABLE garden_supplies ADD FOREIGN KEY (supply_id) REFERENCES supplies(supply_id);
ALTER TABLE user_data ADD FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE garden ADD FOREIGN KEY (user_id) REFERENCES user_data(user_id);
ALTER TABLE plant_hardiness ADD FOREIGN KEY (hardiness_id) REFERENCES hardiness(hardiness_id);
ALTER TABLE plant_hardiness ADD FOREIGN KEY (plant_id) REFERENCES plant(plant_id);
ALTER TABLE plot ADD FOREIGN KEY (plant_id) REFERENCES plant(plant_id);
COMMIT TRANSACTION;