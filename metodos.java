import java.util.LinkedList;
import java.util.Scanner;

public class metodos {
    
    public LinkedList<Cliente> RegistrarCliente (LinkedList<Cliente> lcl,Scanner sc, metodos m){
        boolean continuar = true;
    
        while (continuar) {
            Cliente cl = new Cliente();

            System.out.println("Ingrese la cedula del cliente");
            cl.setCedula(m.SinCaracteresEspeciales(sc));
            System.out.println("Ingrese el nombre del cliente");
            cl.setNombre(m.SoloLetras(sc));
            System.out.println("Ingrese el apellido del cliente");
            cl.setApellido(m.SoloLetras(sc));
            System.out.println("Ingrese el telefono del cliente");
            cl.setTelefono(m.SoloNumeros(sc));
            System.out.println("Ingrese la direccion del cliente");
            cl.setDireccion(sc.nextLine());
            System.out.println("Ingrese la licencia de conduccion del cliente");
            cl.setLicenciaConduccion(sc.next());
            lcl.add(cl);

            System.out.println("Desea agregar otro registro 1)Si 2)No");
            int opt = m.ValidarEntero(sc);
            sc.nextLine();
            
            if (opt == 2) {
                continuar=false;
            }

        }


        return lcl;
    }

     public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor tenga en cuenta que se le esta pidiendo un dato numerico");
            sc.next();
        }
        return sc.nextInt();
    }

    public String SinCaracteresEspeciales(Scanner sc) {
    String texto = sc.nextLine(); 

    if (texto.trim().isEmpty()) { 
        System.out.println("El campo no puede estar vacio, intente de nuevo:");
        return SinCaracteresEspeciales(sc); 
    }

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);
        if (!Character.isLetterOrDigit(c)) {
            System.out.println("No se permiten caracteres especiales, intente de nuevo:");
            return SinCaracteresEspeciales(sc);
        }
    }

    return texto;
}

public String SoloLetras(Scanner sc) {
    String texto = sc.nextLine();

    if (texto.trim().isEmpty()) {
        System.out.println("El campo no puede estar vacio, intente de nuevo:");
        return SoloLetras(sc);
    }

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);
        if (!Character.isLetter(c) && c != ' ') {
            System.out.println("Solo se permiten letras (sin numeros ni caracteres especiales), intente de nuevo:");
            return SoloLetras(sc);
        }
    }

    return texto;
}

public String SoloNumeros(Scanner sc) {
    String texto = sc.nextLine();

    if (texto.trim().isEmpty()) {
        System.out.println("El campo no puede estar vacio, intente de nuevo:");
        return SoloNumeros(sc);
    }

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);
        if (!Character.isDigit(c)) {
            System.out.println("Solo se permiten numeros, intente de nuevo:");
            return SoloNumeros(sc);
        }
    }

    return texto;
}


}
