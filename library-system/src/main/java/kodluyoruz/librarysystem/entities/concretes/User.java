package kodluyoruz.librarysystem.entities.concretes;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "rentals"})
public class User {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Kullanıcı adı boş bırakılamaz")
    @NotBlank
    @Column(name = "username")
    private String username;

    @NotNull(message = "Şifre boş bırakılamaz")
    @NotBlank
    @Size(min=5, max=10)
    @Column(name = "password")
    @JsonIgnore
    private String password;

    @NotNull(message = "Mail alanı doldurulmak zorunda")
    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @NotNull(message = "Telefon no doldurulmak zorunda 12 hane")
    @NotBlank
    @Pattern(regexp ="[0-9\\s]{12}")
    @Column(name = "phone")
    private String phone;

    @NotNull(message = "İsim alanı boş bırakılamaz")
    @NotBlank
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Rental> rentals;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")})
    private Set<Role> roles;
}
