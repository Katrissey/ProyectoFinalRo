package es.curso.java.proyectofinal.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//Definimos esta clase como una entidad y le decimos a Hibernate que nos genere una tabla con sus atributos, a través de anotaciones
@Entity
@Table(name = "TB_USUARIOS_PRO_FINAL")
public class UsuariosProFinal implements Serializable {

//Declaramos las variables de instancia, convirtiéndolas en columnas de la tabla que crea Hibernate al acceder a esta clase.

	// Establecemos una id como Primary Key, que es obligatorio para el uso de
	// Hibernate y la creación de las tablas a través de dicha heramienta.
	// Lo hacemos a través de anotaciones también, e este caso, además, generando
	// una secuancia única para esta clase, en vez de una secuencia común para todas
	// las clases del proyecto.
	@Id
	@SequenceGenerator(name = "USUARIOGEN", sequenceName = "USUARIO_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIOGEN")
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@Column(name = "NOMBRE_USUARIO", length = 40)
	private String nombre;

	@Column(name = "APELLIDOS", length = 80)
	private String apellidos;

	@Column(name = "DNI", length = 10, unique = true)
	private String dni;

	// Enumeración para los tipos de género
	public enum TipoGenero {
		MASCULINO, FEMENINO, OTRO
	}

//	@Enumerated(EnumType.STRING)
	@Column(name = "SEXO")
	private String sexo;

	@Column(name = "CONTRASEÑA", length = 50, nullable = false)
//	@Size (min = 8, max = 50)
//	@Pattern (regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$", message = "La contraseña debe contener al menos una letra mayúscula, una minúscula y un número")
	private String contraseña;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "TELÉFONO")
	private long telefono;

	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	// Enumeración para los tipos de role
	public enum TipoRole {
		ADMINISTRADOR, USUARIO, MODERADOR
	}

//	@Enumerated(EnumType.STRING)
	@Column(name = "ROLES") // Administrador, usuario básico o moderador
	private String roles;

	// Generamos todos los constructores, incluido el vacío, indispensable para el
	// buen funcionamiento de hibernate
	/**
	 * 
	 */
	public UsuariosProFinal() {
		super();
	}

	/**
	 * @param id
	 * @param role
	 */
	public UsuariosProFinal(long id, String roles) {
		super();
		this.id = id;
		this.roles = roles;
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param role
	 */
	public UsuariosProFinal(long id, String nombre, String apellidos, String roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.roles = roles;
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param role
	 */
	public UsuariosProFinal(long id, String nombre, String apellidos, String dni, String roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.roles = roles;
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sexo
	 * @param fechaNacimiento
	 * @param role
	 */
	public UsuariosProFinal(long id, String nombre, String apellidos, String dni, String sexo, Date fechaNacimiento,
			String roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.roles = roles;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 */
	public UsuariosProFinal(String nombre, String apellidos, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 */
	public UsuariosProFinal(String nombre, String apellidos, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param fechaNacimiento
	 */
	public UsuariosProFinal(String nombre, String apellidos, String dni, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param fechaNacimiento
	 * @param role
	 */
	public UsuariosProFinal(String nombre, String apellidos, String dni, Date fechaNacimiento, String roles) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.roles = roles;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sexo
	 */
	public UsuariosProFinal(String nombre, String apellidos, String dni, String sexo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sexo
	 * @param fechaNacimiento
	 */
	public UsuariosProFinal(String nombre, String apellidos, String dni, String sexo, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sexo
	 * @param role
	 */
	public UsuariosProFinal(String nombre, String apellidos, String dni, String sexo, String roles) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.roles = roles;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sexo
	 * @param contraseña
	 * @param email
	 * @param telefono
	 * @param role
	 */
	public UsuariosProFinal(String nombre, String apellidos, String dni, String sexo, String contraseña, String email,
			long telefono, String roles) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.contraseña = contraseña;
		this.email = email;
		this.telefono = telefono;
		this.roles = roles;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sexo
	 * @param telefono
	 * @param fechaNacimiento
	 */
	public UsuariosProFinal(String nombre, String apellidos, String dni, String sexo, long telefono,
			Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sexo
	 * @param fechaNacimiento
	 * @param role
	 */
	public UsuariosProFinal(String nombre, String apellidos, String dni, String sexo, Date fechaNacimiento,
			String roles) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.roles = roles;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sexo
	 * @param telefono
	 * @param fechaNacimiento
	 * @param role
	 */
	public UsuariosProFinal(String nombre, String apellidos, String dni, String sexo, long telefono,
			Date fechaNacimiento, String roles) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.roles = roles;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sexo
	 * @param email
	 * @param telefono
	 * @param fechaNacimiento
	 * @param role
	 */
	public UsuariosProFinal(String nombre, String apellidos, String dni, String sexo, String email, long telefono,
			Date fechaNacimiento, String roles) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.roles = roles;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sexo
	 * @param contraseña
	 * @param email
	 * @param telefono
	 * @param fechaNacimiento
	 * @param role
	 */
	public UsuariosProFinal(String nombre, String apellidos, String dni, String sexo, String contraseña, String email,
			long telefono, Date fechaNacimiento, String roles) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.contraseña = contraseña;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.roles = roles;
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sexo
	 * @param contraseña
	 * @param email
	 * @param telefono
	 * @param fechaNacimiento
	 * @param role
	 */
	public UsuariosProFinal(long id, String nombre, String apellidos, String dni, String sexo, String contraseña,
			String email, long telefono, Date fechaNacimiento, String roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.contraseña = contraseña;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.roles = roles;
	}

	// Generamos todos los Getters y Setters para que Hibernate, a través de ellos y
	// del constructor vacío pueda crear objetos

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefono
	 */
	public long getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the role
	 */
	public String getRoles() {
		return roles;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String roles) {
		this.roles = roles;
	}

//Sobreescribimos el método "To String", para, en caso de necesitar pintar algún objeto de este tipo, que lo pinte directamente
	@Override
	public String toString() {
		return "UsuariosProFinal [id=" + id + ", " + (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (apellidos != null ? "apellidos=" + apellidos + ", " : "") + (dni != null ? "dni=" + dni + ", " : "")
				+ (sexo != null ? "sexo=" + sexo + ", " : "")
				+ (contraseña != null ? "contraseña=" + contraseña + ", " : "")
				+ (email != null ? "email=" + email + ", " : "") + "telefono=" + telefono + ", "
				+ (fechaNacimiento != null ? "fechaNacimiento=" + fechaNacimiento + ", " : "")
				+ (roles != null ? "roles=" + roles : "") + "]";
	}

}
