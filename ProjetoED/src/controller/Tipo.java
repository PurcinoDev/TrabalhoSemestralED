package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import br.com.leandrocolevati.Lista.Lista;
import model.Aluno;
import model.Modalidade;
import model.Professor;

public enum Tipo {
	
	MODALIDADE {
		@Override
		public String[] gerar(File arq, Lista l) throws Exception {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();
			
			while (linha != null) {
				String[] vetorDeLinha = linha.split(";");
				Modalidade modalidade = new Modalidade();
				modalidade.descricao = vetorDeLinha[0];
				
				if (l.isEmpty()) {
					l.addFirst(modalidade);
				} 
				else {
					l.addLast(modalidade);
				}

				linha = buffer.readLine();
			}
			
			buffer.close();
			leFluxo.close();
			fluxo.close();
			
			return defineArrayModalidade(l);
		}
		
		private String[] defineArrayModalidade(Lista l) {
			int contador = l.size();
			String[] vetor = new String[contador + 1];
			
			vetor[0] = "Selecione...";
			for (int i=1; i<(contador + 1); i++) {
				try {
					vetor[i] = ((Modalidade) l.get( (i -1) )).descricao;
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return vetor;
		}
	},
	
	PROFESSOR {
		@Override
		public String[] gerar(File arq, Lista l) throws Exception {
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
		}
		
		private String[] defineArrayNomeProfessor(Lista l) {
			int contador = l.size();
			String[] vetor = new String[contador + 1];
			
			vetor[0] = "Selecione...";
			for (int i=0; i<contador; i++) {
				try {
					vetor[(i+1)] = ((Professor) l.get(i)).nome;
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return vetor;
		}
	},
	
	ALUNO {
		@Override
		public String[] gerar(File arq, Lista l) throws Exception {
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
		
		private String[] defineArrayNomesAlunos(Lista l) {
			int contador = l.size() - 1;
			String[] vetorNomes = new String[contador + 1];
			
			while (contador >= 0) {
				try {
					vetorNomes[contador] = ((Aluno) l.get(contador)).nome;
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
				contador--;
			}
			
			return vetorNomes;
			
		}
	};
	
	public String[] gerar(File arq, Lista l) throws Exception {
		return null;
	}
}