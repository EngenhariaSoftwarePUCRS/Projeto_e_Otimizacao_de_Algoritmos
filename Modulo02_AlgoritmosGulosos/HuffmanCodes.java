import java.util.PriorityQueue;
 
class HuffmanCodes {

    // Nodo basico da Huffman - tree.
    private static final class HuffmanNode implements Comparable<HuffmanNode>{
    
        int data;
        char c;
    
        HuffmanNode left;
        HuffmanNode right;

        //Compara as letras (nodos) pela frequencia.
	    @Override public int compareTo(HuffmanNode y) {
    
            return this.data - y.data;
        }
    }
    

    // Funcao recursiva para imprimir o codigo Huffman gerado transversando a arvore
    public static void printCode(HuffmanNode root, String s)
    {
 
        if (root.left == null && root.right == null
            && Character.isLetter(root.c)) {
 
            // imprime o caracter na raiz
            System.out.println(root.c + ":" + s);
 
            return;
        }
 
        // se descer a esquerda adiciona "0" ao codigo.
        // se descer a direita adiciona "1" ao codigo.
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
 
    public static void main(String[] args)
    {
 
        // numero de carateres
        int n = 6;
        char[] S = { 'a', 'b', 'c', 'd', 'e', 'f' }; //dicinario de letras S
        int[] fx = { 45, 13, 12, 16, 9, 5 }; //frequencia de cada letra fx
 
        // Fila de prioridade por frequencia mínima Q
        PriorityQueue<HuffmanNode> Q = new PriorityQueue<HuffmanNode> (n);
 
        for (int i = 0; i < n; i++) {
      
            //cria um node Huffman
            HuffmanNode hn = new HuffmanNode();
 
            hn.c = S[i];
            hn.data = fx[i];
 
            hn.left = null;
            hn.right = null;
 
            // adiciona nodo na fila
            Q.add(hn);
        }
 
        //cria o nodo raiz
        HuffmanNode root = null;
 
        // Removemos as duas letras com a menor frequencia por iteracao
        while (Q.size() > 1) {
 
            // primeira letra com menor frequencia
            HuffmanNode y = Q.poll();
 
            // segunda letra com menor frequencia
            HuffmanNode z = Q.poll();
 
            // aloca um novo nodo w
            HuffmanNode w = new HuffmanNode();
 
            // A frequencia do novo nodo w eh fw = fy + fz
            w.data = y.data + z.data;
            w.c = '-';
 
            // atualiza os filhos de w.
            w.left = y;
            w.right = z;
 
            // w vira o nodo raiz. Lembre-se na última vez que a iteracao rodar vc coloca o resultado no topo da arvore.
            root = w;
 
            // add this node to the priority-queue.
            Q.add(w);
        }
 
        // print the codes by traversing the tree
        printCode(root, "");
    }
}
 
