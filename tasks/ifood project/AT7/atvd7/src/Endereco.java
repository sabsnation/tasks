public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String numero;

    // Método que simula a busca do CEP (já implementado anteriormente)
    public void buscarPorCep(String cep) {
        // Sua lógica para buscar o endereço via API (ViaCEP, por exemplo)
        // Preencher os campos rua, bairro, cidade e estado
        // Exemplo:
        this.rua = "Rua Exemplo";
        this.bairro = "Bairro Exemplo";
        this.cidade = "Cidade Exemplo";
        this.estado = "Estado Exemplo";
    }

    // Método para definir o número do endereço
    public void definirNumero(String numero) {
        this.numero = numero;
    }

    // Método para exibir o endereço completo
    public void exibirEnderecoCompleto() {
        System.out.println("Rua: " + rua);
        System.out.println("Bairro: " + bairro);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
        System.out.println("Número: " + numero);
    }
}
