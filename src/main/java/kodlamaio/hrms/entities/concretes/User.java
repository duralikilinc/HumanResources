package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public class User {

	@Id
	@Column(name="id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="email",nullable = false,unique = true)
	private String email;
	
	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="email_verify",nullable = false)
	private boolean email_verify;
	
	@Column(nullable = true)
	private String repeat_password;
}
