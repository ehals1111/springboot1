package com.example.demo.ex1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ifs.CrudInterface;
import com.example.demo.model.OrderGroup;
import com.example.demo.model.User;
import com.example.demo.network.Header;
import com.example.demo.network.request.ItemApiRequest;
import com.example.demo.network.request.UserApiRequest;
import com.example.demo.network.response.ItemApiResponse;
import com.example.demo.network.response.UserApiResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ItemApiLogicService;

@RestController
@RequestMapping("/settlement")
public class settlementApiController{

	@Autowired
	private SettlementRepository settlementRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	/*CREATE TABLE `Settlement` (
			  `id` bigint(20) NOT NULL AUTO_INCREMENT,
			  `total_price` decimal(12,4) DEFAULT NULL,
			  PRIMARY KEY (`id`)
			) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
	 */
	@GetMapping("{id}") 
	public OrderGroup read(@PathVariable Long id) {
		// TODO Auto-generated method stub
		
		Optional<User> optional = userRepository.findById(id);
		
		return (OrderGroup) optional.map(user -> user.getOrderGroup()).get();

		
		// 1.해당 유저 id를 order_group에서 찾는다.
		// 1.5 . order_group에 해당 유저가 주문한 모든 값을 더한다.
		// 2.Settlement 테이블에 칼럼의 값이 있는지 확인 (주문 할때마다 값이 변하기 때문에)
		// 3. 칼럽에 값이 없으면 insert하고 있으면 update를 한다.
		// 4. Settlement 를 select하고 json 형태로 출력한다.
		
		
		//제가 생각한 로직인데  1.5번에  order_group에  해당 하는 유저가 주문한 모든 값을 더해야 하는데 jpa를 아직 이해를 다 못하다보니 못했습니다.
		//단순히 spring mvc  써서 하면 쉬운 반면 jpa의 이해도가 아직 부족한거 같습니다. 
	}


		
}
