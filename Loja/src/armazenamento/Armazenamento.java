package armazenamento;

abstract public class Armazenamento{
    protected static final int MAX = 100;
    protected int estoque = 0;

    //Getters
    public int getMAX(){return MAX;}
    public int getEstoque(){return estoque;}

}

