package produtorconsumidor;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Gdd extends Thread {
    int equipe;
    BlockingQueue<Equipe> fila;
    BlockingQueue<Equipe> fila2;

    public Gdd(int equipe, BlockingQueue<Equipe> fila, BlockingQueue<Equipe> fila2){
        this.equipe = equipe;
        this.fila = fila;
        this.fila2 = fila2;
    }

    @Override
    public void run(){
        Random ran = new Random();
        int num_pedidos = 10;

        for(int i = 0; i < num_pedidos; i++){
            Equipe p = new Equipe();
            try{
                for(int j = 0; j <= num_pedidos; j++){
                    if (fila2.contains(p.equipe)){
                        i++;
                    }else{
                        fila.put(p);
                        fila2.put(p);
                        System.out.println("GDD pronto da equipe: " + p.equipe);
                        Thread.sleep(ran.nextInt(2000));
                    }
                }
            }catch(InterruptedException ex){
                break;
            }
        }
    }
}
