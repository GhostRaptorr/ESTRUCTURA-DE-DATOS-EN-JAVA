package TDAEsfera;

public class AppEsfera {
    public static void main(String Args[]){
        Esfera esfera = new Esfera(10);
        System.out.println("Esfera");
        System.out.println("Radio: " + esfera.getRadio());
        System.out.println("Diametro: " + esfera.getDiametro());
        System.out.println("Circuferencia: " + esfera.getCircunferencia());
        System.out.println("Area: " + esfera.getArea());
        System.out.println("Volumen: " + esfera.getVolumen());
    }
}
