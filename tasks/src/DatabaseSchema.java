import java.math.BigDecimal;
import java.util.Date;

public class DatabaseSchema {
    public static class Pedido {
        Integer id;
        Date data;
        Integer idResta;
        BigDecimal valor;
        BigDecimal taxaEntrega;
        Integer idPromo;
        Integer idStatusEntrega;
        Integer idFormaPag;
        String obs;
        BigDecimal troco;
        Integer idEnde;
    }


    public static class PedidoProduto {
        Integer idPedido;
        Integer idProduto;
        Integer quantidade;
    }


    public static class PedidoProdutoAcomp {
        Integer idPedidoProduto;
        Integer idAcomp;
    }


    public static class Restaurante {
        Integer id;
        String nome;
        String endereco;
        String telefone;
        Integer categoria;
        String horaFuncionamento;
        Boolean isRetirada;
    }


    public static class Endereco {
        Integer id;
        String rua;
        String numero;
        String bairro;
        String cidade;
        String estado;
        String cep;
        Integer idUsuario;
    }

    public static class Promocao {
        Integer id;
        String nome;
        String codigo;
        BigDecimal valor;
        Date validade;
    }


    public static class Avaliacao {
        Integer id;
        Integer nota;
        Integer pedido;
        Date registroData;
    }

    public static class ProdutoAcomp {
        Integer idProduto;
        Integer idAcomp;
    }


    public static class StatusEntrega {
        Integer id;
        String nome;
    }


    public static class Acompanhamento {
        Integer id;
        String nome;
        String descricao;
        BigDecimal valor;
    }


    public static class Categoria {
        Integer id;
        String tipo;
        String nome;
        String descricao;
    }


    public static class FormaPagamento {
        Integer id;
        String tipoDePagamento;
    }


    public static class HistoricoEntrega {
        Integer id;
        Integer idStatusEntrega;
        Integer idPedido;
        Date dataHora;
    }


    public static class HistoricoPagamento {
        Integer id;
        Date data;
        Integer idForma;
        BigDecimal valor;
    }


    public static class Produto {
        Integer idProduto;
        String nome;
        String descricao;
        BigDecimal preco;
        Integer categoriaId;
        Integer restauranteId;
    }


    public static class RestaurantePagamento {
        Integer idRes;
        Integer idPaga;
    }
}