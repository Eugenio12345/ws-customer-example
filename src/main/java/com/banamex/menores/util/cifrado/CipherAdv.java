package com.banamex.menores.util.cifrado;

/**
 * Insert the type's description here.
 * Creation date: (28/04/2008)
 * @author: DMDULTRA
 */
public class CipherAdv {
        private BasicCipher[] enc = null;
        private BasicCipher[] dec = null;
        private boolean iniEnc = false;
        private boolean iniDec = false;
/**
 * JonDes3Cipher constructor comment.
 */
public CipherAdv() {
        super();
}
/**
 * JonDes3Cipher constructor comment.
 * @param key byte[]
 */
public CipherAdv(byte[] key) {
        super();
        setKey(key, true);
        setKey(key, false);
}
/**
 * Insert the method's description here.
 * Creation date: (11/02/2003 07:20:26 p.m.)
 * @return byte[]
 * @param datos byte[]
 */
public byte[] decrypt(byte[] datos) {
        if (!iniDec) {
                return null;
        }
        //Reglas:
        //1. Si solamente hay un elemento en dec, se utiliza directo el decrypt
        //2. Si hay dos elementos, se decripta con el primero, se encripta con
        //	 el segundo y se vuelve a decriptar con el primero.
        //3. Si hay tres elementos, se decripta con el tercero, se encripta con el
        //	 segundo y se decripta con el primero.
        if (dec.length == 1) {
                return dec[0].decrypt(datos);
        }
        byte[] primero = null;
        if (dec.length == 2) {
                primero = dec[0].decrypt(datos);
        } else {
                primero = dec[2].decrypt(datos);
        }
        byte[] segundo = dec[1].encrypt(primero);
        return dec[0].decrypt(segundo);
}
/**
 * Insert the method's description here.
 * Creation date: (11/02/2003 08:17:48 p.m.)
 * @param datos byte[]
 */
public byte[] decryptAll(byte[] datos) {
        if (!iniDec) {
                return null;
        }
        //En esta funcion quitamos el padding de acuerdo al PKCS#5:
        //Reglas:
        //	1. Se desencriptan todos los datos a un buffer
        //	2. Se obtiene el valor del ultimo byte
        //	3. Si el valor es menor que 1 o mayor que 8, no hacemos nada (PKCS5 mal!)
        //	4. Se le quitan tantos bytes como se define por el valor del ultimo byte.
        byte[] datosPkcs5 = new byte[datos.length];
        byte[] temp = new byte[8];
        for (int i = 0; i < datos.length / 8; i++) {
                System.arraycopy(datos, i * 8, temp, 0, 8);
                byte[] unBloque = decrypt(temp);
                System.arraycopy(unBloque, 0, datosPkcs5, i * 8, 8);
        }
        //Ahora obtenemos el ultimo byte:
        int tam = (int)datosPkcs5[datosPkcs5.length - 1];
        if (tam < 1 || tam > 8 || datosPkcs5.length < tam) {
                return null; //Est� mal el encoding de PKCS5
        }
        //Solamente para revisar el encoding, tenemos que ver los bytes
        for (int i = 0; i < tam; i++) {
                if ((int)datosPkcs5[datosPkcs5.length - i - 1] != tam) {
                        return null; //Est� mal el encoding de PKCS5
                }
        }
        byte[] datosRes = new byte[datosPkcs5.length - tam];
        System.arraycopy(datosPkcs5, 0, datosRes, 0, datosRes.length);
        return datosRes;
}
/**
 * Insert the method's description here.
 * Creation date: (11/02/2003 07:20:50 p.m.)
 * @return byte[]
 * @param datos byte[]
 */
public byte[] encrypt(byte[] datos) {
        if (!iniEnc) {
                return null;
        }
        //Reglas:
        //1. Si solamente hay un elemento en enc, se utiliza directo el encript
        //2. Si hay dos elementos, se encripta con el primero, se decripta con
        //	 el segundo y se vuelve a encriptar con el primero.
        //3. Si hay tres elementos, se encripta con el primero, se decripta con el
        //	 segundo y se encripta con el tercero.
        byte[] primero = enc[0].encrypt(datos);
        if (enc.length == 1) {
                return primero;
        }
        byte[] segundo = enc[1].decrypt(primero);
        if (enc.length == 2) {
                return enc[0].encrypt(segundo);
        }
        return enc[2].encrypt(segundo);
}
/**
 * Insert the method's description here.
 * Creation date: (11/02/2003 08:17:18 p.m.)
 * @return byte[]
 * @param datos byte[]
 */
public byte[] encryptAll(byte[] datos) {
        if (!iniEnc) {
                return null;
        }
        //En esta funcion si ponemos el padding apropiado de acuerdo al PKCS#5:
        //Reglas:
        //	1. Se agregan tantos bytes como se requiera para que la longitud sea
        //		multiplo de 8. Si la entrada ya es multiplo de 8, se agrega un bloque
        //		completo de 8 bytes.
        //	2. Cada uno de los bytes agregados de padding se llenan con el valor del
        //		Numero de bytes agregados. Si se agreg� 1 byte, debe tener valor 01,
        //		si se agregaron 2, deben ambos tener valor 02, etc.
        int tam = 8 - (datos.length % 8);
        byte[] datosPkcs5 = new byte[datos.length + tam];
        System.arraycopy(datos, 0, datosPkcs5, 0, datos.length);
        for (int i = 0; i < tam; i++) {
                datosPkcs5[datos.length + i] = (byte)tam;
        }
        byte[] temp = new byte[8];
        for (int i = 0; i < datosPkcs5.length / 8; i++) {
                System.arraycopy(datosPkcs5, i * 8, temp, 0, 8);
                byte[] unBloque = encrypt(temp);
                System.arraycopy(unBloque, 0, datosPkcs5, i * 8, 8);
        }
        return datosPkcs5;
}
/**
 * Insert the method's description here.
 * Creation date: (11/02/2003 07:09:26 p.m.)
 * @param key byte[]
 * @param encriptar boolean
 */
public void setKey(byte[] keyIn, boolean encriptar) {
        //Esta llave debe ser de 16 o 24 bytes!
        //Para encriptar tengo dos o tres instancias de JonBasicCipher
        //Para desencriptar tengo dos o tres instancias de JonBasicCipher
        BasicCipher[] destino = null;
        if (keyIn.length != 8 && keyIn.length != 16 && keyIn.length != 24) {
                //out.println("Esta mal la llave");
                return;
        }
        if (encriptar) {
                enc = new BasicCipher[keyIn.length / 8];
                destino = enc;
                iniEnc = true;
        } else {
                dec = new BasicCipher[keyIn.length / 8];
                destino = dec;
                iniDec = true;
        }
        for (int i = 0; i < keyIn.length / 8; i++) {
                byte[] estaLlave = new byte[8];
                System.arraycopy(keyIn, i * 8, estaLlave, 0, 8);
                destino[i] = new BasicCipher();
                destino[i].setKey(estaLlave, encriptar);
                encriptar = !encriptar; //Switcheamos para alternar entre encripci�n y desenc.
        }
}
}
