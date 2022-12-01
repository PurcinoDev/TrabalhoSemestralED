package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.leandrocolevati.Lista.Lista;
import model.GrupoTCC;

public class ControllerCadastro {

	public ControllerCadastro() {
		super();
	}

	public String[] fileToList(Tipo tipo, String caminho, String nomeArquivo) throws Exception {
		File dir = new File(caminho);
	
		if (!dir.exists() || !dir.isDirectory()) {
			return null;
		}
		
		Lista l = new Lista();
		File arq = new File(caminho, nomeArquivo);

		return tipo.gerar(arq, l);
	}
}