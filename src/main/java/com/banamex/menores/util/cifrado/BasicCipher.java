package com.banamex.menores.util.cifrado;

/**
 * Insert the type's description here. Creation date: (28/04/2008)
 *
 * @author: DMDULTRA
 */
public class BasicCipher {

  private boolean iniEnc = false;
  private boolean iniDec = false;
  private int[] enc = new int[32];
  private int[] dec = new int[32];
  // Arreglo de cuantos unos estan prendidos en arreglos de 4 bits.
  private static byte[] unos = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3,
    4};
  private static int[][] SP = {
    {0x01010400, 0x00000000, 0x00010000, 0x01010404, 0x01010004,
      0x00010404, 0x00000004, 0x00010000, 0x00000400, 0x01010400,
      0x01010404, 0x00000400, 0x01000404, 0x01010004, 0x01000000,
      0x00000004, 0x00000404, 0x01000400, 0x01000400, 0x00010400,
      0x00010400, 0x01010000, 0x01010000, 0x01000404, 0x00010004,
      0x01000004, 0x01000004, 0x00010004, 0x00000000, 0x00000404,
      0x00010404, 0x01000000, 0x00010000, 0x01010404, 0x00000004,
      0x01010000, 0x01010400, 0x01000000, 0x01000000, 0x00000400,
      0x01010004, 0x00010000, 0x00010400, 0x01000004, 0x00000400,
      0x00000004, 0x01000404, 0x00010404, 0x01010404, 0x00010004,
      0x01010000, 0x01000404, 0x01000004, 0x00000404, 0x00010404,
      0x01010400, 0x00000404, 0x01000400, 0x01000400, 0x00000000,
      0x00010004, 0x00010400, 0x00000000, 0x01010004},
    {0x80108020, 0x80008000, 0x00008000, 0x00108020, 0x00100000,
      0x00000020, 0x80100020, 0x80008020, 0x80000020, 0x80108020,
      0x80108000, 0x80000000, 0x80008000, 0x00100000, 0x00000020,
      0x80100020, 0x00108000, 0x00100020, 0x80008020, 0x00000000,
      0x80000000, 0x00008000, 0x00108020, 0x80100000, 0x00100020,
      0x80000020, 0x00000000, 0x00108000, 0x00008020, 0x80108000,
      0x80100000, 0x00008020, 0x00000000, 0x00108020, 0x80100020,
      0x00100000, 0x80008020, 0x80100000, 0x80108000, 0x00008000,
      0x80100000, 0x80008000, 0x00000020, 0x80108020, 0x00108020,
      0x00000020, 0x00008000, 0x80000000, 0x00008020, 0x80108000,
      0x00100000, 0x80000020, 0x00100020, 0x80008020, 0x80000020,
      0x00100020, 0x00108000, 0x00000000, 0x80008000, 0x00008020,
      0x80000000, 0x80100020, 0x80108020, 0x00108000},
    {0x00000208, 0x08020200, 0x00000000, 0x08020008, 0x08000200,
      0x00000000, 0x00020208, 0x08000200, 0x00020008, 0x08000008,
      0x08000008, 0x00020000, 0x08020208, 0x00020008, 0x08020000,
      0x00000208, 0x08000000, 0x00000008, 0x08020200, 0x00000200,
      0x00020200, 0x08020000, 0x08020008, 0x00020208, 0x08000208,
      0x00020200, 0x00020000, 0x08000208, 0x00000008, 0x08020208,
      0x00000200, 0x08000000, 0x08020200, 0x08000000, 0x00020008,
      0x00000208, 0x00020000, 0x08020200, 0x08000200, 0x00000000,
      0x00000200, 0x00020008, 0x08020208, 0x08000200, 0x08000008,
      0x00000200, 0x00000000, 0x08020008, 0x08000208, 0x00020000,
      0x08000000, 0x08020208, 0x00000008, 0x00020208, 0x00020200,
      0x08000008, 0x08020000, 0x08000208, 0x00000208, 0x08020000,
      0x00020208, 0x00000008, 0x08020008, 0x00020200},
    {0x00802001, 0x00002081, 0x00002081, 0x00000080, 0x00802080,
      0x00800081, 0x00800001, 0x00002001, 0x00000000, 0x00802000,
      0x00802000, 0x00802081, 0x00000081, 0x00000000, 0x00800080,
      0x00800001, 0x00000001, 0x00002000, 0x00800000, 0x00802001,
      0x00000080, 0x00800000, 0x00002001, 0x00002080, 0x00800081,
      0x00000001, 0x00002080, 0x00800080, 0x00002000, 0x00802080,
      0x00802081, 0x00000081, 0x00800080, 0x00800001, 0x00802000,
      0x00802081, 0x00000081, 0x00000000, 0x00000000, 0x00802000,
      0x00002080, 0x00800080, 0x00800081, 0x00000001, 0x00802001,
      0x00002081, 0x00002081, 0x00000080, 0x00802081, 0x00000081,
      0x00000001, 0x00002000, 0x00800001, 0x00002001, 0x00802080,
      0x00800081, 0x00002001, 0x00002080, 0x00800000, 0x00802001,
      0x00000080, 0x00800000, 0x00002000, 0x00802080},
    {0x00000100, 0x02080100, 0x02080000, 0x42000100, 0x00080000,
      0x00000100, 0x40000000, 0x02080000, 0x40080100, 0x00080000,
      0x02000100, 0x40080100, 0x42000100, 0x42080000, 0x00080100,
      0x40000000, 0x02000000, 0x40080000, 0x40080000, 0x00000000,
      0x40000100, 0x42080100, 0x42080100, 0x02000100, 0x42080000,
      0x40000100, 0x00000000, 0x42000000, 0x02080100, 0x02000000,
      0x42000000, 0x00080100, 0x00080000, 0x42000100, 0x00000100,
      0x02000000, 0x40000000, 0x02080000, 0x42000100, 0x40080100,
      0x02000100, 0x40000000, 0x42080000, 0x02080100, 0x40080100,
      0x00000100, 0x02000000, 0x42080000, 0x42080100, 0x00080100,
      0x42000000, 0x42080100, 0x02080000, 0x00000000, 0x40080000,
      0x42000000, 0x00080100, 0x02000100, 0x40000100, 0x00080000,
      0x00000000, 0x40080000, 0x02080100, 0x40000100},
    {0x20000010, 0x20400000, 0x00004000, 0x20404010, 0x20400000,
      0x00000010, 0x20404010, 0x00400000, 0x20004000, 0x00404010,
      0x00400000, 0x20000010, 0x00400010, 0x20004000, 0x20000000,
      0x00004010, 0x00000000, 0x00400010, 0x20004010, 0x00004000,
      0x00404000, 0x20004010, 0x00000010, 0x20400010, 0x20400010,
      0x00000000, 0x00404010, 0x20404000, 0x00004010, 0x00404000,
      0x20404000, 0x20000000, 0x20004000, 0x00000010, 0x20400010,
      0x00404000, 0x20404010, 0x00400000, 0x00004010, 0x20000010,
      0x00400000, 0x20004000, 0x20000000, 0x00004010, 0x20000010,
      0x20404010, 0x00404000, 0x20400000, 0x00404010, 0x20404000,
      0x00000000, 0x20400010, 0x00000010, 0x00004000, 0x20400000,
      0x00404010, 0x00004000, 0x00400010, 0x20004010, 0x00000000,
      0x20404000, 0x20000000, 0x00400010, 0x20004010},
    {0x00200000, 0x04200002, 0x04000802, 0x00000000, 0x00000800,
      0x04000802, 0x00200802, 0x04200800, 0x04200802, 0x00200000,
      0x00000000, 0x04000002, 0x00000002, 0x04000000, 0x04200002,
      0x00000802, 0x04000800, 0x00200802, 0x00200002, 0x04000800,
      0x04000002, 0x04200000, 0x04200800, 0x00200002, 0x04200000,
      0x00000800, 0x00000802, 0x04200802, 0x00200800, 0x00000002,
      0x04000000, 0x00200800, 0x04000000, 0x00200800, 0x00200000,
      0x04000802, 0x04000802, 0x04200002, 0x04200002, 0x00000002,
      0x00200002, 0x04000000, 0x04000800, 0x00200000, 0x04200800,
      0x00000802, 0x00200802, 0x04200800, 0x00000802, 0x04000002,
      0x04200802, 0x04200000, 0x00200800, 0x00000000, 0x00000002,
      0x04200802, 0x00000000, 0x00200802, 0x04200000, 0x00000800,
      0x04000002, 0x04000800, 0x00000800, 0x00200002},
    {0x10001040, 0x00001000, 0x00040000, 0x10041040, 0x10000000,
      0x10001040, 0x00000040, 0x10000000, 0x00040040, 0x10040000,
      0x10041040, 0x00041000, 0x10041000, 0x00041040, 0x00001000,
      0x00000040, 0x10040000, 0x10000040, 0x10001000, 0x00001040,
      0x00041000, 0x00040040, 0x10040040, 0x10041000, 0x00001040,
      0x00000000, 0x00000000, 0x10040040, 0x10000040, 0x10001000,
      0x00041040, 0x00040000, 0x00041040, 0x00040000, 0x10041000,
      0x00001000, 0x00000040, 0x10040040, 0x00001000, 0x00041040,
      0x10001000, 0x00000040, 0x10000040, 0x10040000, 0x10040040,
      0x10000000, 0x00040000, 0x10001040, 0x00000000, 0x10041040,
      0x00040040, 0x10000040, 0x10040000, 0x10001000, 0x10001040,
      0x00000000, 0x10041040, 0x00041000, 0x00041000, 0x00001040,
      0x00001040, 0x00040040, 0x10000000, 0x10041000}};

  /**
   * JonDesCipher constructor comment.
   */
  public BasicCipher() {
    super();
  }

  /**
   * Insert the method's description here. Creation date: (10/02/2003 12:43:15
   * p.m.)
   *
   * @param key byte[]
   */
  public BasicCipher(byte[] key) {
    super();
    setKey(key, true);
    setKey(key, false);
  }

  /**
   * Insert the method's description here. Creation date: (11/02/2003 02:35:29
   * a.m.)
   *
   * @return int[]
   * @param entrada byte[]
   */
  public int[] convBytesToInts(byte[] entrada) {
    int[] res = new int[2];
    for (int i = 0; i < res.length; i++) {
      res[i] = ((entrada[i * 4] & 0xff) << 24)
        | ((entrada[i * 4 + 1] & 0xff) << 16)
        | ((entrada[i * 4 + 2] & 0xff) << 8)
        | ((entrada[i * 4 + 3] & 0xff));
    }
    return res;
  }

  /**
   * Insert the method's description here. Creation date: (11/02/2003 02:36:01
   * a.m.)
   *
   * @return byte[]
   * @param entrada int[]
   */
  public byte[] convIntsToBytes(int[] entrada) {
    byte[] salida = new byte[8];
    for (int i = 0; i < 2; i++) {
      salida[i * 4] = (byte) ((entrada[i] >>> 24) & 0xff);
      salida[i * 4 + 1] = (byte) ((entrada[i] >>> 16) & 0xff);
      salida[i * 4 + 2] = (byte) ((entrada[i] >>> 8) & 0xff);
      salida[i * 4 + 3] = (byte) ((entrada[i]) & 0xff);
    }
    return salida;
  }

  /**
   * Insert the method's description here. Creation date: (10/02/2003 12:44:13
   * p.m.)
   *
   * @return byte[]
   * @param datos byte[]
   */
  public byte[] decrypt(byte[] datos) {
    if (!iniDec) {
      return null;
    }
    return hazDes(datos, dec);
  }

  /**
   * Insert the method's description here. Creation date: (10/02/2003 12:43:49
   * p.m.)
   *
   * @return byte[]
   * @param datos byte[]
   */
  public byte[] encrypt(byte[] datos) {
    if (!iniEnc) {
      return null;
    }
    return hazDes(datos, enc);
  }

  /**
   * Insert the method's description here. Creation date: (11/02/2003 02:29:07
   * a.m.)
   *
   * @return byte[]
   * @param entrada byte[]
   */
  public byte[] hazDes(byte[] entrada, int[] key) {
    int[] temp = convBytesToInts(entrada);
    // Generaci�n de DES
    int fval, work, der, izq, round;
    int keysi = 0;
    izq = temp[0];
    der = temp[1];
    work = ((izq >>> 4) ^ der) & 0x0f0f0f0f;
    der ^= work;
    izq ^= (work << 4);

    work = ((izq >>> 16) ^ der) & 0x0000ffff;
    der ^= work;
    izq ^= (work << 16);

    work = ((der >>> 2) ^ izq) & 0x33333333;
    izq ^= work;
    der ^= (work << 2);

    work = ((der >>> 8) ^ izq) & 0x00ff00ff;
    izq ^= work;
    der ^= (work << 8);
    der = (der << 1) | ((der >>> 31) & 1);

    work = (izq ^ der) & 0xaaaaaaaa;
    izq ^= work;
    der ^= work;
    izq = (izq << 1) | ((izq >>> 31) & 1);

    for (round = 0; round < 8; round++) {
      work = (der << 28) | (der >>> 4);
      work ^= key[keysi++];
      fval = SP[6][work & 0x0000003f];
      fval |= SP[4][(work >>> 8) & 0x0000003f];
      fval |= SP[2][(work >>> 16) & 0x0000003f];
      fval |= SP[0][(work >>> 24) & 0x0000003f];
      work = der ^ key[keysi++];
      fval |= SP[7][work & 0x0000003f];
      fval |= SP[5][(work >>> 8) & 0x0000003f];
      fval |= SP[3][(work >>> 16) & 0x0000003f];
      fval |= SP[1][(work >>> 24) & 0x0000003f];
      izq ^= fval;
      work = (izq << 28) | (izq >>> 4);
      work ^= key[keysi++];
      fval = SP[6][work & 0x0000003f];
      fval |= SP[4][(work >>> 8) & 0x0000003f];
      fval |= SP[2][(work >>> 16) & 0x0000003f];
      fval |= SP[0][(work >>> 24) & 0x0000003f];
      work = izq ^ key[keysi++];
      fval |= SP[7][work & 0x0000003f];
      fval |= SP[5][(work >>> 8) & 0x0000003f];
      fval |= SP[3][(work >>> 16) & 0x0000003f];
      fval |= SP[1][(work >>> 24) & 0x0000003f];
      der ^= fval;
    }

    der = (der << 31) | (der >>> 1);
    work = (izq ^ der) & 0xaaaaaaaa;
    izq ^= work;
    der ^= work;
    izq = (izq << 31) | (izq >>> 1);
    work = ((izq >>> 8) ^ der) & 0x00ff00ff;
    der ^= work;
    izq ^= (work << 8);
    work = ((izq >>> 2) ^ der) & 0x33333333;
    der ^= work;
    izq ^= (work << 2);
    work = ((der >>> 16) ^ izq) & 0x0000ffff;
    izq ^= work;
    der ^= (work << 16);
    work = ((der >>> 4) ^ izq) & 0x0f0f0f0f;
    izq ^= work;
    der ^= (work << 4);
    temp[0] = der;
    temp[1] = izq;
    return convIntsToBytes(temp);
  }

  /**
   * Insert the method's description here. Creation date: (10/02/2003 12:47:13
   * p.m.)
   *
   * @param key byte[]
   * @param encriptar boolean
   */
  public void setKey(byte[] keyIn, boolean encriptar) {
    int[] destino = null;
    if (keyIn == null) {
      return;
    }
    if (encriptar) {
      destino = enc;
      iniEnc = true;
    } else {
      destino = dec;
      iniDec = true;
    }
    byte[] key = new byte[8];
    // Primero copiamos la llave a nuestro buffer local
    int tamKey = keyIn.length;
    if (tamKey > 8) {
      tamKey = 8;
    }
    System.arraycopy(keyIn, 0, key, 0, tamKey);
    // Ahora revisamos si alg�n byte de la llave tiene bits pares,
    // para fijar la paridad en non (cumplir con el standard).
    for (int i = 0; i < 8; i++) {
      int j = unos[key[i] & 0x0f] + unos[(key[i] & 0xf0) >> 4];
      if ((j & 1) == 0) { // el numero de unos es par, hacemos un xor
        key[i] ^= 1;
      }
    }
    // Ahora convertimos la llave en una llave interna
    int i, j, l, m, n;
    int[] pc1m = new int[56];
    int[] pcr = new int[56];
    int[] kn = new int[32];
    byte[] pc1 = {(byte) 56, (byte) 48, (byte) 40, (byte) 32, (byte) 24,
      (byte) 16, (byte) 8, (byte) 0, (byte) 57, (byte) 49, (byte) 41,
      (byte) 33, (byte) 25, (byte) 17, (byte) 9, (byte) 1, (byte) 58,
      (byte) 50, (byte) 42, (byte) 34, (byte) 26, (byte) 18,
      (byte) 10, (byte) 2, (byte) 59, (byte) 51, (byte) 43,
      (byte) 35, (byte) 62, (byte) 54, (byte) 46, (byte) 38,
      (byte) 30, (byte) 22, (byte) 14, (byte) 6, (byte) 61,
      (byte) 53, (byte) 45, (byte) 37, (byte) 29, (byte) 21,
      (byte) 13, (byte) 5, (byte) 60, (byte) 52, (byte) 44,
      (byte) 36, (byte) 28, (byte) 20, (byte) 12, (byte) 4,
      (byte) 27, (byte) 19, (byte) 11, (byte) 3};
    byte[] bytebit = {(byte) 0x80, (byte) 0x40, (byte) 0x20, (byte) 0x10,
      (byte) 0x08, (byte) 0x04, (byte) 0x02, (byte) 0x01};
    int[] totrot = {1, 2, 4, 6, 8, 10, 12, 14, 15, 17, 19, 21, 23, 25, 27,
      28};
    byte[] pc2 = {(byte) 13, (byte) 16, (byte) 10, (byte) 23, (byte) 0,
      (byte) 4, (byte) 2, (byte) 27, (byte) 14, (byte) 5, (byte) 20,
      (byte) 9, (byte) 22, (byte) 18, (byte) 11, (byte) 3, (byte) 25,
      (byte) 7, (byte) 15, (byte) 6, (byte) 26, (byte) 19, (byte) 12,
      (byte) 1, (byte) 40, (byte) 51, (byte) 30, (byte) 36,
      (byte) 46, (byte) 54, (byte) 29, (byte) 39, (byte) 50,
      (byte) 44, (byte) 32, (byte) 47, (byte) 43, (byte) 48,
      (byte) 38, (byte) 55, (byte) 33, (byte) 52, (byte) 45,
      (byte) 41, (byte) 49, (byte) 35, (byte) 28, (byte) 31,};
    int[] bigbyte = {0x800000, 0x400000, 0x200000, 0x100000, 0x080000,
      0x040000, 0x020000, 0x010000, 0x008000, 0x004000, 0x002000,
      0x001000, 0x000800, 0x000400, 0x000200, 0x000100, 0x000080,
      0x000040, 0x000020, 0x000010, 0x000008, 0x000004, 0x000002,
      0x000001};
    for (j = 0; j < 56; j++) {
      l = pc1[j];
      m = l & 07;
      pc1m[j] = ((key[l >>> 3] & bytebit[m]) != 0) ? 1 : 0;
    }
    for (i = 0; i < 16; i++) {
      if (encriptar) {
        m = i << 1;
      } else {
        m = (15 - i) << 1;
      }
      n = m + 1;
      kn[m] = kn[n] = 0;
      for (j = 0; j < 28; j++) {
        l = j + totrot[i];
        if (l < 28) {
          pcr[j] = pc1m[l];
        } else {
          pcr[j] = pc1m[l - 28];
        }
      }
      for (j = 28; j < 56; j++) {
        l = j + totrot[i];
        if (l < 56) {
          pcr[j] = pc1m[l];
        } else {
          pcr[j] = pc1m[l - 28];
        }
      }
      for (j = 0; j < 24; j++) {
        if (pcr[pc2[j]] != 0) {
          kn[m] |= bigbyte[j];
        }
        if (pcr[pc2[j + 24]] != 0) {
          kn[n] |= bigbyte[j];
        }
      }
    }
    for (i = 0, j = 0, l = 0; i < 16; i++) {
      m = kn[j++];
      n = kn[j++];
      destino[l] = (m & 0x00fc0000) << 6;
      destino[l] |= (m & 0x00000fc0) << 10;
      destino[l] |= (n & 0x00fc0000) >>> 10;
      destino[l] |= (n & 0x00000fc0) >>> 6;
      l++;
      destino[l] = (m & 0x0003f000) << 12;
      destino[l] |= (m & 0x0000003f) << 16;
      destino[l] |= (n & 0x0003f000) >>> 4;
      destino[l] |= (n & 0x0000003f);
      l++;
    }
  }
}
