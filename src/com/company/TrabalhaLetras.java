package com.company;

/**
 * aqui converte strings, vetores e int`s
 * @author djalmacunha
 *
 */

public class TrabalhaLetras {

    /** forca a salvar um vetor char */
    public void setVet(char[] vet) {
        this.vet = vet;
    }

    /** forca a salvar uma String */
    public void setStr(String str) {
        this.str = str;
    }

    /** converte uma String para um vetor char */
    public void converteChar(String txt){
        vet = txt.toCharArray();
    }
    /** converte uma String para um vetor char porem ja retorna */
    public char[] converteCharRapido(String txt){
        char[] oi;
        oi = txt.toCharArray();
        return oi;
    }

    /** converte um vetor char para uma String */
    public void converteString(char[] txt){
        String aux = new String(txt);
        str = aux;
    }

    /** converte um vetor char para uma String */
    public String converteStringRapido(char[] txt){
        String aux = new String(txt);
        return aux;
    }

    /** converte uma String para int */
    public void converteInt(String txt){
        Integer num = Integer.parseInt(txt);
        val = num;
    }

    /** converte um vetor char para int */
    public void converteInt(char[] txt){
        String aux = new String(txt);
        converteInt(aux);
    }

    /** converte um int para uma String */
    public String converteString(int num){
        String resp = "" + num;
        return resp;
    }

    /** retorna o valor inteiro salvo */
    public int getVal() {
        return val;
    }

    /** retorna o vetor char */
    public char[] getVet() {
        return vet;
    }

    /** retorna a String */
    public String getStr() {
        return str;
    }

    /** salva um valor inteiro */
    public void setVal(int val) {
        this.val = val;
    }

    private char[] vet;
    private String str;
    private int val;
}
