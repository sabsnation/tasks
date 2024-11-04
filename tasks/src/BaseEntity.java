public abstract class BaseEntity {
    // Constantes para status
    public static final String STATUS_ATIVO = "ATIVO";
    public static final String STATUS_INATIVO = "INATIVO";

    private Long id;
    private String status;

    // Construtor
    public BaseEntity(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
