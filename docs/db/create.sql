
CREATE TABLE model (
	id serial NOT NULL,
	name character varying(50) NOT NULL UNIQUE,
	brand character varying(50) NOT NULL,
	created TIMESTAMP NOT NULL,
	updated TIMESTAMP NOT NULL default now(),
	CONSTRAINT model_pk PRIMARY KEY (id)
);



CREATE TABLE photo_link (
	id serial NOT NULL,
	ad_id integer NOT NULL,
	link character varying(300) NOT NULL UNIQUE,
	created TIMESTAMP NOT NULL,
	updated TIMESTAMP NOT NULL default now(),
	CONSTRAINT photo_link_pk PRIMARY KEY (id)
);



CREATE TABLE ad (
	id serial NOT NULL,
	user_account_id integer,
	model_id integer NOT NULL,
	engine_type character varying(50) NOT NULL,
	engine_volume integer NOT NULL,
	gearbox character varying(50) NOT NULL,
	year integer NOT NULL,
	mileage integer NOT NULL,
	color character varying(50) NOT NULL,
	price integer NOT NULL,
	barter BOOLEAN NOT NULL,
	active BOOLEAN NOT NULL,
	created TIMESTAMP NOT NULL,
	updated TIMESTAMP NOT NULL default now(),
	CONSTRAINT ad_pk PRIMARY KEY (id)
);



CREATE TABLE message (
	id serial NOT NULL,
	message character varying(500) NOT NULL,
	sender_id integer NOT NULL,
	recipient_id integer NOT NULL,
	ad_id bigint NOT NULL,
	viewed BOOLEAN NOT NULL,
	created TIMESTAMP NOT NULL,
	updated TIMESTAMP NOT NULL default now(),
	CONSTRAINT message_pk PRIMARY KEY (id)
);



CREATE TABLE user_account (
	id serial NOT NULL,
	email character varying(100) NOT NULL UNIQUE,
	password character varying(100) NOT NULL,
	name character varying(50) NOT NULL,
	city character varying(50) NOT NULL,
	phone character varying(50) NOT NULL,
	created TIMESTAMP NOT NULL,
	updated TIMESTAMP NOT NULL default now(),
	CONSTRAINT user_account_pk PRIMARY KEY (id)
);



CREATE TABLE parameter (
	id serial NOT NULL,
	name character varying(300) NOT NULL UNIQUE,
	created TIMESTAMP NOT NULL,
	updated TIMESTAMP NOT NULL default now(),
	CONSTRAINT option_pk PRIMARY KEY (id)
);



CREATE TABLE ad_parameter (
	ad_id integer NOT NULL,
	parameter_id integer NOT NULL
);


CREATE TABLE car_parameter (
	id serial NOT NULL,
	brand character varying(50) NOT NULL UNIQUE,
	engine_type character varying(50) NOT NULL UNIQUE,
	gearbox character varying(50) NOT NULL UNIQUE,
        color character varying(50) NOT NULL UNIQUE,
	created TIMESTAMP NOT NULL,
	updated TIMESTAMP NOT NULL default now(),
	CONSTRAINT car_parameters_pk PRIMARY KEY (id)
);


ALTER TABLE photo_link ADD CONSTRAINT photo_link_fk0 FOREIGN KEY (ad_id) REFERENCES ad(id);


ALTER TABLE ad ADD CONSTRAINT ad_fk0 FOREIGN KEY (user_account_id) REFERENCES user_account(id);
ALTER TABLE ad ADD CONSTRAINT ad_fk1 FOREIGN KEY (model_id) REFERENCES model(id);

ALTER TABLE message ADD CONSTRAINT message_fk0 FOREIGN KEY (sender_id) REFERENCES user_account(id);
ALTER TABLE message ADD CONSTRAINT message_fk1 FOREIGN KEY (recipient_id) REFERENCES user_account(id);
ALTER TABLE message ADD CONSTRAINT message_fk2 FOREIGN KEY (ad_id) REFERENCES ad(id);





ALTER TABLE ad_parameter ADD CONSTRAINT ad_parameter_fk0 FOREIGN KEY (ad_id) REFERENCES ad(id);
ALTER TABLE ad_parameter ADD CONSTRAINT ad_parameter_fk1 FOREIGN KEY (option_id) REFERENCES parameter(id);

