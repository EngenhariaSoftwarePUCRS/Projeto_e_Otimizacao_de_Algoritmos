public class RequestIS implements Comparable<RequestIS>{
    public int start;
	public int finish;
	public String name;

	public RequestIS(int start, int finish, String name){
		this.start=start;
		this.finish=finish;
		this.name=name;
	}

    public int getStartTime(){
		return this.start;
	}

    public int getFinishTime(){
		return this.finish;
	}

	//Compara duas requisicoes pelo tempo de finalizacao
	@Override public int compareTo(RequestIS request) {
		return this.start - request.start;
	}
	
	@Override public String toString(){
		return "[" + name + ": (" + start + ", " + finish + ")]";
	}
}
