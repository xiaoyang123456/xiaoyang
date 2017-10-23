import java.util.Map;

import com.FOD.factory.ServiceFactory;

public class lalaaltest {
	
	public static void main(String[] args) {
		Map<String, Object> map = ServiceFactory.getIZhFoodSer().getInForMap();
		System.out.println(map);
	}
}
