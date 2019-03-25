package com.redhat.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenerateOOM
 */
@WebServlet("/boom")
public class GenerateOOM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateOOM() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cont = 20;
		System.out.println("\n=> OOM teste iniciado ..\n");
		for (int contExterno = 1; contExterno < 20; contExterno++) {
			System.out.println("Iteração: " + contExterno + " Memoria livre: " + Runtime.getRuntime().freeMemory());
			int repete = 2;
			int[] arrayInteiro = new int[cont];
			// Coloca em loop o preenchimento do array de int..
			do {
				arrayInteiro[repete] = 0;
				repete--;
			} while (repete > 0);
			cont = cont * 5;
			System.out.println("\nMemoria necessaria para proxima iteração: " + cont);

		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
