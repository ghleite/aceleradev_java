package challenge;

import java.util.ArrayList;
import java.util.List;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {

        if(texto == null)
            throw new NullPointerException("Encrypt text is null!");

        if(texto.isEmpty())
            throw new IllegalArgumentException("Encrypt text is empty!");

        texto = texto.toLowerCase();
        String encryptedText;
        List<Character> chars = new ArrayList<>();

        for (char ch : texto.toCharArray()) {
            if (ch >= 'a' && ch <= 'z'){
                if((ch + 3) > 122)
                    ch = (char)((ch + 3) - 26);
                else
                    ch = (char)(ch + 3);
            }

            chars.add(ch);
        }

        StringBuilder sb = new StringBuilder();

        for (Character ch : chars) {
            sb.append(ch);
        }

        encryptedText = sb.toString();

        return encryptedText;

        //throw new UnsupportedOperationException("esse method nao esta implementado aainda");
    }

    @Override
    public String descriptografar(String texto) {

        if(texto == null)
            throw new NullPointerException("Decrypt text is null!");

        if(texto.isEmpty())
            throw new IllegalArgumentException("Decrypt text is empty!");

        texto = texto.toLowerCase();
        String decryptedText;
        List<Character> chars = new ArrayList<>();

        for (char ch : texto.toCharArray()) {
            if (ch >= 'a' && ch <= 'z'){
                if((ch - 3) < 97)
                    ch = (char)((ch - 3) + 26);
                else
                    ch = (char)(ch - 3);
            }

            chars.add(ch);
        }

        StringBuilder sb = new StringBuilder();

        for (Character ch : chars) {
            sb.append(ch);
        }

        decryptedText = sb.toString();

        return decryptedText;
        //throw new UnsupportedOperationException("esse method nao esta implementado aainda");
    }
}
