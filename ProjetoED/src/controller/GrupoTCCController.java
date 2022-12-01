package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.GrupoTCC;

public class GrupoTCCController {
	
	public void removerGrupo(String nome, String caminho, String nomeArquivo) throws Exception {
		File diretorio = new File(caminho);
		
		if (!diretorio.exists() || !diretorio.isDirectory()) {
			return;
		}
		
		File arquivo = new File(caminho, nomeArquivo);
		
		FileReader ler = new FileReader(arquivo);
		BufferedReader textoLido = new BufferedReader(ler);
		
		StringBuilder buffer = new StringBuilder("");
		while (textoLido.ready()) {
			String linha = textoLido.readLine();
			
			if (linha == null || linha.isEmpty() || linha.isBlank() || !linha.contains(";")) {
				continue;
			}
			
			String[] grupoCSV = linha.split(";");
			if (nome.equals(grupoCSV[1])) {
				continue;
			}
			
			buffer.append(linha + "\n");
		}
		
		FileWriter abreArquivo = new FileWriter(arquivo);
		PrintWriter escreveArq = new PrintWriter(abreArquivo);
		
		escreveArq.write(buffer.toString());
		escreveArq.flush();
		escreveArq.close();
		abreArquivo.close();
	}
	
	public void criaGrupo(GrupoTCC grupo, String caminho, String nomeArquivo) throws Exception {
		File dir = new File(caminho);
		
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(caminho, nomeArquivo);
			
			FileReader ler = new FileReader(arq);
			BufferedReader textoLido = new BufferedReader(ler);
			
			StringBuilder sb = new StringBuilder("");
			while (textoLido.ready()) {
				String linha = textoLido.readLine();
				
				if (linha == null || linha.isEmpty() || linha.isBlank()) {
					continue;
				}
			
				sb.append(linha);
				sb.append("\n");
			}
			
			StringBuilder buffer = new StringBuilder();
			StringBuilder linha = new StringBuilder("");
			linha.append(grupo.modalidade + ";" + grupo.nome + ";" + grupo.professor + ";" + grupo.tema + ";");
			
			String[] array1 = grupo.nomeIntegrantes;
			final int QUANTIDADE_INTEGRANTES = array1.length;
			
			if (QUANTIDADE_INTEGRANTES > 0) {
				linha.append(array1[0]);
				
				for (int i=1; i<QUANTIDADE_INTEGRANTES; i++) {
					linha.append("|" + array1[i]);
				}
			}
			
			buffer.append(linha);
			
			FileWriter abreArquivo = new FileWriter(arq);
			PrintWriter escreveArq = new PrintWriter(abreArquivo);
			
			escreveArq.write(sb.toString() + buffer.toString());
			escreveArq.flush();
			escreveArq.close();
			abreArquivo.close();
		} 
		else {
			throw new IOException("Diretório inválido");
		}
	}

	public void alteraGrupo(GrupoTCC grupoTCC, String caminho, String nomeArquivo) throws Exception {
		File diretorio = new File(caminho);
		
		if (!diretorio.exists() || !diretorio.isDirectory()) {
			return;
		}
		
		File arquivo = new File(caminho, nomeArquivo);
		
		FileReader ler = new FileReader(arquivo);
		BufferedReader textoLido = new BufferedReader(ler);
		
		StringBuilder buffer = new StringBuilder("");
		while (textoLido.ready()) {
			String linha = textoLido.readLine();
			
			if (linha == null || linha.isEmpty() || linha.isBlank() || !linha.contains(";")) {
				continue;
			}
			
			String[] grupoCSV = linha.split(";");
			if (grupoTCC.nome.equals(grupoCSV[1])) {
				linha = grupoTCC.modalidade + ";" + grupoTCC.nome + ";" + grupoTCC.professor + ";" + grupoTCC.tema + ";";
				
				String[] array1 = grupoTCC.nomeIntegrantes;
				final int QUANTIDADE_INTEGRANTES = array1.length;
				
				if (QUANTIDADE_INTEGRANTES > 0) {
					linha += array1[0];
					
					for (int i=1; i<QUANTIDADE_INTEGRANTES; i++) {
						linha += "|" + array1[i];
					}
				}
			}
			
			buffer.append(linha + "\n");
		}
		
		FileWriter abreArquivo = new FileWriter(arquivo);
		PrintWriter escreveArq = new PrintWriter(abreArquivo);
		
		escreveArq.write(buffer.toString());
		escreveArq.flush();
		escreveArq.close();
		abreArquivo.close();
	}
}