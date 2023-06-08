public class Venda {
    private Produto ptd;
    private int qtd;
    
    
    public Venda(Produto ptd, int qtd) {
        this.ptd = ptd;
        this.qtd = qtd;
    }
    public Produto getPtd() {
        return ptd;
    }
    public void setPtd(Produto ptd) {
        this.ptd = ptd;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    @Override
    public String toString() {
        return "Venda [ptd=" + ptd + ", qtd=" + qtd + "]";
    }


}
