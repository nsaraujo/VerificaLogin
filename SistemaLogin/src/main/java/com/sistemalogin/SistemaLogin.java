/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sistemalogin;

/**
 *
 * @author 55649
 */
public class SistemaLogin {

    public static void main(String[] args) {

        Singleton login = Singleton.getInstance();

        login.login_usuario();

        // Quando eu tentar fazer o login de novo, a instância única não vai permitir
        login.login_usuario();

    }
}
