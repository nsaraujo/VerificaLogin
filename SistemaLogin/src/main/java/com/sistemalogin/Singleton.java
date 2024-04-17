/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemalogin;

import java.util.Scanner;

/**
 *
 * @author 55649
 */
public class Singleton {
    private static Singleton uniqueInstance;
    private String usuario;
    private String senha;
    private boolean sessao = false;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isSessao() {
        return sessao;
    }

    public void setSessao(boolean sessao) {
        this.sessao = sessao;
    }

    public void login_usuario() {
        if (sessao != true) {
            String captcha = getRandomString(6);
            String randomCode;
            Scanner scanLogin = new Scanner(System.in);

            System.out.println("Digite seu nome de usuario: ");
            setUsuario(scanLogin.nextLine());

            System.out.println("\nDigite sua senha: ");
            setSenha(scanLogin.nextLine());

            System.out.println("\nVocê é um robô? "
                    + "Digite o seguinte código: " + captcha);
            randomCode = scanLogin.nextLine();

            if (captcha.equals(randomCode)) {
                System.out.println("\nLogin realizado com sucesso ");
                setSessao(true);
            } else {
                System.out.println("\nAcesso restrito! Se você não for um robô tente novamente ");
                login_usuario();
            }
        } else {
            System.out.println("\nJá existe uma sessão ativa do usuário " + getUsuario());
            getInstance();
        }
    }

    String getRandomString(int i) {
        String theAlphaNumericS;
        StringBuilder builder;

        theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";

        builder = new StringBuilder(i);

        for (int m = 0; m < i; m++) {
            int myindex
                    = (int) (theAlphaNumericS.length() * Math.random());
            
            builder.append(theAlphaNumericS.charAt(myindex));
        }
        return builder.toString();
    }
}
