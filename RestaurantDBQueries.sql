

#1. Display All Restaurants
#--------------------------
SELECT * FROM restaurant

#2 Search Restaurant (Sub query)
#--------------------------
SELECT *
FROM restaurant AS r
INNER JOIN restaurant_type AS rt
ON r.RESTAURANT_ID = rt.RESTAURANT_ID
WHERE r.RESTAURANT_NAME = 'Calitacos' AND
	  r.CITY = 'Orange' AND
      r.STATE = 'CA' AND
      rt.CATEGORY = 'Italian'

#3. Display Restaurant Features
#----------------------------
SELECT r.RESTAURANT_ID, 
	   r.RESTAURANT_NAME, 
       rt.CATEGORY,
       f. ORDER_DELIVERY,
	   f.ORDER_TAKEOUT,
	   f.SERVES_ALCOHOL,
	   f.KID_FRIENDLY,
	   f.PET_FRIENDLY,
	   f.INDOOR,
	   f.OUTDOOR,
	   f.TAKES_RESERVATIONS,
       f.OFFERS_DEALS,
       #INCLUDE WHAT EVER IS LEFT IN THE FEATURES TABLE AS f.col_name
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
       h.SUN_END
FROM restaurant AS r
INNER JOIN features AS f
ON r.RESTAURANT_ID = f.RESTAURANT_ID
INNER JOIN hours_of_operation AS h
ON f.RESTAURANT_ID = h.RESTAURANT_ID
INNER JOIN restaurant_type AS rt
ON h.RESTAURANT_ID = rt.RESTAURANT_ID

#4. Display Reviews
#--------------------------------
SELECT rd.RESTAURANT_ID,
	   rev.REVIEW_ID,
       rev.RATING_GIVEN,
       rev.POSTED_REVIEW
FROM reviews_directory AS rd
INNER JOIN reviews AS rev
ON rd.REVIEW_ID = rev.REVIEW_ID

#5. Display Restaurant Menus
#---------------------------------
#TBD

#6. Insert Restaurant
#------------------------
#Already implemennted

#7. Insert Restaurant features
INSERT INTO features(RESTAURANT_ID,
					 ORDER_DELIVERY,
                     ORDER_TAKEOUT,
                     SERVES_ALCOHOL,
                     KID_FRIENDLY,
                     PET_FRIENDLY,
                     INDOOR,
                     OUTDOOR,
                     TAKES_RESERVATIONS
                     #Whatever is left
VALUES(#however many ?, ?, ?, ?, ...)

#8. Insert Hours of Operation
INSERT INTO hours_of_operation(RESTAURANT_ID,
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
VALUES (7, 
		'9:00', 
        '21:00', 
        '9:00', 
        '21:00', 
        '9:00', 
        '21:00', 
        '9:00', 
        '21:00', 
        '9:00', 
        '21:00',
        '9:00', 
        '21:00',
        '9:00', 
        '21:00')
        
#9. Insert Review
#PROMPT FOR RESTAURANT_ID, RATING_GIVEN OUT OF 5 or 10, POSTED_REVIEW is their explanation
INSERT INTO reviews (RATING_GIVEN, POSTED_REVIEW)
VALUES(4, 'It was great!')
#restaurant id populated with user input
INSERT INTO reviews_directory(RESTAURANT_ID, REVIEW_ID)
VALUES(6, #most recent review_ID)

#10. Insert Menu (acknowledging the items table has all of the listed items needed
#prompt for restaurant ID
#menu ID should be AutoIncremented
INSERT INTO menu(RESTAURANT_ID)
VALUES(6)


#Prompt for menu_id, add item_id endlessly
INSERT INTO menu_items(MENU_ID, ITEM_ID)
VALUES(#do not know how we would get the menu_id ,#Item they seelcted)

#11. Update Restaurant
UPDATE restaurant
SET RESTAURANT_NAME = ?
WHERE RESTAURANT_ID = ?

UPDATE restaurant
SET ADDRESS = ?
WHERE RESTAURANT_ID = ?

UPDATE restaurant
SET CITY = ?
WHERE RESTAURANT_ID = ?

UPDATE restaurant
SET STATE = ?
WHERE RESTAURANT_ID = ?

UPDATE restaurant
SET PHONE = ?
WHERE RESTAURANT_ID = ?

UPDATE restaurant
SET PRICE_RATING = ?
WHERE RESTAURANT_ID = ?

#15. Delete Restaurant
DELETE FROM restaurant
WHERE RESTAURANT_ID = ?

#19. Somehow use a transaction
#20. Export as csv

#21. Group by clause
#Return items of a menu by the item in alphabetical order
SELECT menu.RESTAURANT_ID,
		mi.MENU_ID, 
		mi.ITEM_ID
FROM menu_items AS mi
INNER JOIN menu AS menu
ON mi.MENU_ID = menu.MENU_ID
WHERE MENU_ID = ?
#22. Include database views

