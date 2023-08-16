import java.util.*;

public class Resource implements Comparable<Resource> {
    private LinkedList<RequestIS> requests = new LinkedList<RequestIS>();	//lista de requisicoes atendidas pelo recurso
	private int lastFinished;	//tempo em que a ultima requesicao alocada na sala termina
	private int id;				//identificador do recurso

	public Resource(RequestIS RequestIS, int id){
		addRequest(RequestIS);		//adiciona uma nova requisicao no recurso
		this.id = id;
	}

	public int getLastFinished(){
		return lastFinished;
	}

	public int getId(){
		return id;
	}

	public LinkedList<RequestIS> getRequests(){	//return list of lectures in the room
		return requests;
	}

	public RequestIS getLastRequest(){
		return requests.getLast();
	}

	//Adiciona uma nova requisicao ao recurso e adiciona o tempo de finalizacao da ultima requisao alocada no recurso
	public void addRequest(RequestIS request){
		requests.add(request);
		lastFinished = (request.getFinishTime());
	}

	@Override
	//Compara os recursos por tempo de finalizacao da ultima requisicao alocada.
	public int compareTo(Resource otherResource) {
		return this.getLastFinished() - otherResource.getLastFinished();
	}
}
