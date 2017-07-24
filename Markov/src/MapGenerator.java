import java.util.*;

public class MapGenerator implements TextGenerator {
	
	protected Random myRandom;
	public static int RANDOM_SEED = 12345;
	private TrainingText input;
    private int k;
    private NGram seed;
    Map<NGram, ArrayList<NGram>> globalMap; 
    

	public MapGenerator(){
		this.myRandom = new Random(RANDOM_SEED);
	}
	
	public MapGenerator(int n){
		this.myRandom = new Random(n);
	}
	
	public int train(Scanner source, String delimiter, int k){
        this.input = new TrainingText(source, delimiter, k);
        this.k = k;
        this.globalMap = new HashMap<>();
        //this.globalMap = new TreeMap<>();
        globalMap.clear();
        
        for (int i = 0; i < input.size() -1 ; i++){
        	NGram seed = input.get(i);
        	
        	if (globalMap.containsKey(seed)){
        		globalMap.get(seed).add(input.get(i+1));
        	}
        	
        	else {
        		ArrayList<NGram> ngramList = new ArrayList<>();
        		ngramList.add(input.get(i+1));
        		globalMap.put(seed, ngramList);
        	}
        }
        return globalMap.size();
        
        
	}
	public String generateText(int length){
		this.seed = input.get(myRandom.nextInt(input.size()));
		StringBuilder output = new StringBuilder();
		
		for (int i = 0; i < length; i ++){
			ArrayList<NGram> ngramList = globalMap.get(seed);
			this.seed = ngramList.get(myRandom.nextInt(ngramList.size()));
			
			if ((k-1) > this.seed.getLength()){
				output.append(this.seed.getLast());
				
			}
			
			else {
				output.append(this.seed.getIndex(k-1));
			}
		}
		String y = output.toString();
		//System.out.println(y.substring(y.length()-1));
		
		return y;
	}
	
	
}
