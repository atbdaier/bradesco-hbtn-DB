package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Aluno {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;

    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento")
    private Date nascimento;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos;

    @ManyToMany(mappedBy = "alunos", cascade = CascadeType.ALL)
    private List<Curso> cursos;

    public Aluno() {
        this.telefones = new ArrayList<>();
        this.enderecos = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public Aluno(String nomeCompleto, String matricula, Date nascimento, String email) {
        this();
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.nascimento = nascimento;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}