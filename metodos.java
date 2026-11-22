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
public LinkedList<Vehiculo> RegistrarVehiculo(LinkedList<Vehiculo> lcl, Scanner sc, metodos m) {
    boolean continuar = true;

    while (continuar) {

        System.out.println("Tipo de vehiculo 1)Sedan 2)Camioneta SUV");
        int tipo = m.ValidarEntero(sc);
        while (tipo != 1 && tipo != 2) {
            System.out.println("Ingrese 1 o 2");
            tipo = m.ValidarEntero(sc);
        }

        Vehiculo v;
        if (tipo == 1) {
            v = new CarroSedan();
        } else {
            v = new CamionetaSUV();
        }

        System.out.println("Ingrese la placa del vehiculo");
        v.setPlaca(m.SinCaracteresEspeciales(sc));
        System.out.println("Ingrese la marca del vehiculo");
        v.setMarca(m.SoloLetras(sc));
        System.out.println("Ingrese el modelo del vehiculo");
        v.setModelo(Integer.parseInt(m.SoloNumeros(sc)));
        System.out.println("Ingrese el precio diario del vehiculo");
        v.setPrecioDiario(m.ValidarPositivo(sc));

        System.out.println("Estado del vehiculo 1)Disponible 2)Alquilado");
        int estado = m.ValidarEntero(sc);
        while (estado != 1 && estado != 2) {
            System.out.println("Ingrese 1 o 2");
            estado = m.ValidarEntero(sc);
        }
        if (estado == 1) {
            v.setEstado("disponible");
        } else {
            v.setEstado("alquilado");
        }

        if (v instanceof CarroSedan) {
            CarroSedan s = (CarroSedan) v;

            System.out.println("Tipo de combustible 1)Gasolina 2)Diesel 3)Electrico");
            int comb = m.ValidarEntero(sc);
            while (comb != 1 && comb != 2 && comb != 3) {
                System.out.println("Ingrese 1, 2 o 3");
                comb = m.ValidarEntero(sc);
            }
            if (comb == 1) {
                s.setTipoCombustible("gasolina");
            } else if (comb == 2) {
                s.setTipoCombustible("diesel");
            } else {
                s.setTipoCombustible("electrico");
            }

            System.out.println("Transmision 1)Automatica 2)Manual");
            int trans = m.ValidarEntero(sc);
            while (trans != 1 && trans != 2) {
                System.out.println("Ingrese 1 o 2");
                trans = m.ValidarEntero(sc);
            }
            if (trans == 1) {
                s.setTransmision("automatica");
            } else {
                s.setTransmision("manual");
            }

        } else {
            CamionetaSUV c = (CamionetaSUV) v;

            System.out.println("Traccion 1)4x2 2)4x4");
            int trac = m.ValidarEntero(sc);
            while (trac != 1 && trac != 2) {
                System.out.println("Ingrese 1 o 2");
                trac = m.ValidarEntero(sc);
            }
            if (trac == 1) {
                c.setTraccion("4x2");
            } else {
                c.setTraccion("4x4");
            }

            System.out.println("Ingrese la capacidad del maletero en litros");
            c.setCapacidadMaletero(m.ValidarPositivo(sc));
        }

        lcl.add(v);

        System.out.println("Desea agregar otro registro 1)Si 2)No");
        int opt = m.ValidarEntero(sc);

        if (opt == 2) {
            continuar = false;
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
public float ValidarPositivo(Scanner sc) {
    while (!sc.hasNextFloat()) {
        System.out.println("Por favor tenga en cuenta que se le esta pidiendo un dato numerico");
        sc.next();
    }
    float valor = sc.nextFloat();
    sc.nextLine();

    if (valor <= 0) {
        System.out.println("Por favor ingrese un valor positivo");
        return ValidarPositivo(sc);
    }
    return valor;
}

}



