import java.util.*;

public class IntervalScheduling {
    
    
    public static void findOptimalRequestSchedule(Request[] requests){
            
        System.out.println("Input Request: \t" + Arrays.toString(requests));
        Arrays.sort(requests);		//Ordena o vetor pelo tempo de finalizacao de cada requisicao
    
        LinkedList<Request> requestsSelected = new LinkedList<Request>();
        requestsSelected.add(requests[0]);		//addiciona aprimeira requisicao
        Request lastRequestAdded = requests[0];
    
        for(int i=1; i<requests.length; i++){
            
            if(requests[i].start >= lastRequestAdded.finish){		//verifica se a requisicao eh compativel
                
                requestsSelected.add(requests[i]);
                lastRequestAdded = requests[i];		//atualiza a posicao da ultima requisicao adicionada
                
            }
            
        }
    
        System.out.println("\nSelected " + requestsSelected.size() + " Requests: ");
            
        for(Request request : requestsSelected){
                
            System.out.println(request);
            
        }
        
    }
        
     public static void main(String[] args) {
            
        Request[] requests = {
            new Request(0, 2, "R1"),
            new Request(0, 3, "R2"),
            new Request(2, 5, "R3"),
            new Request(4, 6, "R4"),
            new Request(7, 9, "R5"),
            new Request(0, 10, "R6"),
            new Request(8, 11, "R7"),
            new Request(13, 14, "R8"),
            new Request(12, 15, "R9")
        };
        
        IntervalScheduling.findOptimalRequestSchedule(requests);
    }    
}
