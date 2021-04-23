package com.cleberazevedo;

import java.util.Scanner;

public class CifraVigenere {

    public static String encrypt(final String message, final String key) {

        String result = "";

        for (int i = 0, j = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    result += (char) ((c + key.toUpperCase().charAt(j) - 2 * 'A') % 26 + 'A');

                } else {
                    result += (char) ((c + key.toLowerCase().charAt(j) - 2 * 'a') % 26 + 'a');
                }
            } else {
                result += c;
            }
            j = ++j % key.length();
        }
        return result;
    }

    private static String prompt(String promptText, Scanner sc, int minLen) {
        String s;
        do {
            System.out.print(promptText);
            s = sc.nextLine().trim();
        } while (s.length() < minLen);
        return s;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = prompt("Entre com a Mensagem: ", sc, 1);
        String key = prompt("Entre com a chave: ", sc, 6);
        System.out.println(text);
        String ciphertext = encrypt(text, key);
        System.out.println(ciphertext);
    }
}