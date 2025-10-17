package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.util.Arrays;
import java.util.Date;

public class GestaoCursosMain {
    public static void main(String[] args) {
        System.out.println("Gestão de Cursos API - MOCKING DATA");

        Telefone telefone = new Telefone();
        telefone.setDDD("41");
        telefone.setNumero("98765-4321");

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Exemplo");
        endereco.setEndereco("Centro");
        endereco.setNumero("100");
        endereco.setBairro("Bairro Exemplo");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");
        endereco.setCep(12345678);

        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("João da Silva");
        aluno.setMatricula("2024001");
        aluno.setNascimento(new Date());
        aluno.setEmail("joao.silva@example.com");
        aluno.setTelefones(Arrays.asList(telefone));
        aluno.setEnderecos(Arrays.asList(endereco));
        telefone.setAluno(aluno);
        endereco.setAluno(aluno);

        MaterialCurso materialCurso = new MaterialCurso();
        materialCurso.setUrl("http://example.com/material");

        Curso curso = new Curso();
        curso.setNome("Introdução à Programação");
        curso.setSigla("IPROG");
        curso.setMaterialCurso(materialCurso);
        curso.setAlunos(Arrays.asList(aluno));


        Professor professor = new Professor();
        professor.setNomeCompleto("Maria Oliveira");
        professor.setMatricula("P2024001");
        professor.setEmail("maria.oliveira@example.com");
        professor.setCursos(Arrays.asList(curso));
        curso.setProfessor(professor);

        aluno.setCursos(Arrays.asList(curso));

        System.out.println("Gestão de Cursos API - INSERTING DATA");


        AlunoModel alunoModel = new AlunoModel();
        alunoModel.create(aluno);

        CursoModel cursoModel = new CursoModel();
        cursoModel.create(curso);
    }
}