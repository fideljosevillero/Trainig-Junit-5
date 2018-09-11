package co.com.practice;

import java.util.List;
import java.util.stream.Collectors;

public class TrainingJava8 {
	
	public List<Integer> getEvenNumbers(List<Integer> lista){
		return lista.stream()
					.filter(n -> n % 2 == 0 )
					.filter(n -> n != 2)
					.limit(4)
					.collect(Collectors.toList());
	}
	
	public float getFreeSalary(float totalSalary) {
		return totalSalary - get8Percent(totalSalary);
	}
	
	public float get8Percent(float total) {
		return (total * 8) / 100;
	}
	
}
