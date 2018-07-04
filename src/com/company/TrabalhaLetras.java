package com.company;

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

    /** converte um vetor char para uma String */
    public void converteString(char[] txt){
        String aux = new String(txt);
        str = aux;
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
