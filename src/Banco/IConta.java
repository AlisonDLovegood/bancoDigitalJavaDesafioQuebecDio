package Banco;

//interface é uma classe abstrata com todos os metodos abstratos
//todos os metodos de uma interface sao publicos
public interface IConta {
    void sacar(double valor);

    void depositar(double valor);

//    metodo generico que pode receber tanto uma conta c quanto p
    void transferir(double valor, Conta contaDestino);

    void imprimirExtrato();
}
