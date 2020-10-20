package produtorconsumidor;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Desenvolvimento extends Thread {
    BlockingQueue<Equipe> fila;
    BlockingQueue<Equipe> fila2;

    int controlador;
    
    public Desenvolvimento(BlockingQueue<Equipe> fila, BlockingQueue<Equipe> fila2){
        this.fila = fila;
        this.fila2 = fila2;
    }
    
    @Override
    public void run(){
        Random ran = new Random();
        int buscar = 10;
        for(int i = 0; i < buscar; i++){
            try{
                Equipe p = fila.take();
                Thread.sleep(ran.nextInt(1000));
                System.out.println("Desenvolvimento pronto da equipe "+ p.equipe);
                if (fila2.contains(p.equipe)){
                    controlador++;
                }else{
                    continue;
                }
                if (controlador == 10){
                    try{
                        System.out.println("A equipe" + p.equipe + "chegou a 10 programas !");
                    }catch (NullPointerException e){
                        break;
                    }

                }

            } catch(InterruptedException ex){
                break;
            }
        }
    }
}
