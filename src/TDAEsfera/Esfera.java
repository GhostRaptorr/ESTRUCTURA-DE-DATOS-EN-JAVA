package TDAEsfera;

//Esfera
/*Circuferencia = nDiametro
* Volumen= (4nr^3)/3
* Diametro= 2r
* Radio= C/2n
* Area= 4nr^2*/

public class Esfera {
    private Double radio;

    //Constructor
    public Esfera(double radioInicial){
        if (radioInicial>0){
            this.radio = radioInicial;
        } else {
            this.radio = 0.0;
        }
    }

    //Methods

    //GetRadio
    public double getRadio(){
        return this.radio;
    }

    public double getDiametro(){
        return (2*radio);
    }

    public double getCircunferencia(){
        return (Math.PI * getDiametro());
    }

    //Area= 4nr^2*
    public double getArea(){
        return (4*Math.PI*radio*radio);
    }

    // Volumen= (4nr^3)/3
    public double getVolumen(){
        return (4*Math.PI*Math.pow(radio, 3))/3;
    }


}
