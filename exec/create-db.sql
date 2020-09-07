create table account (
	id bigint PRIMARY KEY AUTO_INCREMENT,
	name character varying(55),
	username character varying(55) NOT NULL,
	password character varying(155) NOT NULL,
);

create table role (
	id bigint PRIMARY KEY AUTO_INCREMENT,
	name character varying(55) NOT NULL UNIQUE
);

create table account_roles (
	role_id bigint NOT NULL REFERENCES role(id),
	account_id bigint NOT NULL REFERENCES account(id)
);

create table account_permissions (
	account_id bigint REFERENCES account(id),
	permission character varying(55)
);

create table posts (
	id bigint PRIMARY KEY AUTO_INCREMENT,
	account_id bigint NOT NULL REFERENCES account(id),
	content text,
	title character varying(172),
	date_posted bigint NOT NULL
);
