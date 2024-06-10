
public class arrayOperation{
private String[] arrayA, arrayB;


arrayOperation (String masA, String masB) {
	arrayA = masA.split(" "); 
	arrayB = masB.split(" "); 
}

// валидация массива 

public boolean validate() 
{
	boolean result = true;
	
	for (String item: arrayA) 
	{
		if 	((item.charAt(0) >= '0' || item.charAt(0) <= '9')&&
				(item.charAt(1) == '1'|| item.charAt(1) == '3'||item.charAt(1) == '5'
				|| item.charAt(1) == '7'|| item.charAt(1) == '9')&&
				(item.charAt(2) >= 'A' || item.charAt(2) <= 'Z')&&
				(item.charAt(3) >= 'A' || item.charAt(3) < 'Z')&& item.length() == 4)
		{
			return false; 
		}


	}
	
	for (String item: arrayB) 
	{
		if 	((item.charAt(0) >= '0' || item.charAt(0) <= '9')&&
				(item.charAt(1) == '1'|| item.charAt(1) == '3'||item.charAt(1) == '5'
				|| item.charAt(1) == '7'|| item.charAt(1) == '9')&&
				(item.charAt(2) >= 'A' || item.charAt(2) <= 'Z')&&
				(item.charAt(3) >= 'A' || item.charAt(3) < 'Z')&& item.length() == 4)
		{
			return false; 
		}


	}
		return result;
	}




		//12YU 68HG 74GV 68VC
		//68HG 12YU 96SD 54UG 


// функция объединения 

public String union()
{
	String result = ""; 
	for (String item: arrayA)
		result = result + item; 
	
	for (String item: arrayB)
		result = result + item; 
	return result; 

}

//функция пересечений 

public String intersection()
{
      
	String result = ""; 
	
	for(int i=0;i<arrayA.length;i++){  
	    for(int j=0;j<arrayB.length;j++){  
	    	 if (arrayA[i].equals(arrayB[j])) {
	                result += arrayA[i] + " ";
	                break; 
            }
        }
    }  
    return result;
}

//дополнение A\B 
public String additionA() {
	
StringBuilder result = new StringBuilder();
for (String item : arrayA) {
    if (indexOf(arrayB, item) == -1) {
        result.append(item).append(" ");
    }
}
return result.toString().trim();
}

//дополнение B\A
public String additionB() {
StringBuilder result = new StringBuilder();
for (String item : arrayB) {
    if (indexOf(arrayA, item) == -1) {
        result.append(item).append(" ");
    }
}
return result.toString().trim();

}


//симметрическая разность 
public String unionAB(){
	StringBuilder result = new StringBuilder();
	for (String item: arrayA)
	    if (indexOf(arrayB, item) == -1) {
	        result.append(item);
	    };
	    
	    for (String item : arrayB) 
	        if (indexOf(arrayA, item) == -1) {
	            result.append(item);
	        }
	return result.toString();
}


private static int indexOf(String[] array, String target) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] != null && array[i].equals(target)) {
            return i;
        }
    }
    return -1;
}
}


