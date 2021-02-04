package gdmarket;

import gdmarket.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    ReviewRepository reviewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReturnedItem_(@Payload ReturnedItem returnedItem){
        if(returnedItem.isMe()){
            System.out.println("##### listener  : " + returnedItem.toJson());
            System.out.println("##### returnedItemNo:"+returnedItem.getItemNo());
            System.out.println("###################알림 메시지#####################");
            System.out.println(" 고객님, 대여 거래(" +returnedItem.getReservationNo()+ ")번에 대한 평점을 남겨주시기 바랍니다.");
            System.out.println("#################################################");

        }


    }

}
