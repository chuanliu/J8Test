package j8test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class Map {
	public static void main(String arg[]){
		List<Integer> list = Arrays.asList(1,2, 3);
		
				List result = list.stream().map(p->p+1).collect(Collectors.toList());
//				list.stream().flatMap();
				System.out.println(result);
	}

}
