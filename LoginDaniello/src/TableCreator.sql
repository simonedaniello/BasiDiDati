
/*creazione del database*/





/*creazione delle tabelle*/

DROP SCHEMA SISTEMADIGALASSIE CASCADE;
CREATE SCHEMA SISTEMADIGALASSIE;

/*------------------------------------------------------------------------------------------------------------*/

/*		TABELLE MODELLO E-R		*/

/*-----------------------------Galaxy------------------------*/
CREATE TABLE SISTEMADIGALASSIE.Galaxy (
	DISTANCE				INT,
	NAME					VARCHAR(20)		PRIMARY KEY,
	ALTNAME					VARCHAR(20),
	SPECTRALCLASSIFICATION	VARCHAR(20),
	REDSHIFT				INT
);

/*-----------------------------Metallicity------------------------*/
CREATE TABLE SISTEMADIGALASSIE.Metallicity(
	VALUE	INT ,
	ERRORM	INT ,
	GALAXYNAMEMET 	VARCHAR(20)
					REFERENCES Galaxy(NAME),
	PRIMARY KEY (VALUE, ERRORM)
);

/*-----------------------------Luminosity------------------------*/
CREATE TABLE SISTEMADIGALASSIE.Luminosity(
	LFLAG 		BOOLEAN , 
	ABSORPTION	INT ,
	GALAXYNAMELUM 	VARCHAR(20)
					REFERENCES Galaxy(NAME),
	PRIMARY KEY(LFLAG, ABSORPTION)
);

/*-----------------------------Coordinate------------------------*/
CREATE TABLE SISTEMADIGALASSIE.Coordinate(
	RASCH 	INT	, 
	RASCM	INT	,
	RASCS	INT	,
	DECSIGN	INT	,
	DECMIN	INT	,
	DECSEC	INT	,
	DECDEG	INT	,
	GALAXYNAMECOO 	VARCHAR(20)
					REFERENCES Galaxy(NAME),
	PRIMARY KEY (GALAXYNAMECOO)
);

/*-----------------------------HPfluxR------------------------*/
CREATE TABLE SISTEMADIGALASSIE.HPfluxR(
	NAMEHPR			VARCHAR, 
	PIXELR 			VARCHAR,
	VALUER			INT,
	ERRORR			INT,
	FLAGULR			BOOLEAN,
	GALAXYNAMEHPR 	VARCHAR(20)
					REFERENCES Galaxy(NAME),
	PRIMARY KEY(NAMEHPR, PIXELR, GALAXYNAMEHPR)
);

/*-----------------------------HPfluxC------------------------*/
CREATE TABLE SISTEMADIGALASSIE.HPfluxC(
	NAMEHPC			VARCHAR, 
	PIXELC 			VARCHAR,
	VALUEC			INT,
	ERRORC			INT,
	FLAGULC			BOOLEAN,
	GALAXYNAMEHPC 	VARCHAR(20)
					REFERENCES Galaxy(NAME),
	PRIMARY KEY(NAMEHPC, PIXELC, GALAXYNAMEHPC)
);

/*-----------------------------HPSpitzerflux------------------------*/
CREATE TABLE SISTEMADIGALASSIE.Spitzerflux(
	NAMES			VARCHAR(20),
	VALUESP			INT,
	FLAG 			BOOLEAN,
	ERRORS			INT,
	IRS				INT,
	GALAXYNAMES 	VARCHAR(20)
					REFERENCES Galaxy(NAME),
	PRIMARY KEY(NAMES, GALAXYNAMES)
);

/*		TABELLE IMPLEMENTAZIONE SOFTWARE UTENTE		*/

/*-----------------------------User------------------------*/
CREATE TABLE SISTEMADIGALASSIE.User(
	NOME			VARCHAR(20)		NOT NULL,
	COGNOME			VARCHAR(20)		NOT NULL,
	USERID			INT				NOT NULL,
	PASSWORD		VARCHAR(20)				,
	EMAIL			VARCHAR					,
	AMMINISTRATORE	BOOLEAN						,
	PRIMARY KEY (EMAIL, PASSWORD)
);


/*------------------------------------------------------------------------------------------------------------*/

/*		RELATIONSHIPS	
le nostre relazioni sono tutte 1-n oppure 1-1 quindi credo queste tabelle non servano a un cavolo
*/
/*
/*-----------------------------GLocation------------------------galaxy-coordinate*/
CREATE TABLE GLocation(
	GALAXYNAMELOC 	VARCHAR(20)
					REFERENCES Galaxy(NAME),
	GALAXYLOC 		
	PRIMARY KEY(GALAXYNAMELOC)
);

/*-----------------------------GMetallicity------------------------Galaxy-Metallicity*/
CREATE TABLE GMetallicity(
	GALAXYNAMEMET 	VARCHAR(20)
					REFERENCES Galaxy(NAME),
);

/*-----------------------------GLuminosity------------------------Galaxy-Luminosity*/
CREATE TABLE GLuminosity(
	GALAXYNAMELUM 	VARCHAR(20)
					REFERENCES Galaxy(NAME),
);

/*-----------------------------GHPR------------------------Galaxy-HPfluxR*/
CREATE TABLE GHPR(
	GALAXYNAMEHPR 	VARCHAR(20)
					REFERENCES Galaxy(NAME),
	ATOMNAMER		VARCHAR
					REFERENCES HPfluxR(NAMEHPR),
	PIXELRR			VARCHAR
					REFERENCES HPfluxR(PIXELR),
	PRIMARY KEY(GALAXYNAMEHPR, ATOMNAMER, PIXELRR)			
);

/*-----------------------------GHPC------------------------Galaxy-HPfluxC*/
CREATE TABLE GHPC(
	GALAXYNAMEHPC 	VARCHAR(20)
					REFERENCES Galaxy(NAME),
	ATOMNAMEC		VARCHAR
					REFERENCES HPfluxC(NAMEHPR),
	PIXELCR			VARCHAR
					REFERENCES HPfluxC(PIXELR),
	PRIMARY KEY(GALAXYNAMEHPC, ATOMNAMEC, PIXELCR)			
);

/*-----------------------------GSpitzer------------------------Galaxy-Spitzerflux*/							
CREATE TABLE GSpitzer(																						
	GALAXYNAMESPITZER 	VARCHAR(20)																			
						REFERENCES Galaxy(NAME),															
	ATOMNAME			VARCHAR																				
						REFERENCES HPfluxC(NAMEHPR),														
	PIXELSPITZER			VARCHAR																			
						REFERENCES HPfluxC(PIXELR),															
	PRIMARY KEY(GALAXYNAMEHPC, ATOMNAMEC, PIXELCR)															
);												

*/
																											
/*------------------------------------------------------------------------------------------------------------*/




/*--------------------------------OPERAZIONI----------------------------*/


/*
per query n to n 
Consider the alternatives of embedding a column from one table in the other table: embedding b_id in the A table or a_id in the B table. Suppose we put the b_ids in A. By embedding the b_id in the A table, we are associating one and only one B entity with a particular A entity. This cannot be the situation according to the ER diagram, because for any A entity there are possibly many associated B entities. By rule #1 we can't do this.

Suppose we put the a_ids in B. By embedding the a_id in the B table, we are associating one and only one A entity with a particular B entity. This cannot be the situation according to the ER diagram, because for any B entity there are possibly many A entities—-so you would possibly have to put many a_ids in one record. By rule #1 we can't do this.

The only other alternative is to create a third table: the R relation with a_id and b_id embedded in it. First we need to determine what the key should be. The obvious choies are to use either a_id alone or b_id alone. Consider a_id: Again, for every A entity there are potentially many B entities. This means that a_id might appear in many rows of R. This means that it cannot be the key by itself. The situation is the same for b_id. The other alternative is to use the combination of a_id and b_id as the primary key. Each row in R represents a relationship between an A entity and a B entity. Since there is no reason to list a particular relationship twice, the combination of these two columns can serve as the primary key.

Given the above discussion, the table structure is as follows:

A(__a_id__, a_name, <a_other>)
B(__b_id__, b_name, <b_other>)
R(__fk_r_a*, fk_r_b*__, <r_other>)

Given this table structure, we must only determine which foreign keys can be null and which are unique. There are two foreign keys in these tables. Every row in the R table represents a relationship between an entity in the A table and an entity in the B table. If either column is null, it should not be a row in the R table since this would mean that there is not a relationship between the two entities. The column fk_r_b cannot be unique since each B entity possibly can be in many relationships. The column fk_r_a cannot be unique since each A entity possibly can be in many relationships. Given this information, we have the following SQL create statements:

create table A
  (a_id type,
   a_name type,
   <a_other>,
   primary key (a_id));
create table B
  (b_id type,
   b_name type,
   <b_other>,
   primary key (b_id));
create table R
  (fk_r_a type,
   fk_r_b type,
   <r_other>,
   primary key (fk_r_a, fk_r_b),
   foreign key (fk_r_a) references A,
   foreign key (fk_r_b) references B);

*/

/*
per query 1 to n
The two alternatives to look at first are to embed b_id in the A table or embed the a_id in the B table. Suppose we put the b_ids in A. By embedding the b_id in the A table, we are associating one and only one B entity with a particular A entity. This cannot be true according to the ER diagram, because for any A entity there are possibly many B entities. Since we cannot put multiple values in a column (rule #1), embedding in this direction is not a good choice.

The other alternative is to put the a_ids in the B table. By embedding the a_id in the B table, we are associating one and only one A entity with a particular B entity. By the ER diagram, for any B entity there is one and only one A entity. Thus, the embedded a_id column must have a value in it.

Given the above discussion, the table structure is as follows (see this page for how this should be interpreted):

A(__a_id__, a_name, <a_other>)
B(__b_id__, b_name, fk_b_a*, <b_other>)

Since this is the first one of these, I will interpret it for you: The A table has a primary key a_id and another field a_name. If A has any other attributes, they would be stored in this table as well (a_other). The B table has a primary key b_id and another field b_name. A third field (fk_b_a) is a foreign key that references the A table. If B has any other attributes, they would be stored in this table as well (b_other).

Given this table structure, we must only determine which foreign keys can be null and which are unique. The column fk_b_a is the only foreign key in these two tables. By looking at the ER diagram we can see that it cannot be null: for every B entity there must be one associated A entity. Since fk_b_a represents the associated A entity, it cannot be null. The value in fk_b_a cannot be unique since there are possibly many B entities associated with the same A entity; thus, the same a_id would be repeated in the fk_b_a column of many rows of B. Given this information, we have the following SQL create statements (see this page for how this should be interpreted):

create table A
  (a_id type primary key,
   a_name type,
   <a_other>);
create table B (
   b_id type primary key,
   b_name type,
   fk_b_a type not null,
   <b_other>,
   foreign key (fk_b_a) references a);
*/

/*

/*	
REQ-­‐FN-­‐3
registrazione nuovo utente 
*/
INSERT INTO User (NOME, COGNOME, USERID, PASSWORD, EMAIL, AMMINISTRATORE)
VALUES (?, ?, ?, ?, ?, 0);

/*
REQ-­‐FN-­‐5
 Un utente registrato potrà effettuare una ricerca per nome della 
galassia ed il risultato visualizzerà la posizione, la distanza con il 
relativo valore di redshift, luminosità e metalicità
con i rispettivi errori
*/
SELECT REDSHIFT, RASCH, RASCM, RASCS, DECSIGN, DECDEG, DECMIN, DECSEC, DISTANCE, ABSORPTION, VALUE, ERRORM
FROM Galaxy, Luminosity, Metallicity, Coordinate
WHERE Galaxy.NOME = Luminosity.GALAXYNAMELUM AND Galaxy.NOME = Metallicity.GALAXYNAMEMET AND Galaxy.NOME = Coordinate.GALAXYNAMECOO



/*
REQ-­‐FN-­‐6
ricercare le prime n galassie all'interno di un raggio ordinandole rispetto al centro del raggio

d = arccos(sin(ra1)*sin(ra2) + cos(ra1)*cos(ra2)*cos(dec1-dec2))

RA(degrees) = 15*(HH+MM/60+SS/3600)
Dec(decimal degrees) = +or- (DD + MM/60 + SS(3600))
*/

/*penso che in java possa essere scritto in questo modo più o meno*/


	/*reggio dato dal problema*/
	int raggio; /*da istanziare*/
	int RA1; /*da istanziare*/
	int DEC1; /*da istanziare*/
	ArrayList<String> heapGalassie = new ArrayList<String>();
	
	int rasch;
	int rascm;
	int rascs;
	int decsign;
	int decmin;
	int decsec;
	int decdeg;

	/*declarations of distance*/
	int distance;
	int RA;
	int DEC;
	String gal;

	String sql = "	SELECT 	GALAXYNAMECOO, RASCH, RASCM, RASCS,
	  						DECSIGN, DECMIN, DECSEC, DECDEG
	  				FROM Coordinate";
	ResultSet rs = stmt.executeQuery(sql);	
	while(re.next())
	{
		gal = rs.getString("GALAXYNAMECOO");
		rasch = rs.getInt("RASCH");
		rascm = rs.getInt("RASCM");
		rascs = rs.getInt("RASCS");
		decsign = rs.getInt("DECSIGN");
		decmin = rs.getInt("DECMIN");
		decsec = rs.getInt("DECSEC");
		decdeg = rs.getInt("DECDEG");

		RA = 15*(rasch+rascm/60+rascs/3600);
		DEC =(decdeg + decmin/60 + decsec(3600)); /*non ci importa del segno*/

		distance = arccos(sin(RA1)*sin(RA) + cos(RA1)*cos(RA)*cos(DEC1-DEC));
		if (distance > raggio)
		{
			heapGalassie.add("gal");
		}
	} /*manca l'ordinamento ma quello si fa abbastanza facilmente*/  

/*
REQ-­‐FN-­‐7
un utente registrato potrà richiedere i valori dei flussi e il relativo errore di una o più righe spettrali di un specifica galassia.
l'applicazione visualizzerà se è un upper limit o se è un valore effetivamente calcolato. E IO COME FACCIO A SAPERLO ?
*/

SELECT NAME  
FROM Galaxy
WHERE Galaxy.REDSHIFT > ? 
ORDER BY Galaxy.REDSHIFT desc

oppure 

SELECT NAME  
FROM Galaxy
WHERE Galaxy.REDSHIFT < ? 
ORDER BY Galaxy.REDSHIFT desc*/
