public enum TipoCelular {
    BASICO("Pantalla pequeña", "Batería estándar", "Cámara básica", 100.0) {
        @Override
        public void caracteristicasEspeciales() {
            System.out.println("No tiene características especiales.");
        }
    },
    GAMA_MEDIA("Pantalla mediana", "Batería mejorada", "Cámara decente", 300.0) {
        @Override
        public void caracteristicasEspeciales() {
            System.out.println("Resistente al agua y al polvo.");
        }
    },
    GAMA_ALTA("Pantalla grande", "Batería de larga duración", "Cámara profesional", 800.0) {
        @Override
        public void caracteristicasEspeciales() {
            System.out.println("Carga inalámbrica y reconocimiento facial.");
        }
    },
    PREMIUM("Pantalla Premium", "Batería de alta capacidad", "Cámara de gama alta", 1200.0) {
        @Override
        public void caracteristicasEspeciales() {
            System.out.println("Resistente al agua, al polvo y a golpes. Pantalla plegable.");
        }
    };

    private String pantalla;
    private String bateria;
    private String camara;
    private double precio;

    TipoCelular(String pantalla, String bateria, String camara, double precio) {
        this.pantalla = pantalla;
        this.bateria = bateria;
        this.camara = camara;
        this.precio = precio;
    }

    public abstract void caracteristicasEspeciales();

    public static void mostrarTipos() {
        System.out.println("Tipos de celulares disponibles:");
        for (TipoCelular tipo : TipoCelular.values()) {
            System.out.println(tipo + ": " + tipo.pantalla + ", " + tipo.bateria + ", " + tipo.camara + ". Precio: $" + tipo.precio);
        }
    }
}
