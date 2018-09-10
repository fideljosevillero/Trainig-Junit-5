package co.com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TrainingJava8 {

	private List<Integer> listNumbers;
	
	public TrainingJava8(){
		this.listNumbers = new ArrayList<>( Arrays.asList(1,2,3,4,5,6,7));
	}
	
	public List<Integer> getEvenNumbers(List<Integer> lista){
		return lista.stream()
					.filter(n -> n % 2 == 0 )
					.filter(n -> n != 2)
					.collect(Collectors.toList());
	}
	
}
