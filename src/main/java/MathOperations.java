
public class MathOperations {
	MathOperationsService mathService;
	
	
       public MathOperations(MathOperationsService mathService) {
		super();
		this.mathService = mathService;
	}

	public MathOperations() {
		// TODO Auto-generated constructor stub
	}

	public int add(int i,int j) {
    	   return mathService.perform(i, j);
       }
       
       public int sub(int i,int j) {
    	   return i-j;
       }
       
       public int multiply(int i,int j) {
    	   return i*j;
       }
       
       public float divide(int i,int j) {
    	   return i/j;
       }
}
