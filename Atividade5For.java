public class Carro {

    String cor;
    String placa;
    int porta;
    String motor;
    int pneu;
    double gasolina;

}

public class exercicio2 {

    public static void main(String[] args) {

    Carro car = new Carro();
            car.cor="Azul";
            car.motor="12 Cavalos";
            car.gasolina= 13.8;
            car.pneu=4;
            car.porta=4;
            car.placa="IXB4B28";

        System.out.println(car.cor);
        System.out.println(car.placa);

    }

}
