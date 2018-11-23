/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ericv
 */
@Entity
@Table(name = "restaurant", catalog = "restaurantdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT r FROM Restaurant r")
    , @NamedQuery(name = "Restaurant.findByRestaurantId", query = "SELECT r FROM Restaurant r WHERE r.restaurantId = :restaurantId")
    , @NamedQuery(name = "Restaurant.findByRestaurantName", query = "SELECT r FROM Restaurant r WHERE r.restaurantName = :restaurantName")
    , @NamedQuery(name = "Restaurant.findByAddress", query = "SELECT r FROM Restaurant r WHERE r.address = :address")
    , @NamedQuery(name = "Restaurant.findByCity", query = "SELECT r FROM Restaurant r WHERE r.city = :city")
    , @NamedQuery(name = "Restaurant.findByState", query = "SELECT r FROM Restaurant r WHERE r.state = :state")
    , @NamedQuery(name = "Restaurant.findByPhone", query = "SELECT r FROM Restaurant r WHERE r.phone = :phone")
    , @NamedQuery(name = "Restaurant.findByWebsite", query = "SELECT r FROM Restaurant r WHERE r.website = :website")
    , @NamedQuery(name = "Restaurant.findByNumOfReviews", query = "SELECT r FROM Restaurant r WHERE r.numOfReviews = :numOfReviews")
    , @NamedQuery(name = "Restaurant.findByAverageReview", query = "SELECT r FROM Restaurant r WHERE r.averageReview = :averageReview")
    , @NamedQuery(name = "Restaurant.findByOpenHoursPerWeek", query = "SELECT r FROM Restaurant r WHERE r.openHoursPerWeek = :openHoursPerWeek")
    , @NamedQuery(name = "Restaurant.findByPriceRating", query = "SELECT r FROM Restaurant r WHERE r.priceRating = :priceRating")
    , @NamedQuery(name = "Restaurant.findByMenuId", query = "SELECT r FROM Restaurant r WHERE r.menuId = :menuId")
    , @NamedQuery(name = "Restaurant.findByReviewsId", query = "SELECT r FROM Restaurant r WHERE r.reviewsId = :reviewsId")})
public class Restaurant implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RESTAURANT_ID")
    private Integer restaurantId;
    @Basic(optional = false)
    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "WEBSITE")
    private String website;
    @Column(name = "NUM_OF_REVIEWS")
    private Integer numOfReviews;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AVERAGE_REVIEW")
    private BigDecimal averageReview;
    @Column(name = "OPEN_HOURS_PER_WEEK")
    private BigDecimal openHoursPerWeek;
    @Column(name = "PRICE_RATING")
    private Short priceRating;
    @Column(name = "MENU_ID")
    private Integer menuId;
    @Column(name = "REVIEWS_ID")
    private Integer reviewsId;

    public Restaurant() {
    }

    public Restaurant(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Restaurant(Integer restaurantId, String restaurantName) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        Integer oldRestaurantId = this.restaurantId;
        this.restaurantId = restaurantId;
        changeSupport.firePropertyChange("restaurantId", oldRestaurantId, restaurantId);
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        String oldRestaurantName = this.restaurantName;
        this.restaurantName = restaurantName;
        changeSupport.firePropertyChange("restaurantName", oldRestaurantName, restaurantName);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        changeSupport.firePropertyChange("city", oldCity, city);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        String oldState = this.state;
        this.state = state;
        changeSupport.firePropertyChange("state", oldState, state);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        String oldWebsite = this.website;
        this.website = website;
        changeSupport.firePropertyChange("website", oldWebsite, website);
    }

    public Integer getNumOfReviews() {
        return numOfReviews;
    }

    public void setNumOfReviews(Integer numOfReviews) {
        Integer oldNumOfReviews = this.numOfReviews;
        this.numOfReviews = numOfReviews;
        changeSupport.firePropertyChange("numOfReviews", oldNumOfReviews, numOfReviews);
    }

    public BigDecimal getAverageReview() {
        return averageReview;
    }

    public void setAverageReview(BigDecimal averageReview) {
        BigDecimal oldAverageReview = this.averageReview;
        this.averageReview = averageReview;
        changeSupport.firePropertyChange("averageReview", oldAverageReview, averageReview);
    }

    public BigDecimal getOpenHoursPerWeek() {
        return openHoursPerWeek;
    }

    public void setOpenHoursPerWeek(BigDecimal openHoursPerWeek) {
        BigDecimal oldOpenHoursPerWeek = this.openHoursPerWeek;
        this.openHoursPerWeek = openHoursPerWeek;
        changeSupport.firePropertyChange("openHoursPerWeek", oldOpenHoursPerWeek, openHoursPerWeek);
    }

    public Short getPriceRating() {
        return priceRating;
    }

    public void setPriceRating(Short priceRating) {
        Short oldPriceRating = this.priceRating;
        this.priceRating = priceRating;
        changeSupport.firePropertyChange("priceRating", oldPriceRating, priceRating);
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        Integer oldMenuId = this.menuId;
        this.menuId = menuId;
        changeSupport.firePropertyChange("menuId", oldMenuId, menuId);
    }

    public Integer getReviewsId() {
        return reviewsId;
    }

    public void setReviewsId(Integer reviewsId) {
        Integer oldReviewsId = this.reviewsId;
        this.reviewsId = reviewsId;
        changeSupport.firePropertyChange("reviewsId", oldReviewsId, reviewsId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (restaurantId != null ? restaurantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.restaurantId == null && other.restaurantId != null) || (this.restaurantId != null && !this.restaurantId.equals(other.restaurantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AppPackage.Restaurant[ restaurantId=" + restaurantId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
