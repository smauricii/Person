package Taller3;

public class Cuenta {

	private String nombre;
	private String numeroCuenta;
	private double tipoInteres;
	private double saldo;

	public Cuenta() {
	}

	public Cuenta(String nombre, String numeroCuenta, double tipoInteres, double saldo) {
		this.nombre = nombre;
		this.numeroCuenta = numeroCuenta;
		this.tipoInteres = tipoInteres;
		this.saldo = saldo;
	}

	public Cuenta(final Cuenta copia) {
		nombre = copia.nombre;
		numeroCuenta = copia.numeroCuenta;
		tipoInteres = copia.tipoInteres;
		saldo = copia.saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getTipoInteres() {
		return tipoInteres;
	}

	public double getSaldo() {
		return saldo;
	}

	public boolean ingreso(double ingre) {
		boolean ingreso = true;
		if (ingre < 0) {
			ingreso = false;
		} else {
			saldo = saldo + ingre;
		}
		return ingreso;
	}

	public boolean reintegro(double reint) {
		boolean reintegro = true;
		if (reint < 0) {
			reintegro = false;
		} else if (saldo >= reint) {
			saldo -= reint;
		} else {
			reintegro = false;
		}
		return reintegro;
	}

	public boolean transferencia(Cuenta cuenta, double trans) {
		boolean transferencia = true;
		if (trans < 0) {
			transferencia = false;
		} else if (saldo >= trans) {
			reintegro(trans);
			cuenta.ingreso(trans);
		} else {
			transferencia = false;
		}
		return transferencia;
	}
}
