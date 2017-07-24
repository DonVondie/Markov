import java.util.Arrays;
import java.util.List;

public class NGram implements Comparable<NGram> {

	private String[] contents;
	private String separator;
	
	public NGram(List<String> source, String sep) {
		separator = sep;
		contents = new String[source.size()];
		contents = Arrays.copyOf(source.toArray(new String[source.size()]), source.size());
	}

	public int compareTo(NGram other) {
		
		String rich = this.toString();
		String rob = other.toString();
		
		
		
		if (rich.length() != rob.length()) {
			
			return rich.length() - rob.length();
		}
		
		else if (other.contents.length != this.contents.length){

			int x = other.contents.length;
			int y = this.contents.length;
			int output = y-x;
			
			
			return (output);
		}
		
		
		else{

		
			for (int i=0; i < other.contents.length; i ++){	
				String x = other.contents[i];
				String y = this.contents[i];
				
				if (x.equals(y)){
					continue;
					
				}
				
				else {
					return y.compareTo(x);
				}
			
		}
		}

		return 0;
		
	}

	public boolean equals(Object o) {
		
		
		if (o == null){
			return false;
		}
		
		if (o.getClass() != this.getClass()){
			return false;
		}
		
		NGram copy = (NGram) o;

		
		if (copy.contents.length != this.contents.length) {
		
			return false;
		}

		else{
			
			for (int i = 0; i < this.contents.length; i ++) {
				String x = copy.contents[i];
				String y = this.contents[i];
				
				if (x.equals(y)){

				}
				
				else {
					return false;
					
				}
		}
		return true;
		}
	}
	/*
public int hashCode() {
	int hash = 0, j = 1;

	for (int i = 0; i < this.contents.length; i++) {

	   hash += this.contents[i].hashCode()*((j+157) % 41);

	   j += 7;

	}

	return hash;
	}
	*/


public int hashCode() {
	return 7;
}


	public String toString() {
		StringBuilder x = new StringBuilder();
		x.append(this.contents[this.contents.length-1]);
		x.append(this.separator);
		
		return x.toString();
		
	}
	
	public int getLength(){
		return contents.length;
	}
	
	public String getLast(){
		StringBuilder x = new StringBuilder();
		x.append(separator);
		x.append(contents[contents.length-1]);
		return x.toString();
	}
	
	public String getIndex(int i){
		StringBuilder x = new StringBuilder();
		x.append(contents[i]);
		x.append(separator);
		return x.toString();
	}
}