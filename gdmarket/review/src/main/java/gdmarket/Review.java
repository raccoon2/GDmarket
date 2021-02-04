package gdmarket;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import gdmarket.external.Item;
import gdmarket.external.ItemService;

@Entity
@Table(name="Review_table")
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer reviewNo;
    private Integer customerId;
    private String customerName;
    private String itemName;
    private Integer reservationNo;
    private Integer score;

    @PostPersist
    public void onPostPersist(){
        Reviewed reviewed = new Reviewed();
        reviewed.setCustomerId(this.getCustomerId());
        reviewed.setScore(this.getScore());
        reviewed.setCustomerName(this.getCustomerName());
        BeanUtils.copyProperties(this, reviewed);
        reviewed.publishAfterCommit();

        Item item = new Item();
        item.setItemNo(this.getReviewNo());
        // mappings goes here
        ReviewApplication.applicationContext.getBean(ItemService.class).deleteItem(item.getItemNo(),"deleted");
    }

    public Integer getReviewNo() {
        return reviewNo;
    }
    public void setReviewNo(Integer reviewNo) {
        this.reviewNo = reviewNo;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getReservationNo() {
        return reservationNo;
    }
    public void setReservationNo(Integer reservationNo) {
        this.reservationNo = reservationNo;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
}
