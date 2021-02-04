package gdmarket;

import javax.persistence.*;

@Entity
@Table(name="ReviewInfo_table")
public class ReviewInfo {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Integer reviewNo;
        private Integer customerId;
        private String customerName;
        private Integer score;

    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
    public Integer getReviewNo() {
        return reviewNo;
    }
    public void setReviewNo(Integer reviewNo) {
        this.reviewNo = reviewNo;
    }
}
