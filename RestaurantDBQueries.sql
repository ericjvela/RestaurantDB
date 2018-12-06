

-- #1. Display All Restaurants
-- #--------------------------
-- START TRANSACTION;
-- SELECT * FROM restaurant
-- COMMIT;

-- #2 Search Restaurant (Sub query)
-- #--------------------------
-- START TRANSACTION;
-- SELECT *
-- FROM restaurant AS r
-- INNER JOIN restaurant_type AS rt
-- ON r.RESTAURANT_ID = rt.RESTAURANT_ID
-- WHERE r.RESTAURANT_NAME = 'Calitacos' AND
-- 	  r.CITY = 'Orange' AND
--       r.STATE = 'CA' AND
--       rt.CATEGORY = 'Italian'
-- COMMIT;

-- #3. Display Restaurant Features + category
-- #----------------------------
--
SELECT r.RESTAURANT_ID,
	     r.RESTAURANT_NAME,
         c.CATEGORY,
			 f.ORDER_DELIVERY,
	   f.ORDER_TAKEOUT,
	   f.SERVES_ALCOHOL,
	   f.KID_FRIENDLY,
	   f.PET_FRIENDLY,
	   f.INDOOR,
	   f.OUTDOOR,
	   f.TAKES_RESERVATIONS,
     f.OFFERS_DEALS,
		 f.ACCEPTS_CREDIT_CARDS,
		 f.GOOD_FOR_KIDS,
		 f.GOOD_FOR_GROUPS,
		 f.WAITER_SERVICE,
		 f.WHEELCHAIR_ACCESSIBLE,
		 f.DOGS_ALLOWED,
		 f.OFFERS_MILITARY_DISCOUNT,
		 f.FULL_BAR,
		 f.HAPPY_HOUR,
		 f.SERVES_BREAKFAST,
		 f.SERVES_BRUNCH,
		 f.SERVES_LUNCH,
		 f.SERVES_DINNER,
		 f.SERVES_DESSERT,
		 f.HAS_LIVE_MUSIC,
		 f.STREET_PARKING,
		 f.GARAGE_PARKING,
		 f.VALET_PARKING,
		 f.PRIVATE_LOT,
		 f.FREE_WIFI,
		 f.ALLOWS_SMOKING
FROM restaurant AS r
INNER JOIN features AS f
ON r.RESTAURANT_ID = f.RESTAURANT_ID
INNER JOIN category as c
ON r.RESTAURANT_ID = c.RESTAURANT_ID
WHERE r.RESTAURANT_ID = ?

#4. Display Reviews
#--------------------------------
START TRANSACTION;
SELECT rd.RESTAURANT_ID,
	   rev.REVIEW_ID,
       rev.RATING_GIVEN,
       rev.POSTED_REVIEW
FROM reviews_directory AS rd
INNER JOIN reviews AS rev
ON rd.REVIEW_ID = rev.REVIEW_ID
COMMIT;

#5. Display Restaurant Menus
#---------------------------------
--Prompt for restaurant ID
SELECT r.RESTAURANT_ID,
		r.RESTAURANT_NAME,
		m.MENU_ID,
        mi.ITEM_ID,
        i.ITEM_NAME,
        i.ITEM_PRICE
FROM menu AS m
INNER JOIN restaurant AS r
ON m.RESTAURANT_ID = r.RESTAURANT_ID
INNER JOIN menu_items AS mi
ON m.MENU_ID = mi.MENU_ID
INNER JOIN item AS i
ON mi.ITEM_ID = i.ITEM_ID
ORDER BY MENU_ID DESC
WHERE RESTAURANT_ID = ?

#6. Insert Restaurant
#------------------------
#Already implemennted
START TRANSACTION;
INSERT INTO restaurant(
											RESTAURANT_NAME,
											ADDRESS,
											CITY,
											STATE,
											PHONE,
											WEBSITE,
											PRICE_RATING
											)
VALUES(?,?,?,?,?,?,?)
COMMIT;

#7. Insert Restaurant features/hours of operation
START TRANSACTION;
INSERT INTO features(
					 					 ORDER_DELIVERY,
                     ORDER_TAKEOUT,
                     SERVES_ALCOHOL,
                     KID_FRIENDLY,
                     PET_FRIENDLY,
                     INDOOR,
                     OUTDOOR,
                     TAKES_RESERVATIONS,
										 OFFERS_DEALS,
										 ACCEPTS_CREDIT_CARDS,
										 GOOD_FOR_KIDS,
										 GOOD_FOR_GROUPS,
										 WAITER_SERVICE,
										 WHEELCHAIR_SERVICE,
										 WHEELCHAIR_ACCESSIBLE,
										 DOGS_ALLOWED,
										 OFFERS_MILITARY_DISCOUNT,
										 FULL_BAR,
										 HAPPY_HOUR,
										 SERVES_BREAKFAST,
										 SERVES_BRUNCH,
										 SERVES_LUNCH,
										 SERVES_DINNER,
										 SERVES_DESERT,
										 HAS_LIVE_MUSIC,
										 STREET_PARKING,
										 GARAGE_PARKING,
										 VALET_PARKING,
										 PRIVATE_LOT,
										 FREE_WIFI,
										 ALLOWS_SMOKING
VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
COMMIT;

#9. Insert Review

START TRANSACTION;
--set up box to capture RESTAURANT_ID
INSERT INTO reviews (RATING_GIVEN, POSTED_REVIEW)
VALUES(?,?)
--use get generated key to get review id
INSERT INTO reviews_directory(RESTAURANT_ID, REVIEW_ID)
VALUES(?, ?)
COMMIT;

#10. Insert Menu (acknowledging the items table has all of the listed items needed
--prompt for restaurant_id of the restaurant they wish to add a menu to
START TRANSACTION;
INSERT INTO menu(RESTAURANT_ID)
VALUES(6)
COMMIT;

--use get generated key for menu_id
--have a display menu for the items table on the side
START TRANSACTION;
SELECT *
FROM items
COMMIT;

--allow user to look through table and add items
START TRANSACTION;
INSERT INTO menu_items(MENU_ID, ITEM_ID)
VALUES(?,?)
COMMIT;

#11. Update Restaurant

START TRANSACTION;
UPDATE restaurant
SET RESTAURANT_NAME = ?
WHERE RESTAURANT_ID = ?
COMMIT;


#15. Delete Restaurant
START TRANSACTION;
DELETE FROM restaurant
WHERE RESTAURANT_ID = ?
COMMIT;

#20. Export as csv
https://stackoverflow.com/questions/8563376/exporting-sql-query-result-to-a-csv-or-excel

#21. Group by clause
#Return 10 most frequent restaurant names
START TRANSACTION;
SELECT COUNT(RESTAURANT_ID) as Quantity, RESTAURANT_NAME
FROM restaurant
GROUP BY RESTAURANT_NAME, RESTAURANT_ID
LIMIT 10;
COMMIT;

#22. Include database views
