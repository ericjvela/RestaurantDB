

#1. Display All Restaurants
#--------------------------
START TRANSACTION;
SELECT * FROM restaurant
COMMIT;

#2 Search Restaurant (Sub query)
#--------------------------
START TRANSACTION;
SELECT *
FROM restaurant AS r
INNER JOIN restaurant_type AS rt
ON r.RESTAURANT_ID = rt.RESTAURANT_ID
WHERE r.RESTAURANT_NAME = 'Calitacos' AND
	  r.CITY = 'Orange' AND
      r.STATE = 'CA' AND
      rt.CATEGORY = 'Italian'
COMMIT;

#3. Display Restaurant Features
#----------------------------
START TRANSACTION;
SELECT r.RESTAURANT_ID,
	     r.RESTAURANT_NAME,
       rt.CATEGORY,
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
		 f.WHEELCHAIR_SERVICE,
		 f.WHEELCHAIR_ACCESSIBLE,
		 f.DOGS_ALLOWED,
		 f.OFFERS_MILITARY_DISCOUNT,
		 f.FULL_BAR,
		 f.HAPPY_HOUR,
		 f.SERVES_BREAKFAST,
		 f.SERVES_BRUNCH,
		 f.SERVES_LUNCH,
		 f.SERVES_DINNER,
		 f.SERVES_DESERT,
		 f.HAS_LIVE_MUSIC,
		 f.STREET_PARKING,
		 f.GARAGE_PARKING,
		 f.VALET_PARKING,
		 f.PRIVATE_LOT,
		 f.FREE_WIFI,
		 f.ALLOWS_SMOKING
       h.MON_START,
       h.MON_END,
       h.TUE_START,
       h.TUE_END,
       h.WED_START,
       h.WED_END,
       h.THU_START,
       h.THU_END,
       h.FRI_START,
       h.FRI_END,
       h.SAT_START,
       h.SAT_END,
       h.SUN_START,
       h.SUN_END,
			 rt.CATEGORY
FROM restaurant AS r
INNER JOIN features AS f
ON r.RESTAURANT_ID = f.RESTAURANT_ID
INNER JOIN hours_of_operation AS h
ON f.RESTAURANT_ID = h.RESTAURANT_ID
INNER JOIN restaurant_type AS rt
ON h.RESTAURANT_ID = rt.RESTAURANT_ID
COMMIT;

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
#TBD

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

#7. Insert Restaurant features
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

#8. Insert Hours of Operation
START TRANSACTION;
INSERT INTO hours_of_operation(
							   							 MON_START,
                               MON_END,
                               TUE_START,
                               TUE_END,
                               WED_START,
                               WED_END,
                               THU_START,
                               THU_END,
                               FRI_START,
                               FRI_END,
                               SAT_START,
                               SAT_END,
                               SUN_START,
                               SUN_END)
VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)
COMMIT;

#9. Insert Review
#PROMPT FOR RESTAURANT_ID, RATING_GIVEN OUT OF 5 or 10, POSTED_REVIEW is their explanation
#still need to finish

START TRANSACTION;
INSERT INTO reviews (RATING_GIVEN, POSTED_REVIEW)
VALUES(4, 'It was great!')
#restaurant id populated with user input
INSERT INTO reviews_directory(RESTAURANT_ID, REVIEW_ID)
VALUES(6, #most recent review_ID)
COMMIT;

#10. Insert Menu (acknowledging the items table has all of the listed items needed
#prompt for restaurant ID
#menu ID should be AutoIncremented
#still need to finish
START TRANSACTION;
INSERT INTO menu(RESTAURANT_ID)
VALUES(6)
COMMIT;


#Prompt for menu_id, add item_id endlessly
#still need to finish
START TRANSACTION;
INSERT INTO menu_items(MENU_ID, ITEM_ID)
VALUES(#do not know how we would get the menu_id ,#Item they seelcted)
COMMIT;

#11. Update Restaurant

START TRANSACTION;
UPDATE restaurant
SET RESTAURANT_NAME = ?
WHERE RESTAURANT_ID = ?
COMMIT;

START TRANSACTION;
UPDATE restaurant
SET ADDRESS = ?
WHERE RESTAURANT_ID = ?
COMMIT;

START TRANSACTION;
UPDATE restaurant
SET CITY = ?
WHERE RESTAURANT_ID = ?
COMMIT;

START TRANSACTION;
UPDATE restaurant
SET STATE = ?
WHERE RESTAURANT_ID = ?
COMMIT;

START TRANSACTION;
UPDATE restaurant
SET PHONE = ?
WHERE RESTAURANT_ID = ?
COMMIT;

START TRANSACTION;
UPDATE restaurant
SET PRICE_RATING = ?
WHERE RESTAURANT_ID = ?
COMMIT;


#15. Delete Restaurant
START TRANSACTION;
DELETE FROM restaurant
WHERE RESTAURANT_ID = ?
COMMIT;

#20. Export as csv

#21. Group by clause
#Return 10 most frequent restaurants
START TRANSACTION;
SELECT COUNT(RESTAURANT_ID) as Quantity, RESTAURANT_NAME
FROM restaurant
GROUP BY RESTAURANT_NAME, RESTAURANT_ID
LIMIT 10;
COMMIT;

#22. Include database views
