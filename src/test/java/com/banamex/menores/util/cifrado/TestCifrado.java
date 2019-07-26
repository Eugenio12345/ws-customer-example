package com.banamex.menores.util.cifrado;

import org.junit.Test;

public class TestCifrado {
  //
  // user.name.rest.header=E14F6D601FBB3AEEB15CF01C3CEB3218
  // ### Passowrd ###
  // password.rest.header=4C19489B44D97A42B61B7C8709467102

  @Test
  public void test() {

	System.out.println("Servicio Permanencia");
    String usario = "62D606D1E3BCD897";
    String contrasena = "FBEC8D1538B767D7E2AA00AE7D2DBA08";
    // descifra
    String usuarioDescifrada = StringToHex.getDecodificada(usario);
    String contrasenaDescifrada = StringToHex.getDecodificada(contrasena);
    System.out.println("Usuario: "+usuarioDescifrada);
    System.out.println("Contraseña: " + contrasenaDescifrada);
    
    
	System.out.println("Servicio Menores");
    String usario1 = "71A41A4FCA9C8B56D00D26F2398500BF";
    String contrasena1 = "FBEC8D1538B767D7E2AA00AE7D2DBA08";
    // descifra
    String usuarioDescifrada1 = StringToHex.getDecodificada(usario1);
    String contrasenaDescifrada1 = StringToHex.getDecodificada(contrasena1);
    System.out.println("Usuario1: "+usuarioDescifrada1);
    System.out.println("Contraseña1: " + contrasenaDescifrada1);
    
    //System.out.println("Servicio 13plus");
    //String usario13Plus = "36806A083BB6F3AD47CD09304FC9E809";
    //String contrasena13Plus= "64AD80CF11FF40E54804899812B6F9AC";
    // descifra
    //String usuario13PlusDescifrada = StringToHex.getDecodificada(usario13Plus);
    //String contrasena13PlusDescifrada = StringToHex.getDecodificada(contrasena13Plus);
    //System.out.println("Usuario: "+usuario13PlusDescifrada);
    //System.out.println("Contrase�a: " + contrasena13PlusDescifrada);
    // Procesar1$ - FBEC8D1538B767D798E986E4E04EDE4A
    // p8admin - 62D606D1E3BCD897
    // uaportim
    // In#05vo*my

    // #oF$f0Am4A


  }
}

// ee552bobp
// ProT+%o6czDi
// ProT+%o6czDi

// ee552bob
// UogD5>3T*y8
// UogD5>3T*Y8