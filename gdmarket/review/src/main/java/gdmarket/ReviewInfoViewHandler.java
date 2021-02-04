package gdmarket;

import gdmarket.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewInfoViewHandler {


    @Autowired
    private ReviewInfoRepository reviewInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReviewed_then_CREATE_1 (@Payload Reviewed reviewed) {
        try {
            if (reviewed.isMe()) {
                ReviewInfo reviewInfo = new ReviewInfo();
                reviewInfo.setReviewNo(reviewed.getReviewNo());
                reviewInfo.setScore(reviewed.getScore());
                reviewInfo.setCustomerName(reviewed.getCustomerName());
                reviewInfo.setCustomerId(reviewed.getCustomerId());
                reviewInfoRepository.save(reviewInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}