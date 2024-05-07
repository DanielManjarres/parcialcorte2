public class Main {
    public static void main(String[] args) {
        TipoCelular.mostrarTipos();
        System.out.println();
        for (TipoCelular tipo : TipoCelular.values()) {
            System.out.println(tipo + ":");
            tipo.caracteristicasEspeciales();
            System.out.println();
        }
    }
}