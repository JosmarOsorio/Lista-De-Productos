// ejercicio 3 sumativa 1 .cpp : Programa que permite agregar articulos a una lista, muestrar la disponibilidad de cada articulo e imprimir por pantalla. Por: Josmar Osorio. Para: Programación II-UBA.

import java.util.*; // Importamos la librería Java util para las clases Scanner y ArrayList

public class ListaDeProductos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Creamos el objeto sc para leer la entrada de datos que ingrese el usuario
        ArrayList<Producto> productos = new ArrayList<>(); // Creamos un ArrayList para los productos

        System.out.println("Bienvenido al Gestor de Productos");

        while (true) { //Creamos un bucle while que muestre el menu hasta que se seleccione la opcion 3 y el usuario quiera salir
            System.out.println("\n¿Qué acción desea realizar?");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar lista de productos");
            System.out.println("3. Salir");

            int opcion = sc.nextInt();//Creamos una cariable llamada opcion la cual contendra la opcion a la que desea ingresar el usuario

            switch (opcion) {// Creamos un switch el cual contendra todas las opciones del menu y sus respectivas operaciones
                case 1 -> {
                    System.out.println("\nIngrese el nombre del producto:");//Le solicitamos al usuario que ingrese el nombre de el producto que desea agregar a la lista
                    String nombreProducto = sc.next(); //Leemos el nombre del producto
                    System.out.println("\nIngrese la cantidad de productos disponibles:");//Le solicitamos al usuario que ingrese la cantidad del producto disponible
                    int cantidadProducto = sc.nextInt(); // Leemos la cantidad de productos
                    productos.add(new Producto(nombreProducto, cantidadProducto)); // Añadimos un nuevo producto a la lista
                    System.out.println(nombreProducto + " ha sido agregado a la lista de productos."); //Le indicamos al usuario que el productos ha sido agregado a la lista
                }
                case 2 -> {
                    System.out.println("\nLista de productos:"); //Mostraos la lista de productos
                    if (productos.isEmpty()) {// Si el usuario no ha ingresado productos se muestra que esta vacia
                        System.out.println("No hay productos en la lista.");
                    } else {
                        for (Producto producto : productos) {
                            String estado = (producto.getCantidad() > 0) ? "Disponible" : "No disponible"; // se verifica si hay productos
                                                                                                           //si la cantidad de producto es 0 no esta disponible, si es mayor a 0 si esta disponible
                            System.out.println("- " + producto.getNombre() + " (" + producto.getCantidad() + ") - " + estado);//Se muestran los productos con su disponibilidad
                        }
                    }
                }
                case 3 -> {
                    System.out.println("\n¡Hasta pronto!"); //Creamos un caso para cuando el usuario desee salir del menu mostrando un mensaje de despedida
                    sc.close();
                    System.exit(0);
                }
                default ->
                        System.out.println("\nOpción inválida. Por favor, seleccione una opción válida."); //si se introduce un numero incoherente
                                                                                                           //se muestra un mensaje solicitando que se ingrese un numero valido
            }
        }
    }
}

class Producto { //Creamos una clase producto donde colocaremos todas las epecificaciones que deseamos mostar de un producto, en este caso nombre y cantidad
    public String nombre;
    public int cantidad;

    public Producto(String nombre, int cantidad) { //Creamos un construstructor producto para crear los valores de la clase Producto
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() { //Creamos un metodo llamado getNombre para obtener el valaor de nombre
        return nombre;
    }

    public int getCantidad() { //Creamos un metodo llamado getCantida para obtener el valaor de cantidad
        return cantidad;
    }

}
