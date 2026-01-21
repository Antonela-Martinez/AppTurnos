package ar.com.am.enums;

//Enum parametrizado
public enum Roles {
	PROF("Profesional"),
	ADMIN("Administrador");
	
	private String rol;

	Roles(String rol) {
		this.rol = rol;
	}

	//Private Roles(String rol) {
		//this.rol = rol;
	//}

	public String getRol() {
		return rol;
	}


}
