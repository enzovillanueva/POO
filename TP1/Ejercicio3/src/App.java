public class App {
    public static void main(String[] args) throws Exception {
        Producto caja_1 = new CajaChocolate("Chocolate suizo", 100);
        Producto caja_2 = new CajaChocolate("Chocolate Amargo", 50);
        Producto caja_3 = new CajaChocolate("Chocolate con Leche", 25);

        BolsaPromocional bolsaPromocional = new BolsaPromocional();
        bolsaPromocional.addProductos(caja_1);
        bolsaPromocional.addProductos(caja_2);
        bolsaPromocional.addProductos(caja_3);
        System.out.println("El precio de la bolsa total es: " + bolsaPromocional.precio());
    }
}
