import com.github.javafaker.Faker;

import java.sql.*;
import java.util.Random;

public class Main
{

    public static void main(String [] args)
    {
        final String TAG = "Main";

        Faker faker = new Faker();

//        for (int i = 0 ; i < 100; ++i)
//        {
//            System.out.println(faker.company().bs());
//
//        }


        String url = "jdbc:mysql://localhost:3306/restaurant_db?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String password = "myPassword";

        Connection conn = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);


            for (int i = 0 ; i < 1000; ++i)
            {
                PreparedStatement pst = conn.prepareStatement
                        ("INSERT INTO restaurant (RESTAURANT_NAME, ADDRESS, CITY, STATE, ZIP_CODE, PRICE_RATING) "
                                + "VALUES (?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

                pst.setString(1, faker.company().name());
                pst.setString(2, faker.address().streetAddress());
                pst.setString(3, faker.address().city());
                pst.setString(4, faker.address().stateAbbr());
                pst.setString(5, faker.address().zipCode());

                Random rand = new Random();

                int pr = rand.nextInt(5) + 1;
                pst.setInt(6, pr);

                // getting the ID of what was just inserted
                int affectedRows = pst.executeUpdate();
                if (affectedRows == 0)
                {
                    throw new SQLException("Creating user failed, no rows affected.");
                }

                // adding to other tables with the key that we got
                try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        System.out.println(TAG + "Generated id: " + generatedKeys.getInt(1));

                        //Insert into category
                        pst = conn.prepareStatement
                                ("INSERT INTO category (RESTAURANT_ID, CATEGORY) "
                                        + "VALUES (?, ?);");
                        pst.setInt(1, generatedKeys.getInt(1));
                        pst.setString(2, faker.commerce().department());

                        pst.executeUpdate();

                        //Insert into Features
                        pst = conn.prepareStatement("INSERT INTO features(RESTAURANT_ID, ORDER_DELIVERY, ORDER_TAKEOUT, SERVES_ALCOHOL, KID_FRIENDLY, PET_FRIENDLY, INDOOR, OUTDOOR, TAKES_RESERVATIONS, OFFERS_DEALS, ACCEPTS_CREDIT_CARDS, GOOD_FOR_KIDS, GOOD_FOR_GROUPS, WAITER_SERVICE, WHEELCHAIR_ACCESSIBLE, DOGS_ALLOWED, OFFERS_MILITARY_DISCOUNT, FULL_BAR, HAPPY_HOUR, SERVES_BREAKFAST, SERVES_BRUNCH, SERVES_LUNCH, SERVES_DINNER, SERVES_DESSERT, HAS_LIVE_MUSIC, STREET_PARKING, GARAGE_PARKING, VALET_PARKING, PRIVATE_LOT, FREE_WIFI, ALLOWS_SMOKING)"
                                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        pst.setInt(1, generatedKeys.getInt(1));
                        for (int j = 2; j <= 31; ++j)
                        {
                            pst.setString(j, "N");
                        }

                        pst.executeUpdate();

                        //Insert into phone
                        pst = conn.prepareStatement
                                ("INSERT INTO phone (RESTAURANT_ID, PHONE) "
                                        + "VALUES (?, ?);");
                        pst.setInt(1, generatedKeys.getInt(1));
                        pst.setString(2, faker.phoneNumber().cellPhone());

                        pst.executeUpdate();

                        //Insert into website
                        pst = conn.prepareStatement
                                ("INSERT INTO website (RESTAURANT_ID, WEBSITE) "
                                        + "VALUES (?, ?);");
                        pst.setInt(1, generatedKeys.getInt(1));
                        pst.setString(2, faker.company().url());

                        pst.executeUpdate();



                        // TODO: Logging to file
                    }
                    else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }


                System.out.println("Inserted Successfully.");

                conn.commit();

            }



            conn.close();
        }
        catch (SQLException se)
        {
            try{
                if(conn != null)
                    conn.rollback();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            System.out.println(TAG + se);
        }
        catch (Exception e)
        {
            System.out.println(TAG + e);
        }

    }



}



