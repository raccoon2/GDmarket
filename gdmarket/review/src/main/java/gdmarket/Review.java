package gdmarket;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Review_table")
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer reviewNo;
    private String customerName;
    private Integer itemNo;
    private Integer reservationNo;
    private String reviewTxt;

    @PostPersist
    public void onPostPersist(){
        Reviewed reviewed = new Reviewed();
        BeanUtils.copyProperties(this, reviewed);
        reviewed.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        gdmarket.external.Item item = new gdmarket.external.Item();
        // mappings goes here
        ReviewApplication.applicationContext.getBean(gdmarket.external.ItemService.class)
            .deleteItem(item);


    }

    @PrePersist
    public void onPrePersist(){
        RequestedReview requestedReview = new RequestedReview();
        BeanUtils.copyProperties(this, requestedReview);
        requestedReview.publishAfterCommit();


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
    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }
    public Integer getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(Integer reservationNo) {
        this.reservationNo = reservationNo;
    }
    public String getReviewTxt() {
        return reviewTxt;
    }

    public void setReviewTxt(String reviewTxt) {
        this.reviewTxt = reviewTxt;
    }




}
