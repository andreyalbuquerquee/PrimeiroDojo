public class Produto {
    

    
    @Override
    public String toString() {
        return "Produto [código=" + codigo + ", nome=" + nome + ", preço=" + price + ", estoque=" + qtd + "]";
    }
    private String codigo;
    private String nome;
    private double price;
    private int qtd = 0;
    
    
    public Produto(String codigo, String nome, double price, int qtd) {
        this.codigo = codigo;
        this.nome = nome;
        this.price = price;
        this.qtd = qtd;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }


    

}
