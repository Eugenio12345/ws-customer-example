package com.banamex.menores.util.cifrado;

import java.util.Random;

/**
 * Insert the type's description here. Creation date: (28/04/2008)
 * 
 * @author: DMDULTRA
 */
public class StringToHex {
  /**
   * StringToHex constructor comment.
   */
  public StringToHex() {
    super();
  }

  /**
   * Insert the method's description here. Creation date: (19/11/2001 02:18:27
   * p.m.)
   * 
   * @return java.lang.String
   * @param datos
   *          byte[]
   */
  public static String convierte(byte[] datos) {
    // char[]
    // carHex={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    String res = "";
    for (int i = 0; i < datos.length; i++) {
      byte unbyte = datos[i];
      int b = unbyte + 0;
      if (b < 0)
        b += 256;
      res += Integer.toHexString(b + 256);
      // res+=""+carHex[b/16]+carHex[b % 16];
    }
    return res;
  }

  /**
   * Insert the method's description here. Creation date: (19/11/2001 02:18:27
   * p.m.)
   * 
   * @return java.lang.String
   * @param datos
   *          byte[]
   */
  public static byte[] desconvierte(String datos) {
    if ((datos.length() % 2) != 0) {
      datos = "0" + datos;
    }
    byte[] res = new byte[datos.length() / 2];
    for (int i = 0; i < datos.length(); i += 2) {
      res[i / 2] = (byte) Integer.parseInt(datos.substring(i, i + 2), 16);
    }

    // res = new BigInteger(datos,16).toByteArray();
    return res;
  }

  public static String getDecodificada(String sCadOri) {

    String sCadRes = new String();
    Random r = new Random(1234212679850L);
    byte[] bytDumi = new byte[24];
    //byte[] bytDat = null;
    byte[] bytRes = null;

    int n = r.nextInt(100);
    for (int i = 0; i < n; i++) {
      //long j = 
      r.nextLong();
    }

    r.nextBytes(bytDumi);
    byte[] bytDesconvierte = StringToHex.desconvierte(sCadOri);
    sCadOri = new String(bytDesconvierte);

    /*
     * for(int xconta = 0; xconta < bytDumi.length; xconta++) { bytDumi[xconta]
     * = 9; }
     */

    // bytDat = sCadOri.getBytes();
    CipherAdv cip = new CipherAdv(bytDumi);

    bytRes = cip.decryptAll(bytDesconvierte);
    sCadRes = (bytRes != null) ? new String(bytRes) : "";
    return sCadRes;
  }
 
}
