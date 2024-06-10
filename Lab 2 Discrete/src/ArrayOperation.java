import java.util.ArrayList;
import java.util.List;

public class ArrayOperation {
    private List<List<Integer>> arrayA;

    public ArrayOperation(String input) {
        arrayA = new ArrayList<>();

        String[] lines = input.split("\n");

        for (String line : lines) {
            List<Integer> row = new ArrayList<>();
            String[] values = line.trim().split("\\s+");
            for (String value : values) {
                row.add(Integer.parseInt(value));
            }
            arrayA.add(row);
        }
    }

    public boolean validate() {
        int n = arrayA.size();
        for (List<Integer> row : arrayA) {
			for (Integer value : row) {
                if (value != 0 && value != 1) {
                    return false; // Если встречается значение, отличное от 0 или 1, возвращаем false
                    
                }
            }
        }
        return true;
    }
    
    
    public boolean isReflexive() {
        int n = arrayA.size();
        for (int i = 0; i < n; i++) {
            if (arrayA.get(i).get(i) != 1) {
                return false; 
            }
        }
        return true;
    }

    public boolean isSymmetric() {
    	  int n = arrayA.size();
    	    for (int i = 0; i < n; i++) {
    	        for (int j = i + 1; j < n; j++) {
    	            if (arrayA.get(i).get(j) != arrayA.get(j).get(i)) {
    	                return false;
    	            }
    	        }
    	    }
    	    return true;
    	}

    public boolean isAntisymmetric() {
        int n = arrayA.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && arrayA.get(i).get(j) == 1 && arrayA.get(j).get(i) == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isTransitive() {
    	 int n = arrayA.size();
    	    for (int i = 0; i < n; i++) {
    	        for (int j = 0; j < n; j++) {
    	            if (arrayA.get(i).get(j) == 1) {
    	                for (int k = 0; k < n; k++) {
    	                    if (arrayA.get(j).get(k) == 1 && arrayA.get(i).get(k) != 1) {
    	                        return false; 
    	                    }
    	                }
    	            }
    	        }
    	    }
    	    return true;
    	}
}
