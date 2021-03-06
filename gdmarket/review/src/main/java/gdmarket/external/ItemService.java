
package gdmarket.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="item", url="${api.url.item}")
public interface ItemService {

    @RequestMapping(method= RequestMethod.PATCH, path="/items/")
    public void itemDeleted(@RequestBody Item item);

}