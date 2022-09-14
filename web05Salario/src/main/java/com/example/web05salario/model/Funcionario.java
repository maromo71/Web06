package com.example.web05salario.model;

public class Funcionario {
    private String nome;
    private String sexo;
    private int idade;
    private double salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void calcularSalario(){
        //Regra - 10% aumento para mulheres
        //      - 11% aumentos para mulheres que
        //      recebem menos que 2000
        if(sexo.equalsIgnoreCase("feminino")){
            if(salario < 2000){
                salario *= 1.11;
            }else{
                salario *=1.10;
            }
        }
    }
}
