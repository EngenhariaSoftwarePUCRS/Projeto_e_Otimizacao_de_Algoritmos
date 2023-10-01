public class Request implements Comparable<Request> {
    
    public int start;
	public int finish;
	public String name;

	public Request(int start, int finish, String name){
		this.start=start;
		this.finish=finish;
		this.name=name;
	}

	//Compara duas requisicoes pelo tempo de finalizacao
	@Override public int compareTo(Request request) {
		return this.finish - request.finish;
	}
	
	@Override public String toString(){
		return "[" + name + ": (" + start + ", " + finish + ")]";
	}

}
