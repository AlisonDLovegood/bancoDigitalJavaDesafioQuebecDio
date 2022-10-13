package Banco;

public class Main {
    public static void main(String[] args) {

        Cliente joseph = new Cliente();
//        como o cliente esta encapsulado com getset, e deve ser passado por parametro para a criacao das contas
        joseph.setNome("Joseph");

        Conta cc = new ContaCorrente(joseph);
        Conta cp = new ContaPoupanca(joseph);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

        imprimirTitularesAtivos();
    }

    private static void imprimirTitularesAtivos() {
        System.out.println("-----\tLista de Clientes\t-----");
        System.out.println(Cliente.getNome());
    }
}
