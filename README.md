# Restaurant Database

## By: Eric Vela and Charlie Liu

### Description:
A relational database that stores information regarding restaurants with an easy-to-navigate user interface. For a full description see directory.

### Relational Database Diagram:
- See directory above

### Programs used:
- NetBeans IDE (Java)
- JDBC
- MySQL

### Specs
- RDBMS Key Constraints
- Uses transactions (Commit & rollback)
- Maintains transaction log
- Uses RegEx to limit user input streams
- Utilizes Faker to populate database with data
- Export main table (restaurant) as CSV
- --In RestaurantGUI file as "Export.csv"

### Setup
- Download NetBeans IDE
- Open Project Folder and select "RestaurantGUI" from the repo
- Click the Services tab > Databases and add connection (See schema file)
- Add r2xml.jar and the MySQL connector as Libraries
- Run faker file in restaurant_faker > src > Main.java to generate some fake data

### Database Schema
- See directory above

### Database Schema Explanation
The "restaurant" table is the main parent table in this database as outlined by the coloring in the database diagram. The RESTAURANT_ID is used across most of the other tables wihtin the database and acts as a unique identifer for any restaurant.

The "category" table is setup such that one restaurant can have multiple different types of food served. Thus, a Japanese restaurant can have "Asian", "Seafood", and "Japanese" as their categories.

The "phone" table is setup to maintain 3rd normal form.

The "website" table is setup to maintain 3rd normal form.

The "features" table is an extension of the restaurant table because only one restaurant has its own set of features.

The "reviews_directory" can have multiple reviews (REVIEW_ID) for the same restaurant (RESTAURANT_ID).

The "reviews" table shows all of the reviews given.

The "menu_items" table is a directory such that items from the "item" table can be added to a restaurant menu. A restaurant can only have one menu.

The "item" table holds all of the possible items that can be added to a menu in "menu_items."

### Project	Details:
1. Print/display records	from	your	database/tables.
2. Query for	data/results	with	various	parameters/filters
3. Create	a	new	record
4. Delete	records	(soft	delete function	would	be	ideal)
5. Update	records
6. Make	use	of	transactions	(commit	&	rollback)
7. Generate	reports	that	can	be	exported	(excel	or	csv	format)
8. One	query	must	perform	an	aggregation/group-by	clause
9. One	query	must	contain	a	sub-query.
10. Two	queries	must	involve	joins	across	at	least	3	tables
11. Enforce	referential	integrality (Constraints)
12. Include	Database	Views,	Indexes
