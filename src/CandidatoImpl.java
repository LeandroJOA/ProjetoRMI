import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CandidatoImpl extends UnicastRemoteObject implements Candidato {
	
	private String numero;
	private String nome;
	private String partido;
	private String cargo;
	private int votos = 0;
	
	public CandidatoImpl(String numero, String nome, String partido, String cargo) throws RemoteException {
		super();
		this.numero = numero;
		this.nome = nome;
		this.partido = partido;
		this.cargo = cargo;
	}
	
	public String obterNumero() throws RemoteException{
		return numero;
	}
	
	public String obterNome() throws RemoteException{
		return nome;
	}

	public String obterPartido() throws RemoteException{
		return partido;
	}
	
	public void creditarVoto() throws RemoteException{
		votos++;
	}
	
	public int obterVotos() throws RemoteException{
		return votos;
	}
	
}
