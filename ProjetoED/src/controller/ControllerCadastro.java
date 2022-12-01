package controller;

import model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.io.IOException;
import br.com.leandrocolevati.Lista.Lista;

public class ControllerCadastro {

	public ControllerCadastro() {
		super();
	}

	public String[] fileToList(String tipoUsuario, String caminho, String nomeArquivo) throws Exception {
	
		File dir = new File(caminho);
	
		if (dir.exists() && dir.isDirectory()) {
			Lista l = new Lista();
			File arq = new File(caminho, nomeArquivo);
	
			if (tipoUsuario == "professor") {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leFluxo = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leFluxo);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains(";")) {
						String[] vetorDeLinha = linha.split(";");
						Professor professor = new Professor();
						professor.nome = vetorDeLinha[0];
						professor.usuario = vetorDeLinha[1];
						professor.curso = vetorDeLinha[2];
						professor.email = vetorDeLinha[3];
						professor.especialidade = vetorDeLinha[4];
						professor.horaInicioDisp = new SimpleDateFormat("HH:mm").parse(vetorDeLinha[5]);
						professor.horaFimDisp = new SimpleDateFormat("HH:mm").parse(vetorDeLinha[6]);
						professor.senha = vetorDeLinha[7];
						professor.exp = vetorDeLinha[8];
						professor.coordenador = Boolean.valueOf(vetorDeLinha[7]);
						if (l.isEmpty()) {
							l.addFirst(professor);
						} else {
							l.addLast(professor);
						}

						linha = buffer.readLine();
					}
				}
				buffer.close();
				leFluxo.close();
				fluxo.close();
				return defineArrayNomeProfessor(l);
				
			} else if (tipoUsuario == "aluno") {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leFluxo = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leFluxo);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains(";")) {
						String[] vetorDeLinha = linha.split(";");
						Aluno aluno = new Aluno();
						aluno.nome = vetorDeLinha[0];
						aluno.usuario = vetorDeLinha[1];
						aluno.curso = vetorDeLinha[2];
						aluno.email = vetorDeLinha[3];
						aluno.semestre = vetorDeLinha[4];
						aluno.turno = vetorDeLinha[5];
						aluno.senha = vetorDeLinha[6];
						aluno.RA = Double.parseDouble(vetorDeLinha[7]);
						if (l.isEmpty()) {
							l.addFirst(aluno);
						} else {
							l.addLast(aluno);
						}

						linha = buffer.readLine();
					}
				}
				buffer.close();
				leFluxo.close();
				fluxo.close();
				return defineArrayNomesAlunos(l);
			}
		}
		
		return null;
	}
	
	private String[] defineArrayNomeProfessor(Lista l) {
		int contador = l.size();
		String[] vetorNomes = new String[contador];
		while (contador < 0) {
			try {
				Professor prof = new Professor();
				prof = (Professor) l.get(contador);
				vetorNomes[contador] = prof.nome;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vetorNomes;
	}

	private String[] defineArrayNomesAlunos(Lista l) {
		int contador = l.size() - 1;
		String[] vetorNomes = new String[contador + 1];
		while (contador >= 0) {
			try {
				Aluno aluno = new Aluno();
				aluno = (Aluno) l.get(contador);
				vetorNomes[contador] = aluno.nome;
			} catch (Exception e) {
				e.printStackTrace();
			}
			contador--;
		}
		return vetorNomes;
		
	}
	
	public void criaGrupo(GrupoTCC grupo, String caminho, String nomeArquivo) throws Exception {
		File dir = new File(caminho);
		
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(caminho, nomeArquivo);
			
			StringBuffer buffer = new StringBuffer();
			String linha = "";
			linha = grupo.modalidade + ";" + grupo.nome + ";" + grupo.Professor + ";" + grupo.tema;
			
			String[] array1 = grupo.nomeIntegrantes;
			int aux2 = array1.length;
			for (int i = 0; i < aux2; i++) {
				linha += array1[i];
			}
			buffer.append(linha);
			
			FileWriter abreArquivo = new FileWriter(arq);
			PrintWriter escreveArq = new PrintWriter(abreArquivo);
			escreveArq.write(buffer.toString());
			escreveArq.flush();
			escreveArq.close();
			abreArquivo.close();
		} else {
			throw new IOException("Diretório inválido");
		}
	}
	
	public void deleteGrupo(String caminho, String nomeArquivo) {
		File arq = new File(caminho, nomeArquivo);
		arq.delete();
	}

}
