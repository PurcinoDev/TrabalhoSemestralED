package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import br.com.leandrocolevati.Lista.Lista;
import model.Aluno;
import model.Professor;

public class ControllerCadastro {
	
	public ControllerCadastro() {
		super();
	}
	
	public void readArquivoAluno(String caminho, String curso) {
		
	}
	
	public void readArquivoProfessor(String caminho, String curso) throws Exception {
		if (curso == "ADS") {
			fileToListProfessor("C:\\", "Professores_ADS");
		} else if (curso == "COMEX") {
			fileToListProfessor("C:\\", "Professores_COMEX");
		} else if (curso == "POLIM") {
			fileToListProfessor("C:\\", "Professores_POLIM");
		} else if (curso == "LOG") {
			fileToListProfessor("C:\\", "Professores_LOG");
		}
	}

	public void fileToListProfessor(String caminho, String nomeArquivo) throws Exception {

		File dir = new File(caminho);

		if (dir.exists() && dir.isDirectory()) {
			Lista lProfessores = new Lista();
			File arq = new File(caminho, nomeArquivo);

			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();

			while (linha != null) {
				if (linha.contains(";")) {
					String[] vetorDeLinha = linha.split(";");
					Professor professor = new Professor();
					professor.usuario = vetorDeLinha[0];
					professor.curso = vetorDeLinha[1];
					professor.email = vetorDeLinha[2];
					professor.especialidade = vetorDeLinha[3];
					professor.horaInicioDisp = new SimpleDateFormat("HH:mm").parse(vetorDeLinha[4]);
					professor.horaFimDisp = new SimpleDateFormat("HH:mm").parse(vetorDeLinha[5]);
					professor.senha = vetorDeLinha[6];
					professor.exp = vetorDeLinha[7];
					professor.coordenador = Boolean.valueOf(vetorDeLinha[7]);
					if (lProfessores.isEmpty()) {
						lProfessores.addFirst(professor);
					} else {
						lProfessores.addLast(professor);
					}

					linha = buffer.readLine();
				}
			}
			buffer.close();
			leFluxo.close();
			fluxo.close();
		}
	}

	public void insereArquivoAluno(String caminho, String nomeArquivo) throws Exception {

		File dir = new File(caminho);

		if (dir.exists() && dir.isDirectory()) {
			Lista lAluno = new Lista();
			File arq = new File(caminho, nomeArquivo);

			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();

			while (linha != null) {
				if (linha.contains(";")) {
					String[] vetorDeLinha = linha.split(";");
					Aluno aluno = new Aluno();
					aluno.usuario = vetorDeLinha[0];
					aluno.curso = vetorDeLinha[1];
					aluno.email = vetorDeLinha[2];
					aluno.semestre = vetorDeLinha[3];
					aluno.turno = vetorDeLinha[4];
					aluno.senha = vetorDeLinha[5];
					aluno.RA = Double.parseDouble(vetorDeLinha[6]);
					if (lAluno.isEmpty()) {
						lAluno.addFirst(aluno);
					} else {
						lAluno.addLast(aluno);
					}

					linha = buffer.readLine();
				}
			}
			buffer.close();
			leFluxo.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}

	}

	public void insereArquivoProfessor(String caminho, String nomeArquivo) throws Exception {

		File dir = new File(caminho);

		if (dir.exists() && dir.isDirectory()) {
			Lista lProfessor = new Lista();
			File arq = new File(caminho, nomeArquivo);

			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();

			while (linha != null) {
				if (linha.contains(";")) {
					String[] vetorDeLinha = linha.split(";");
					Professor professor = new Professor();
					professor.usuario = vetorDeLinha[0];
					professor.curso = vetorDeLinha[1];
					professor.email = vetorDeLinha[2];
					professor.especialidade = vetorDeLinha[3];
					professor.horaInicioDisp = new SimpleDateFormat("HH:mm").parse(vetorDeLinha[4]);
					professor.horaFimDisp = new SimpleDateFormat("HH:mm").parse(vetorDeLinha[5]);
					professor.senha = vetorDeLinha[6];
					professor.exp = vetorDeLinha[7];
					professor.coordenador = Boolean.valueOf(vetorDeLinha[7]);
					if (lProfessor.isEmpty()) {
						lProfessor.addFirst(professor);
					} else {
						lProfessor.addLast(professor);
					}

					linha = buffer.readLine();
				}
			}
			buffer.close();
			leFluxo.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}

	}

	public void novoCadastro() {

	}

}
