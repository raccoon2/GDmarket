package gdmarket;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewInfoRepository extends CrudRepository<ReviewInfo, Long> {
   // List<ReviewInfo> findByReviewNo(Integer reviewNo);
}