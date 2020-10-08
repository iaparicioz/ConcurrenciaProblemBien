

public class ThreadWithdrawCash extends Thread {

    @Override
    public void run() {
        //super.run(); --> llama a la clase padre
        try{
            System.out.println("Simulamos la lectura del saldo del cliente (conexión on-line)");
            int cashOriginal = FakeDB.cash;
            System.out.println("El saldo del cliente es: "+cashOriginal);
            long sleepingTime = (long) (Math.random()*1000); //transaccion
            sleep(sleepingTime);
            int cash = cashOriginal - 10;

            sleep(sleepingTime);
            System.out.println("Simulamos la escritura del saldo del cliente, ha sacado " + 10 + "monedas");
            System.out.println("Nuestro hilo se piensa que en la FakeBD habia: " +cashOriginal +" pero realmente hay " + FakeDB.cash );

            FakeDB.cash= cash;
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("El resultado generado en la base de datos es " + FakeDB.cash);
    }
}
