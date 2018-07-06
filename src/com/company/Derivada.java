package com.company;

/**
 * aqui é onde fica a logica
 * @author djalmacunha
 *
 */
public class Derivada extends TrabalhaLetras {

    /**
     * aqui serve para gerar o multiplicador de uma derivada simples em int
     */
    public int multiplicadorSimples(String txt) {
        converteChar(txt);
        int num;
        try {

            /** aqui ele testa se tem alguma letra na 1ª posicao */
            if (!((getVet()[0] >= 'a' && getVet()[0] <= 'z') || (getVet()[0] >= 'A' && getVet()[0] <= 'Z'))) {
                int i = 0;

                /** aqui ele faz um contador para saber quantos numeros aparecem para criar um vetor char */
                while (getVet()[i] >= '0' && getVet()[i] <= '9') {
                    i++;
                }

                /** criacao do vetor e ocupacao com os numeros */
                char[] aux = new char[i];
                for (int k = 0; k < i; k++) {
                    aux[k] = getVet()[k];
                }

                /** aqui ele se sertifica do valor nao comecar com 0 e transforma o vetor em int*/
                converteInt(aux);
                if (i == 1 && getVal() == 0) {
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

    /**
     * aqui tem que vir ja mastigado ou seja a letra, numero e porencia mas gera
     * em String
     */
    public String simples(int num, String let, int pot) {
        String resp;
        /** confere para ver se a potencia é 1 se for ele imprime de forma diferente */
        if (pot == 1) {
            resp = (num * pot) + let;
        } else {
            resp = (num * pot) + let + "^" + (pot - 1);
        }
        return resp;
    }

    /**
     * aqui é gerado apenas a potencia de uma derivada simples
     */
    public int potencia(String txt) {
        converteChar(txt);
        boolean foi = false;

        /** os valores -404 sao para indentificar um possivel erro  */
        int c = -404, potrue = -404;

        /** o for abaixo serve para ver se tem potencia e popula um contador para saber quantos numeros tem apos o ^*/
        for (int i = 0; i < txt.length(); i++) {
            if (getVet()[i] == '^') {
                foi = true;
                potrue = i;
                c = 0;
            } else {
                c++;
            }
        }

        try {
            char[] aux = new char[c];
            /** serve para criar um vetor do tamanho certinho com a quantidade de numeros e ocupa */
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

    /**
     * aqui ele administra o que vai virar o que na String enviada
     */
    public String simples(String txt) {
        converteChar(txt);
        int pri, seg;
        pri = multiplicadorSimples(txt);
        seg = potencia(txt);
        return simples(pri, "x", seg);
    }

    /**
     * aqui ele administra o que vai virar o que na String enviada recebendo vetor char
     */
    public String simples(char[] txt) {
        converteString(txt);
        int pri, seg;
        pri = multiplicadorSimples(getStr());
        seg = potencia(getStr());
        return simples(pri, "x", seg);
    }

    /**
     * aqui serve para fazer uma derivada de uma raiz quadrada
     */
    public String raiz(String txt) {
        converteChar(txt);
        /** cria um vetor com a quantidade de digitos que a string possi removendo a raiz*/
        char[] vet = new char[(txt.length() - 1)];
        if (getVet()[0] == '√') {
            /** popula o vetor*/
            for (int i = 0; i < (txt.length() - 1); i++) {
                vet[i] = getVet()[i + 1];
            }
        }
        /** converte a resposta para string */
        converteString(vet);
        String aux = simples(getStr());
        aux = aux + "/2√" + txt;
        return aux;
    }

    /** para descobrir quanto é uma potencia de uma string e multiplica por outro valor
     * para fazer potencia de potencia*/
    public String potenciaNpotencia(String txt, int n) {
        converteChar(txt);
        int pot = potencia(txt), cont = 0;
        pot = pot * n;
        boolean foi = false;
        /** em baixo ele detecta onde tem ^  e descobre quantos digitos tem apos o sinal*/
        for (int i = 0; i < txt.length(); i++) {
            if (getVet()[i] == '^') {
                foi = true;
            } else if (foi == true) {
                cont++;
            } else {

            }
        }
        /** muda o vetor char onde tem que mudar*/
        char[] aux = new char[cont];
        for (int i = 0; i < cont; i++) {
            aux[i] = getVet()[(i + cont)];

        }
        return converteString(pot);
    }

    public String mudaEmBaixo(String txt){
        converteChar(txt);
        /** um vetor para copiar a string*/
        char[] vet;
        vet = getVet();
        /** um vetor para converter a string criada pela potencia */
        converteChar(potenciaNpotencia(txt,2));
        char[] pot;
        pot = converteCharRapido(potenciaNpotencia(txt,2));
        boolean ok = false;
        int k = 0;
        for (int i = 0; i < txt.length(); i++){
            if (getVet()[i] == '^'){
                ok = true;
            }
            else if(ok == true){
                vet[i] = pot[k];
                k++;
            }
        }
        for (int i = 0; i < txt.length(); i++){
            System.out.print(vet[i]);
        }
        return converteStringRapido(vet);
    }

    /** essa funcao ainda possui falhas porem estamos desenvolvendo(por isso ainda nao
     * esta comentado a logica)*/
    public void umSobre(String txt) {
        converteChar(txt);
        int posicaoDivide = 0, contadorCima = 0, contadorBaixo = 0;
        for (int i = 0; i < txt.length(); i++) {
            if (getVet()[i] == '/') {
                posicaoDivide = i;
            } else if (posicaoDivide == 0) {
                contadorCima++;
            } else if (posicaoDivide == 1) {
                contadorBaixo++;
            }
        }
        char[] cima = new char[contadorCima];
        char[] baixo = new char[contadorBaixo];

        for (int i = 0; i < contadorCima; i++) {
            cima[i] = getVet()[i];
        }

            int defist = contadorCima + 1;
        for (int i = 0; i < contadorBaixo; i++) {
            baixo[i] = getVet()[(i+defist)];
        }

        converteString(baixo);
        converteInt(cima);
        int icima = getVal();
        String baux = simples(baixo);
        String resposta;
        if (icima == 1) {
            resposta = baux + "/" + mudaEmBaixo(getStr());

        } else {
            resposta = "";

        }
        System.out.println(resposta);

    }

    private int numero;

}
