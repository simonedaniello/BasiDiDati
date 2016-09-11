package it.uniroma2.db.progetto.dbManagement;

import java.util.ArrayList;

public class Statistics {

	/*----------------------------------------------------MEDIA*/

	public float average(ArrayList <Float> numbers)
	{
		int size = numbers.size();
		int j ;
		float average = 0;
		for (j = 0; j < size; j++)
		{
			average += numbers.get(j);
		}
		return average/size;
		
	}
	
	/*---------------------------------------------DEVIAZIONE STANDARD*/

	/*ricorda che la deviazione media assoluta è uguale a 
	  			
	  			MAD = square*0.6745
	
	*/
	
	public float standardDeviation(ArrayList <Float> numbers)
	{
		float average = average(numbers);
		int size = numbers.size(), j;
		float var = 0;
		float square, power;
		for(j = 0; j < size; j++)
		{
			power =(float) Math.pow((numbers.get(j)-average), 2); 
			var += power;
		}
		square = (float) Math.pow(var/size, 1/2);
		return square;
	}
	
	/*--------------------------------------------------MEDIANA*/
	public float median(ArrayList <Float> numbers)
	{
		
		/*BUBBLESORT*/
		
		int j, size = numbers.size();
		boolean flag = true;
		float dimension;
		while (flag == true)
		{
			flag = false;
			for (j = 0; j < size-1; j++)
			{
				if (numbers.get(j)>numbers.get(j+1))
				{
					dimension = numbers.get(j+1); 
					numbers.set(j+1, numbers.get(j));
					numbers.set(j, dimension);
					
					flag = true;
				}
			}
		}
		
		if (size % 2 == 0)
		{
			return numbers.get(size/2-1);
		}
		else 
		{
			return numbers.get((size+1)/2 -1);
		}
	}
}







