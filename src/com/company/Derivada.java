package com.company;

public class Derivada extends TrabalhaLetras{

    /** aqui serve para gerar o multiplicador de uma derivada simples em int */
    public int multiplicadorSimples(String txt) {
        converteChar(txt);
        Integer num;
        try {
            if (!((getVet()[0] >= 'a' && getVet()[0] <= 'z') || (getVet()[0] >= 'A' && getVet()[0] <= 'Z'))) {
                int i = 0;
                while (getVet()[i] >= '0' && getVet()[i] <= '9') {
                    i++;
                }
                char[] aux = new char[i];
                for (int k = 0; k < i; k++) {
                    aux[k] = getVet()[k];
                }
                converteInt(aux);
                if(i == 1 && getVal() == 0){
                    setVal(1);
                }
                num = getVal();
            } else {
                num = 1;
            }
            return num;
        } catch (NumberFormatException e) {
            System.err.println("numero invalido");
            return 0;
        }
    }

    /** aqui tem que vir ja mastigado ou seja a letra, numero e porencia mas gera
     * em String */
    public String simples(int num, String let, int pot){
        String resp;
        if(pot == 1){
            resp = (num * pot) + let;
        }
        else {
            resp = (num * pot) + let + "^" + (pot - 1);
        }
        return resp;
    }

    /** aqui é gerado apenas a potencia de uma derivada simples */
    public int potencia(String txt) {
        converteChar(txt);
        boolean foi = false;
        int c = -7, potrue = -7;
        for (int i = 0; i < txt.length(); i++) {
            if (getVet()[i] == '^') {
                foi = true;
                potrue = i;
                c = 0;
            } else if (foi == true) {
                c++;
            }
        }
        try {
            char[] aux = new char[c];
            for (int i = 0; i < c; i++) {
                aux[i] = getVet()[(potrue + (i + 1))];
                try {
                    converteInt(aux);
                    return getVal();
                } catch (NumberFormatException e) {
                    System.err.println("valor invalido");
                    return 0;
                }
            }
        } catch (NegativeArraySizeException e) {
            return 1;
        }
        return 0;
    }

    /** aqui ele administra o que vai virar o que na String enviada*/
    public String simples(String txt) {
        converteChar(txt);
        int pri, seg;
        pri = multiplicadorSimples(txt);
        seg = potencia(txt);
        return simples(pri, "x", seg);
    }

    /** aqui serve para fazer uma derivada de uma raiz quadrada*/
    public String raiz(String txt){
        converteChar(txt);
        char[] vet = new char[(txt.length() - 1)];
        if(getVet()[0] == '√'){
            for (int i = 0; i < (txt.length() - 1); i++){
                vet[i] = getVet()[i+1];
            }
        }
        converteString(vet);
        String aux = simples(getStr());
        aux = aux + "/2√" + txt;
        return aux;
    }

    private int numero;

}
