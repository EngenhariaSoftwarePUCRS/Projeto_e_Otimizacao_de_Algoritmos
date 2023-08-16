import java.util.*;

public class IntervalPartitioning {
	public static void findOptimalPartitioning(RequestIS[] requests){
		Arrays.sort(requests);		//Ordena o vetor pelo tempo de finalizacao de cada requisicao

		ArrayList<Resource> allResources = new ArrayList<Resource>();	//lista com todos os recursos e suas respectivas requisicoes
		PriorityQueue<Resource> resourcesQueue = new PriorityQueue<Resource>();		//fila de prioridade, ordenada pelo tempo de finalizacao da ultima requisicao
		String outputMessage = "";		//apresentacao do conjunt otimo de alocadao

		int d = 0;	//contador do numero de recursos necessarios

		Resource firstResource = new Resource(requests[0], ++d);		//Cria o primeiro recurso e aloca a primeira requisicao nele
		resourcesQueue.add(firstResource);	//adiciona o recurso na fila de prioridade
		allResources.add(firstResource);	//adiciona o recurso na lista com todos os recursos
		outputMessage += requests[0] + "\tadded in resource " + firstResource.getId();

		for (RequestIS request : requests) {		//itera sobre todas as requisicoes
			Resource currentResource = resourcesQueue.peek();		//pega o recurso da fila de recursos cuja requisicao acaba primeiro

			if (request.getStartTime() >= currentResource.getLastFinished()){		//verifica se a requisicao eh compativel com as demais requisicoes do recurso atual
				currentResource.addRequest(request);		//adiciona a requisicao no recurso e atualiza o tempo de execucao da ultima requisicao do recurso.
				resourcesQueue.remove(); //remove o topo da fila que é o recurso atual.
				resourcesQueue.add(currentResource);	//adiciona o recurso atual novamente para forcar a fila a reordenar pela prioridade.
				outputMessage += "\n" + request + "\tadded in room " + currentResource.getId();
			} else {
				Resource newResource = new Resource(request, ++d);	//cria um novo recurso
				resourcesQueue.add(newResource);	//adiciona na fila
				allResources.add(newResource);		//adicina na lista de todos os recuroso
				outputMessage += "\n" + request + "\tadded in room " + newResource.getId();
			}
		}
		
		outputMessage+="\n\nContents of Resources";
		for (Resource resource : allResources) {
			outputMessage += "\nResource " + resource.getId() + ": " + resource.getRequests();
		}
		System.out.println(outputMessage);
	}

	public static void main(String[] args) {        
		RequestIS[] requests = {
			new RequestIS(1, 2, "a"),
			new RequestIS(1, 4, "b"),
			new RequestIS(1, 2, "c"),
			new RequestIS(3, 4, "d"),
			new RequestIS(3, 6, "e"),
			new RequestIS(5, 8, "f"),
			new RequestIS(5, 8, "g"),
			new RequestIS(7, 10, "h"),
			new RequestIS(9, 10, "i"),
			new RequestIS(9, 10, "j"),
		};

		IntervalPartitioning.findOptimalPartitioning(requests);
	}
}
