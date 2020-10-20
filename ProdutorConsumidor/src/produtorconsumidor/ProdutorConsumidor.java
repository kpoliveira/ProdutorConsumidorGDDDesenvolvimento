package produtorconsumidor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdutorConsumidor {

    public static void main(String[] args) {
        BlockingQueue<Equipe> equipes = new ArrayBlockingQueue<Equipe>(10);
        BlockingQueue<Equipe> equipes2 = new ArrayBlockingQueue<Equipe>(10);

        int num_mesas = 10; //número de equipes
        Gdd vetor[] = new Gdd[num_mesas];

        for(int i = 0; i < num_mesas; i++){
            Gdd mi = new Gdd(i, equipes, equipes2);
            vetor[i] = mi;
        }

        for(int i = 0; i < num_mesas; i++){
            vetor[i].start();
        }
        
        int num_cozinha = 10;
        Desenvolvimento cvet[] = new Desenvolvimento[num_cozinha];

        for(int i = 0; i < num_cozinha; i++){
            Desenvolvimento ci = new Desenvolvimento(equipes, equipes2);
            cvet[i] = ci;
        }

        for(int i = 0; i < num_cozinha; i++){
            cvet[i].start();
        }
    }
}
