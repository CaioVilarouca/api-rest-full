package com.demo.api.domain;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity // Marca uma classe como representando uma tabela do banco
public class User implements Serializable{ // Trafegar em rede 

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Informando q esse ID vai ser uma key primary
    private Integer id;
    
    // Informar q esse campo não pode ser vazio 
    @NotEmpty(message = "Campo NOME é mandatório")
    private String name;
    
 // Informar q esse campo não pode ser vazio 
    @NotEmpty(message = "Campo LOGIN é mandatório")
    private String login;
    
 // Informar q esse campo não pode ser vazio 
    @NotEmpty(message = "Campo SENHA é mandatório")
    @Length(min = 8, message = "Senha deve conter no minímo 8 caracteres")
    private String password;

    public User() {}

	public User(Integer id, String name, String login, String password) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassoword() {
		return password;
	}

	public void setPassoword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override // Comparação os IDs
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
