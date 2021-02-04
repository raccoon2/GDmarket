
package gdmarket.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="item", url="http://item:8080")
public interface ItemService {

    @RequestMapping(method= RequestMethod.DELETE, path="/items")
    public void deleteItem(@RequestBody Item item);

}