package es.curso.java.proyectofinal.enums;

import java.util.Date;

import es.curso.java.proyectofinal.utils.UtilsFecha;

public enum UsuariosEnum {
	
	USUARIO1("Nombre1","Apellido1","DNI1", "masculino", "password1", "email1@email.mil", 111111111, (new UtilsFecha ()).generaFecha(86, 11, 18), "administrador"),
	USUARIO2("Nombre2","Apellido2","DNI2", "femenino", "password2", "email2@email.mil", 222222222, (new UtilsFecha ()).generaFecha(83, 02, 16), "administrador y moderador"),
	USUARIO3("Nombre3","Apellido3","DNI3", "masculino", "password3", "email3@email.mil", 333333333, (new UtilsFecha ()).generaFecha(76, 12, 15), "usuario"),
	USUARIO4("Nombre4","Apellido4","DNI4", "otro", "password4", "email4@email.mil", 444444444, (new UtilsFecha ()).generaFecha(97, 07, 17), "usuario"),
	USUARIO5("Nombre5","Apellido5","DNI5", "femenino", "password5", "email5@email.mil", 555555555, (new UtilsFecha ()).generaFecha(75, 8, 05), "usuario y administrador");
	
		
	private long id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String sexo;
	private String contraseña;
	private String mail;
	private long telefono;
	private Date fechaNacimiento;
	private String roles;
	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sexo
	 * @param contraseña
	 * @param mail
	 * @param teléfono
	 * @param fechaNacimiento
	 * @param roles
	 */
	private UsuariosEnum(long id, String nombre, String apellidos, String dni, String sexo, String contraseña,
			String mail, long telefono, Date fechaNacimiento, String roles) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.contraseña = contraseña;
		this.mail = mail;
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
	 * @param mail
	 * @param teléfono
	 * @param fechaNacimiento
	 * @param roles
	 */
	private UsuariosEnum(String nombre, String apellidos, String dni, String sexo, String contraseña, String mail,
			long telefono, Date fechaNacimiento, String roles) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sexo = sexo;
		this.contraseña = contraseña;
		this.mail = mail;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.roles = roles;
	}
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
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return the teléfono
	 */
	public long getTelefono() {
		return telefono;
	}
	/**
	 * @param teléfono the teléfono to set
	 */
	public void setTeléfono(long telefono) {
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
	 * @return the roles
	 */
	public String getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}
		
}
