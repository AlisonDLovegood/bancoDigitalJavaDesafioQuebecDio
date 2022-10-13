package Banco;

//uma classe abstrata nao pode ser instanciada, isso garante que nao possa ser dado um new a menos seus filhos
public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 001;
    //  constante é uma classe statica == ter uma relaçao com a classe de conta corrente e nao com a instancia
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

//    passando o cliente como parametro eu garanto indiretamente a lista de clientes dentro da conta
    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        if (valor>0){
            saldo -= valor;
            System.out.println("Saque de R$"+valor+" efetivado com sucesso!");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor>0){
            saldo += valor;
            System.out.println("Deposito de R$"+valor+" efetivado com sucesso!");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
//        a instancia q está chamando, this vai sacar
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
