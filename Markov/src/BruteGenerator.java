import java.util.*;



public class BruteGenerator implements TextGenerator{
	protected Random myRandom;
	public static int RANDOM_SEED = 12345;
	TrainingText input;
	int k;
	NGram seed;
	ArrayList<NGram> Ngramlist; 
	
	public BruteGenerator(){
		this.myRandom = new Random(RANDOM_SEED);
	}
	
	public BruteGenerator(int n){
		this.myRandom = new Random(n);
	}
	
	@Override
	public int train(Scanner source, String delimiter, int k){
        input = new TrainingText(source, delimiter, k);
        this.k = k;
        return input.size();
	}
	
	@Override
	public String generateText(int length){
		this.seed = input.get(myRandom.nextInt(input.size()));
		StringBuilder output = new StringBuilder();
		
		//First build the array list full of ngrams
		
		for (int i = 0; i < length; i ++){
			
			this.Ngramlist = new ArrayList<NGram>();
			int position = input.indexOf(seed, 0);
			
			while (position + 1 < input.size()){
				Ngramlist.add(input.get(position + 1));
				position = input.indexOf(seed, position+1);
			}
			this.seed = Ngramlist.get(myRandom.nextInt(Ngramlist.size()));
			
			if ((k-1) > this.seed.getLength()){
				output.append(this.seed.getLast());
				
			}
			
			else {
				output.append(this.seed.getIndex(k-1));
			}
			
		}
		
		return output.toString(); //end generate text 
	}
	
}


